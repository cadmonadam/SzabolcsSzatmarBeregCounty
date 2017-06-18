package com.example.android.szabolcsszatmarberegcounty;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // With the help of ViewPager the user can switch between the different fragments.
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter which provide the appropriate content to the tabs.
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager(), this);

        // Set the adapter into the view pager
        viewPager.setAdapter(adapter);

        // Set the TabLayout with the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}