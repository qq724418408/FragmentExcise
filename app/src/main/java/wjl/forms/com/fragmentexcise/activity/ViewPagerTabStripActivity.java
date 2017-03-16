package wjl.forms.com.fragmentexcise.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wjl.forms.com.fragmentexcise.R;

public class ViewPagerTabStripActivity extends AppCompatActivity {

    private ViewPager vpSimple;
    private MyPagerAdapter adapter;
    private List<View> views;
    private List<String> titleLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_strip_view_pager);
        initData();
        initViews();
        initEvents();
    }

    public void initData() {
        titleLists = new ArrayList<>();
        titleLists.add("AAA");
        titleLists.add("BBB");
        titleLists.add("CCC");
        titleLists.add("DDD");
        views = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        views.add(inflater.inflate(R.layout.layout_view_pager_1, null));
        views.add(inflater.inflate(R.layout.layout_view_pager_2, null));
        views.add(inflater.inflate(R.layout.layout_view_pager_3, null));
        views.add(inflater.inflate(R.layout.layout_view_pager_4, null));
        adapter = new MyPagerAdapter(views, titleLists);
    }

    public void initViews() {
        vpSimple = (ViewPager) findViewById(R.id.vp_tab);
    }

    public void initEvents() {
        vpSimple.setAdapter(adapter);
    }

    class MyPagerAdapter extends PagerAdapter {

        private List<View> views;
        private List<String> titleLists;

        public MyPagerAdapter(List<View> views, List<String> titleLists) {
            this.views = views;
            this.titleLists = titleLists;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleLists.get(position);
        }
    }
}
