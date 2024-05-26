package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    ViewPager slideViewPage;
    LinearLayout layout;
    Button back,next,skip;
    TextView[] tv;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        back=findViewById(R.id.back);
        next=findViewById(R.id.next);
        skip=findViewById(R.id.skip);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getitem(0)>0){
                    slideViewPage.setCurrentItem(getitem(-1),true);
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getitem(0)<3)
                    slideViewPage.setCurrentItem(getitem(1),true);
                else{
                    Intent i=new Intent(AboutUs.this,sign_up.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AboutUs.this,sign_up.class);
                startActivity(i);
                finish();

            }
        });
        slideViewPage=(ViewPager) findViewById(R.id.slideViewPager);
        layout=(LinearLayout) findViewById(R.id.indicator);
        viewPagerAdapter =new ViewPagerAdapter(this);
        slideViewPage.setAdapter(viewPagerAdapter);
        setUpindicator(0);
        slideViewPage.addOnPageChangeListener(viewListener);
    }
    public void setUpindicator(int position){
        tv=new TextView[3];
        layout.removeAllViews();

        for (int i=0;i<tv.length;i++){
            tv[i]=new TextView(this);
            tv[i].setText(Html.fromHtml("&#8226"));
            tv[i].setTextSize(35);
            tv[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            layout.addView(tv[i]);
        }
        tv[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));
    }
    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpindicator(position);
            if (position>0){
                back.setVisibility(View.VISIBLE);
            }else{
                back.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private int getitem(int i){
        return slideViewPage.getCurrentItem()+i;
    }
    public void aboutus(View view){
        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }
}
