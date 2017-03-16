package wjl.forms.com.fragmentexcise.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import wjl.forms.com.fragmentexcise.R;

public class SnackBarActivity extends AppCompatActivity {

    private Button btnSnackBar;
    private CoordinatorLayout cdlSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        btnSnackBar = (Button) findViewById(R.id.btn_snack_bar);
        cdlSB = (CoordinatorLayout) findViewById(R.id.cdl_snack_bar);
        btnSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "恭喜你中奖了", Snackbar.LENGTH_SHORT).setAction("立即领取", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(cdlSB, "领取失败", Snackbar.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(getResources().getColor(R.color.blue)).show();
            }
        });
    }
}
