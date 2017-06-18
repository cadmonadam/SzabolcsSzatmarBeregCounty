package com.example.android.szabolcsszatmarberegcounty;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    Context context;
    private String tabTitles[];

    public TabFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = new String[]{context.getString(R.string.mustSeeTowns), context.getString(R.string.famousPeople), context.getString(R.string.naturalBeauties), context.getString(R.string.entertainment)};
    }

    @Override

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MustSeeTownsFragment();
            case 1:
                return new FamousPeopleFragment();
            case 2:
                return new NaturalBeautiesFragment();
            case 3:
                return new EntertainmentFacilitiesFragment();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // According to the item position the tab titles will be created.
        return tabTitles[position];
    }
}