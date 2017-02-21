package com.example.arpit.assignment1.View_Pager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.example.arpit.assignment1.R;


public class View_Pager extends FragmentActivity {

    String data1="Believe in yourself! Have faith in your abilities! Without a humble but reasonable confidence in your own powers you cannot be successful or happy";

    String data2="Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time";

    String data3="Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__pager);

        ViewPager view1=(ViewPager) findViewById(R.id.viewpager1);

        view1.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


    }

    private class MyPagerAdapter extends FragmentPagerAdapter
    {

        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position)
            {
                case 0: return Fragment_page1.newInstance(data1);
                case 1: return Fragment_page2.newInstance(data2);
                case 2: return Fragment_page3.newInstance(data3);
                default: return Fragment_page2.newInstance(data2);
            }
        }


        @Override
        public int getCount() {
            return 3;
        }
    }

}
