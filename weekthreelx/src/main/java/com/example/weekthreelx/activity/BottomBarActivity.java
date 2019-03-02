package com.example.weekthreelx.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.weekthreelx.R;
import com.example.weekthreelx.fragment.Fragmentfind;
import com.example.weekthreelx.fragment.Fragmentmy;
import com.example.weekthreelx.fragment.Fragmentshopcar;

public class BottomBarActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewpager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewpager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewpager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
    private ViewPager viewpager;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        viewpager = findViewById(R.id.viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new Fragmentshopcar();
                    case 1:
                        return new Fragmentfind();
                    case 2:
                        return new Fragmentmy();
                }
                return null;
            }


            @Override
            public int getCount() {
                return 3;
            }
        });

    }

}
