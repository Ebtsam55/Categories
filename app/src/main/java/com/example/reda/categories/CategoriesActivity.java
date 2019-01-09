package com.example.reda.categories;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnPageChange;
import butterknife.OnTouch;
import butterknife.Unbinder;

public class CategoriesActivity extends AppCompatActivity {
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ic_search)
    ImageView searchIcon;
    @BindView(R.id.ic_notifications)
    ImageView notifyIcon;
    @BindView(R.id.ic_drawer)
    ImageView drawerIcon;
    @BindView(R.id.category_str)
    TextView categoryIcon;

    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        unbinder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_apps));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FragmentPager adapter = new FragmentPager(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }



    @OnClick(R.id.ic_search)
    void searchAction() {
        Toast.makeText(this, "search has been clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.ic_drawer)
    void goTONavagationDrawer() {
        Toast.makeText(this, "NavagationDrawer Icon has been clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.category_str)
    void showActicityName() {
        Toast.makeText(this, "category_str has been clicked", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.ic_notifications)
    void showNotification() {
        Toast.makeText(this, "notification icon has been clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
