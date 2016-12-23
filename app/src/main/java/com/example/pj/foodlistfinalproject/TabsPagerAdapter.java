package com.example.pj.foodlistfinalproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pj.foodlistfinalproject.Fragments.CartFragment;
import com.example.pj.foodlistfinalproject.Fragments.HomeFragment;
import com.example.pj.foodlistfinalproject.Fragments.ListFragment;

/**
 * Created by PJ on 12/7/2016.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override

    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new ListFragment();
            case 1:
                return new CartFragment();
            case 2:
                return new HomeFragment();
        }
        return null;

    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "LIST";
            case 1:
                return "CART";
            case 2:
                return "HOME";

        }

        return "idk";
    }
}
