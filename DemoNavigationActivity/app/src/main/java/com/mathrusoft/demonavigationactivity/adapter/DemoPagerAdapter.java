package com.mathrusoft.demonavigationactivity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 01/03/17.
 */

public class DemoPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> mFragmentList = new ArrayList<>();
    List<String> mTitleList = new ArrayList<>();

    public DemoPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
