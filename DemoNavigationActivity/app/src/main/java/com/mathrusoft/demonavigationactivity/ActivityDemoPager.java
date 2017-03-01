package com.mathrusoft.demonavigationactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mathrusoft.demonavigationactivity.adapter.DemoPagerAdapter;
import com.mathrusoft.demonavigationactivity.fragment.FragmentCamera;
import com.mathrusoft.demonavigationactivity.fragment.FragmentSettings;
import com.mathrusoft.demonavigationactivity.fragment.FragmentStudentList;

/**
 * Created by sharanangadi on 01/03/17.
 */

public class ActivityDemoPager extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout mTabLayout;

    DemoPagerAdapter mDemoPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_pager);


        mViewPager = (ViewPager) findViewById(R.id.my_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.my_tab_layout);

        initFragments();

        mViewPager.setAdapter(mDemoPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initFragments() {


        mDemoPagerAdapter = new DemoPagerAdapter(getSupportFragmentManager());

        mDemoPagerAdapter.addFragment(new FragmentSettings(), "Settings");
        mDemoPagerAdapter.addFragment(new FragmentCamera(), "Camera");
        mDemoPagerAdapter.addFragment(new FragmentStudentList(), "Student List");

    }


}
