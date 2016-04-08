package com.chi_a.jing.smartcase.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;


import com.chi_a.jing.smartcase.R;
import com.chi_a.jing.smartcase.adapter.MyFragmentPagerAdapter;
import com.chi_a.jing.smartcase.fragment.OrderFragment;
import com.chi_a.jing.smartcase.fragment.RechargeFragment;
import com.chi_a.jing.smartcase.fragment.HomeFragment;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private TextView tvHomeNormal, tvHomePress, tvOrderNormal, tvOrderPress;
    private TextView tvRechargeNormal, tvRechargePress;   //*****
    private TextView tvHomeTextNormal, tvHomeTextPress, tvOrderTextNormal, tvOrderTextPress;
    private TextView tvRechargeTextNormal, tvRechargeTextPress;//****
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        tvHomeNormal =(TextView) findViewById(R.id.tv_home_normal);
        tvHomePress =(TextView) findViewById(R.id.tv_home_press);
        tvOrderNormal =(TextView) findViewById(R.id.tv_order_normal);
        tvOrderPress =(TextView) findViewById(R.id.tv_order_press);
        tvRechargeNormal =(TextView) findViewById(R.id.tv_recharge_normal);
        tvRechargePress =(TextView) findViewById(R.id.tv_recharge_press);
        tvHomeTextNormal =(TextView) findViewById(R.id.tv_home_text_normal);
        tvHomeTextPress =(TextView) findViewById(R.id.tv_home_text_press);
        tvOrderTextNormal =(TextView) findViewById(R.id.tv_order_text_normal);
        tvOrderTextPress =(TextView) findViewById(R.id.tv_order_text_press);
        tvRechargeTextNormal =(TextView) findViewById(R.id.tv_recharge_text_normal);
        tvRechargeTextPress =(TextView) findViewById(R.id.tv_recharge_text_press);

        findViewById(R.id.ll_home).setOnClickListener(this);
        findViewById(R.id.ll_order).setOnClickListener(this);
        findViewById(R.id.ll_recharge).setOnClickListener(this);

        //默认选中第一个
        setTransparency();
        tvHomePress.getBackground().setAlpha(255);
        tvHomeTextPress.setTextColor(Color.argb(255, 234, 134, 41)); // (alpha,r,g,b)

        /**ViewPager**/
        viewPager=(ViewPager) findViewById(R.id.view_pager);
        HomeFragment homeFragment=new HomeFragment();
        OrderFragment orderFragment=new OrderFragment();
        RechargeFragment discoveryFragment=new RechargeFragment();
        ArrayList<Fragment> fragmentList=new ArrayList<Fragment>();
        fragmentList.add(homeFragment);
        fragmentList.add(orderFragment);
        fragmentList.add(discoveryFragment);
        //ViewPager设置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        //ViewPager显示第一个Fragment
        viewPager.setCurrentItem(0);
        //ViewPager页面切换监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //根据ViewPager滑动位置更改透明度
                int diaphaneity_one=(int)(255 * positionOffset);
                int diaphaneity_two=(int)(255 * (1 - positionOffset));
                switch (position){
                    case 0:
                        tvHomeNormal.getBackground().setAlpha(diaphaneity_one);
                        tvHomePress.getBackground().setAlpha(diaphaneity_two);
                        tvOrderNormal.getBackground().setAlpha(diaphaneity_two);
                        tvOrderPress.getBackground().setAlpha(diaphaneity_one);
                        tvHomeTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                        tvHomeTextPress.setTextColor(Color.argb(diaphaneity_two,234, 134, 41));
                        tvOrderTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                        tvOrderTextPress.setTextColor(Color.argb(diaphaneity_one, 234, 134, 41));
                        break;
                    case 1:
                        tvOrderNormal.getBackground().setAlpha(diaphaneity_one);
                        tvOrderPress.getBackground().setAlpha(diaphaneity_two);
                        tvRechargeNormal.getBackground().setAlpha(diaphaneity_two);
                        tvRechargePress.getBackground().setAlpha(diaphaneity_one);
                        tvOrderTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                        tvOrderTextPress.setTextColor(Color.argb(diaphaneity_two, 234, 134, 41));
                        tvRechargeTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                        tvRechargeTextPress.setTextColor(Color.argb(diaphaneity_one, 234, 134, 41));
                        break;
                    case 2:
                        tvRechargeNormal.getBackground().setAlpha(diaphaneity_one);
                        tvRechargePress.getBackground().setAlpha(diaphaneity_two);
                        tvRechargeTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                        tvRechargeTextPress.setTextColor(Color.argb(diaphaneity_two, 234, 134, 41));
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    /**
     * 设置透明度
     * 把press图片、文字全部隐藏
     */
    private void setTransparency(){
        tvHomeNormal.getBackground().setAlpha(255);
        tvOrderNormal.getBackground().setAlpha(255);
        tvRechargeNormal.getBackground().setAlpha(255);
        tvHomePress.getBackground().setAlpha(1);
        tvOrderPress.getBackground().setAlpha(1);
        tvRechargePress.getBackground().setAlpha(1);
        tvHomeTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvOrderTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvRechargeTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvHomeTextPress.setTextColor(Color.argb(0, 234, 134, 41));
        tvOrderTextPress.setTextColor(Color.argb(0, 234, 134, 41));
        tvRechargeTextPress.setTextColor(Color.argb(0, 234, 134, 41));
    }

    @Override
    public void onClick(View v) {
        setTransparency();
        tvRechargeNormal.getBackground().setAlpha(255);
        switch (v.getId()){
            case R.id.ll_home:
                viewPager.setCurrentItem(0, false);
                tvHomePress.getBackground().setAlpha(255);
                tvHomeTextPress.setTextColor(Color.argb(255, 234, 134, 41));
                break;
            case R.id.ll_order:
                viewPager.setCurrentItem(1, false);
                tvOrderPress.getBackground().setAlpha(255);
                tvOrderTextPress.setTextColor(Color.argb(255, 234, 134, 41));
                break;
            case R.id.ll_recharge:
                viewPager.setCurrentItem(2,false);
                tvRechargeNormal.getBackground().setAlpha(0);
                tvRechargePress.getBackground().setAlpha(255);
                tvRechargeTextPress.setTextColor(Color.argb(255, 234, 134, 41));
                break;
        }
    }
}
