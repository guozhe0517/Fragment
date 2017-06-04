package com.guozhe.android.a3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Fragment one,two,three;
    ViewPager pager;
    TabLayout tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        pager = (ViewPager)findViewById(R.id.pager);
        tap = (TabLayout)findViewById(R.id.tab);
        tap.addTab(tap.newTab().setText("One"));
        tap.addTab(tap.newTab().setText("Two"));
        tap.addTab(tap.newTab().setText("Three"));

        List<Fragment> datas=new ArrayList();
        datas.add(one);
        datas.add(two);
        datas.add(three);
        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager(),datas);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tap));
        tap.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));


    }
    class pagerAdapter extends FragmentStatePagerAdapter{

        List<Fragment> datas;
        public pagerAdapter(FragmentManager fm, List<Fragment> datas) {
            super(fm);
            this.datas = datas;
        }

        @Override
        public Fragment getItem(int position) {
            return datas.get(position);
        }

        @Override
        public int getCount() {
            return datas.size();
        }
    }
}
