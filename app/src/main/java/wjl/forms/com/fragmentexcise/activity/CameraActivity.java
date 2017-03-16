package wjl.forms.com.fragmentexcise.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import wjl.forms.com.fragmentexcise.R;

public class CameraActivity extends AppCompatActivity {

    public static final String TAG = "CameraActivity";
    public static final int REQUEST_CAMERA = 10086;
    public static final int REQUEST_ALBUM = 10010;
    public static final int REQUEST_CUT = 10000;
    private static final String PICTURE_NAME = "IMG_NO.";
    private File currentImageFile = null;
    private Button btnCamera;
    private Button btnAlbum;
    private ImageView ivPic;
    private String tip = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initViews();
        initEvents();
        int state = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE);
        if (state != PackageManager.PERMISSION_GRANTED) {
            tip = "未授权";
            showToast(tip);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, 0);
        } else {
            tip = "已授权";
            // 已授权
            showToast(tip);
        }
    }

    public void initViews() {
        btnCamera = (Button) findViewById(R.id.btn_camera);
        btnAlbum = (Button) findViewById(R.id.btn_album);
        ivPic = (ImageView) findViewById(R.id.iv_picture);
    }

    public void initEvents() {
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // 记得判断存储卡是否可以用
                if (hasSDCard()) {
                    File dir = Environment.getExternalStorageDirectory();
                    currentImageFile = new File(dir, PICTURE_NAME + System.currentTimeMillis() + ".png");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(currentImageFile));
                }
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });
        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                album();
            }
        });
        ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != currentImageFile) {
                    crop(Uri.fromFile(currentImageFile));
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // 用户授权了
            tip = "用户授权了";
            showToast(tip);
        } else {
            // 用户拒绝了
            tip = "用户拒绝了";
            showToast(tip);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void showToast(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    public boolean hasSDCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private void album() {
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA) {
            Log.d(TAG, "onActivityResult-->currentImageFile-->" + currentImageFile);
            crop(Uri.fromFile(currentImageFile));
        } else if (requestCode == REQUEST_ALBUM) {
            if (null != data) {
                Uri uri = data.getData();
                crop(uri);
            }
        } else if (requestCode == REQUEST_CUT) {
            if (null != data) {
                Uri uri = data.getData();
                ivPic.setImageURI(uri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");   // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        //intent.putExtra("outputX", 300);
        //intent.putExtra("outputY", 300);// 图片格式
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra("outputFormat", "PNG");
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
        startActivityForResult(intent, REQUEST_CUT);
    }

}
