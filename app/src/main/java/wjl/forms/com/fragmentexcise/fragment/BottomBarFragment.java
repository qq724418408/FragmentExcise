package wjl.forms.com.fragmentexcise.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import wjl.forms.com.fragmentexcise.R;
import wjl.forms.com.fragmentexcise.activity.SnackBarActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomBarFragment extends Fragment {

    private RadioGroup rgTab;
    private RadioButton rbHome;
    private Toast toast = null;

    public BottomBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bottom_bar, container, false);
        initViews(v);
        initEvents(v);
        return v;
    }

    public void initViews(View v) {
        rgTab = (RadioGroup) v.findViewById(R.id.rg_tab);
        rbHome = (RadioButton) v.findViewById(R.id.rb_home);
        rbHome.setChecked(true);
    }

    public void initEvents(final View v) {
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int id = group.getCheckedRadioButtonId();
                RadioButton radioButtonChecked = (RadioButton) v.findViewById(id);
                showToast(radioButtonChecked.getText().toString());
                showToast(checkedId + "");
                switch (checkedId) {
                    case 1:
                        startActivity(new Intent(getActivity(), SnackBarActivity.class));
                        break;
                    case 2:

                        break;
                }
            }
        });
    }

    public void showToast(String tip) {
        if (toast == null) {
            toast = Toast.makeText(getContext(), tip, Toast.LENGTH_SHORT);
        } else {
            toast.setText(tip);
        }
        toast.show();
    }

}
