package com.example.deviation.p0225_imageviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    private List<String> numberList;

    private CircleAnimIndicator circleAnimIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        init();
    }


    /**
     * 레이아웃 초기화
     */
    private void initLayout(){

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        circleAnimIndicator = (CircleAnimIndicator) findViewById(R.id.circleAnimIndicator);
    }


    /**
     * 데이터 초기화
     */
    private void init(){

        //데이터 초기화
        initData();
        //ViewPager 초기화
        initViewPager();
    }


    /**
     * 데이터 초기화
     */
    private void initData(){

        numberList = new ArrayList<>();
        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        numberList.add("4");
        numberList.add("5");

    }


    /**
     * ViewPager 초기화
     */
    private void initViewPager(){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getApplicationContext(),numberList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);


        //Indicator 초기화
        initIndicaotor();
    }


    /**
     * Indicator 초기화
     */
    private void initIndicaotor(){

        //원사이의 간격
        circleAnimIndicator.setItemMargin(15);
        //애니메이션 속도
        circleAnimIndicator.setAnimDuration(300);
        //indecator 생성
        circleAnimIndicator.createDotPanel(numberList.size(), R.drawable.ic_action_aa , R.drawable.ic_action_bb);
    }


    /**
     * ViewPager 전환시 호출되는 메서드
     */
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {
            circleAnimIndicator.selectDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };


}
