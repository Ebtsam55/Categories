package com.example.reda.categories;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPager extends FragmentPagerAdapter {

    private int TabCounts;
    private Context context;


    public FragmentPager(Context mcontext, FragmentManager fm, int tabCount) {
        super(fm);
        this.TabCounts=tabCount;
        context=mcontext;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return  new CategoriesFragment();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return TabCounts;
    }





}
