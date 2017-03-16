package wjl.forms.com.fragmentexcise.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import wjl.forms.com.fragmentexcise.R;

public class ViewPagerMainActivity extends Activity implements View.OnClickListener {

    private Button btnSimpleViewPager;
    private Button btnTitleStripViewPager;
    private Button btnTabStripViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initViews();
        initEvents();
    }

    private void initEvents() {
        btnSimpleViewPager.setOnClickListener(this);
        btnTitleStripViewPager.setOnClickListener(this);
        btnTabStripViewPager.setOnClickListener(this);
    }

    public void initViews() {
        btnSimpleViewPager = (Button) findViewById(R.id.id_btn_simple_view_pager);
        btnTitleStripViewPager = (Button) findViewById(R.id.id_btn_title_strip_view_pager);
        btnTabStripViewPager = (Button) findViewById(R.id.id_btn_tab_strip_view_pager);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.id_btn_simple_view_pager:
                startActivity(new Intent(ViewPagerMainActivity.this, ViewPagerSimpleActivity.class));
                break;
            case R.id.id_btn_title_strip_view_pager:
                startActivity(new Intent(ViewPagerMainActivity.this, ViewPagerTitleStripActivity.class));
                break;
            case R.id.id_btn_tab_strip_view_pager:
                startActivity(new Intent(ViewPagerMainActivity.this, ViewPagerTabStripActivity.class));
                break;
        }
    }
}
