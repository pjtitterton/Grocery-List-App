package com.example.pj.foodlistfinalproject.Activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.View;


import com.example.pj.foodlistfinalproject.FoodCollection;
import com.example.pj.foodlistfinalproject.FoodModel;
import com.example.pj.foodlistfinalproject.Fragments.CartFragment;
import com.example.pj.foodlistfinalproject.Fragments.ListFragment;
import com.example.pj.foodlistfinalproject.R;
import com.example.pj.foodlistfinalproject.TabsPagerAdapter;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    TabsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);






        //transaction.replace(R.id.activity_main, list);
        //transaction.commit();

    }

    @Override
    protected void onResume()
    {
        super.onResume();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.addFood:

                Intent intent = new Intent(this, FoodDetailActivity.class);
                intent.putExtra("foodId",(UUID) null);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }




}
