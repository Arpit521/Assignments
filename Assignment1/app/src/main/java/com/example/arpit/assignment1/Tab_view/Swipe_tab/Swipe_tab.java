package com.example.arpit.assignment1.Tab_view.Swipe_tab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.arpit.assignment1.R;

import java.util.ArrayList;
import java.util.List;

public class Swipe_tab extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_tab);


       /* toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tablayout=(TabLayout)findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);

    }

    protected void setupViewPager(ViewPager viewPager)
    {

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_windows(),"Windows Tab");
        adapter.addFragment(new Fragment_ios(),"Ios Tab");
        adapter.addFragment(new Fragment_android(),"Android Tab");

        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentlist=new ArrayList<>();
        private final List<String> mFragmentTitle=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentlist.size();
        }

        public void addFragment(Fragment fragment,String title)
        {
            mFragmentlist.add(fragment);
            mFragmentTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitle.get(position);
        }
    }
}
