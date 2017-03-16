package wjl.forms.com.fragmentexcise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.io.File;

import wjl.forms.com.fragmentexcise.R;
import wjl.forms.com.fragmentexcise.fragment.TestFragment;

import static wjl.forms.com.fragmentexcise.activity.CameraActivity.REQUEST_CAMERA;

public class MainActivity extends FragmentActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,CameraActivity.class));
        // 这里一定要在save为null时才加载Fragment，Fragment中onCreateView等生命周里加载根子Fragment同理
        // 因为在页面重启时，Fragment会被保存恢复，而此时再加载Fragment会重复加载，导致重叠
        if (savedInstanceState == null) { // 正常情况下去 加载根Fragment
            getSupportFragmentManager().beginTransaction().add(R.id.flt_test_fragment_container, new TestFragment(), "TestFragment").commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult-->requestCode-->" + requestCode);
        Log.d(TAG, "onActivityResult-->REQUEST_CAMERA-->" + REQUEST_CAMERA);
        Log.d(TAG, "onActivityResult-->resultCode-->" + resultCode);
        File currentImageFile = null;
        if (requestCode == REQUEST_CAMERA) {
            if (data != null) {
                currentImageFile = data.getParcelableExtra(MediaStore.EXTRA_OUTPUT);
                Log.d(TAG, "onActivityResult-->currentImageFile-->" + currentImageFile);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
