package com.example.android.szabolcsszatmarberegcounty;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Must-see Towns", "Famous People", "Natural Beauties", "Entertainment"};

    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MustSeeTownsFragment();
        } else if (position == 1) {
            return new FamousPeopleFragment();
        } else if (position == 2) {
            return new NaturalBeautiesFragment();
        } else {
            return new EntertainmentFacilitiesFragment();
        }
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