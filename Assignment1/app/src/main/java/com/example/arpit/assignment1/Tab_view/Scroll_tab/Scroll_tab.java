package com.example.arpit.assignment1.Tab_view.Scroll_tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.arpit.assignment1.R;

public class Scroll_tab extends FragmentActivity {

    String data1 = "Create the highest, grandest vision possible for your life, because you become what you believe.";
    String data2 = "The best way to find yourself is to lose yourself in the service of others.";
    String data3 = "Excellence is the result of caring more than others think is wise, risking more than others think is safe, dreaming more than others think is practical, and expecting more than others think is possible";


    ViewPager pager = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);

        pager = (ViewPager) findViewById(R.id.scrollpager);
        FragmentManager fm = getSupportFragmentManager();

        pager.setAdapter(new MyAdapter(fm));


    }


    class MyAdapter extends FragmentPagerAdapter


    {
        Fragment fragment = null;

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:return Fragment_scroll1.newInstance(data1);
                case 1: return Fragment_scroll2.newInstance(data2);
                case 2:return Fragment_scroll3.newInstance(data3);

                default:return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            String title = new String();

            if (position == 1)
                return "Tab1";

            if (position == 2)
                return "Tab2";

            if (position == 3)
                return "Tab3";

            return null;
        }
    }
}
