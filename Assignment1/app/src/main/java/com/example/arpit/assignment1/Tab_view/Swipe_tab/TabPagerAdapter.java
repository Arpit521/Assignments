package com.example.arpit.assignment1.Tab_view.Swipe_tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by arpit on 2/2/17.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:return new Fragment_android();
            case 1: return new Fragment_ios();
            case 2: return new Fragment_windows();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
