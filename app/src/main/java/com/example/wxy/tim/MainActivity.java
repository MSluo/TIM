package com.example.wxy.tim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    private ViewPager viewPager;
    List<Fragment> fragments=new ArrayList<>();
    ListFragment listFragment;
    TabFragment tabFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
   public void init()
   {
       viewPager=findViewById(R.id.viewPager);
       listFragment=new ListFragment();
       fragments.add(listFragment);
       tabFragment=new TabFragment();
       fragments.add(tabFragment);
       ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
       viewPager.setAdapter(viewPagerAdapter);
       viewPager.setCurrentItem(1);
   }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
    if (position==PAGE_ONE)
    {
       // startActivity(new Intent(this,));
    }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
