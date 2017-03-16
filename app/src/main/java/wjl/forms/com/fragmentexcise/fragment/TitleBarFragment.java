package wjl.forms.com.fragmentexcise.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import wjl.forms.com.fragmentexcise.R;
import wjl.forms.com.fragmentexcise.activity.CameraActivity;
import wjl.forms.com.fragmentexcise.activity.ViewPagerMainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleBarFragment extends Fragment {

    private Button btnCamera;
    private Button btnAlbum;

    public TitleBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_title_bar, container, false);
        initViews(v);
        initEvents();
        return v;
    }

    public void initViews(View v) {
        btnCamera = (Button) v.findViewById(R.id.btn_camera);
        btnAlbum = (Button) v.findViewById(R.id.btn_album);
    }

    public void initEvents() {
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CameraActivity.class);
                startActivity(intent);
            }
        });
        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ViewPagerMainActivity.class));
            }
        });
    }

}
