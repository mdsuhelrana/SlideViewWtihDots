package com.example.mdsuhelrana.slidepagewithdots2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private SlidepagerAdapter adapter;
    private TextView[] tvDot;
    private int currentPosition;
    private Button btnNext,btnSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotLayout=findViewById(R.id.dotLayout_Id);
        viewPager=findViewById(R.id.viewPager_Id);
        btnSkip=findViewById(R.id.btn_skip);
        btnNext=findViewById(R.id.btn_next);
        btnSkip.setVisibility(View.GONE);
        adapter=new SlidepagerAdapter(this);
        viewPager.setAdapter(adapter);
        addDotIndicator(0);
        viewPager.setOnPageChangeListener(listener);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this," "+(currentPosition-1),Toast.LENGTH_LONG).show();
                viewPager.setCurrentItem(currentPosition-1);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPosition+1);
            }
        });
    }
    public void addDotIndicator(int page){
        tvDot=new TextView[4];
        dotLayout.removeAllViews();
        for (int i=0 ; i<tvDot.length; i++){
            tvDot[i]=new TextView(this);
            tvDot[i].setTextSize(32);
            tvDot[i].setText(Html.fromHtml("&#8226"));
            tvDot[i].setTextColor(getResources().getColor(R.color.white));
            dotLayout.addView(tvDot[i]);
        }
           if (tvDot.length>0) {
               tvDot[page].setTextColor(getResources().getColor(R.color.madWhite));
           }

    }
    ViewPager.OnPageChangeListener listener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPosition=position;
            addDotIndicator(position);
            if (position==0){
                btnSkip.setVisibility(View.GONE);
            }else if(position==3){
               btnNext.setVisibility(View.GONE);
            }else {
                btnSkip.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
