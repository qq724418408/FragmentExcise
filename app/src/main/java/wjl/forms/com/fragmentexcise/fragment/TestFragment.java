package wjl.forms.com.fragmentexcise.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import wjl.forms.com.fragmentexcise.R;

public class TestFragment extends BaseFragment {

    public static final String TAG = "TestFragment";
    private ImageView ivPic;

    // 当一个fragment被创建的时候：onAttach() onCreate() onCreateView() onActivityCreated()
    // 当这个fragment对用户可见的时候，它会经历以下状态: onStart() onResume()
    // 当这个fragment进入“后台模式”的时候，它会经历以下状态: onPause() onStop()
    // 当这个fragment被销毁了（或者持有它的activity被销毁了）：onPause() onStop() onDestroyView() onDestroy() onDetach()
    // 屏幕灭掉: onPause() onSaveInstanceState() onStop()
    // 屏幕解锁: onStart() onResume()
    // 切换到其他Fragment: onPause() onStop() onDestroyView()
    // 切换回本身的Fragment: onCreateView() onActivityCreated() onStart() onResume()
    // 回到桌面：onPause() onSaveInstanceState() onStop()
    // 回到应用: onStart() onResume()
    // 退出应用: onPause() onStop() onDestroyView() onDestroy() onDetach()

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach()");
        super.onAttach(context); // Fragment和Activity建立关联的时候调用（获得activity的传递的值）
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        initViews(v);
        return v; // 为Fragment创建视图（加载布局）时调用（给当前的fragment绘制UI布局，可以使用线程更新UI）
    }

    public void initViews(View v) {
        ivPic = (ImageView) v.findViewById(R.id.iv_pic);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState); // 当Activity中的onCreate方法执行完后调用（表示activity执行oncreate方法完成了的时候会调用此方法）
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView()");
        super.onDestroyView(); // Fragment中的布局被移除时调用（表示fragment销毁相关联的UI布局）
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach()");
        super.onDetach(); // Fragment和Activity解除关联的时候调用（脱离activity）
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }
}