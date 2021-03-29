package com.project.plantmtytree.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.plantmtytree.HelperClasses.SliderAdaptor;
import com.project.plantmtytree.R;

public class OnBording extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdaptor sliderAdaptor;
    TextView[] dots;
    Button lets;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_bording);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        lets = findViewById(R.id.get_started_button);

        sliderAdaptor = new SliderAdaptor(this);
        viewPager.setAdapter(sliderAdaptor);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }

    private void addDots(int position){

        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for(int i = 0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.feeling_yellow));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            if(position ==0){
                lets.setVisibility(View.INVISIBLE);

            }else if(position == 1){
                lets.setVisibility(View.INVISIBLE);

            }else {
                animation = AnimationUtils.loadAnimation(OnBording.this,R.anim.bot_animation);
                lets.setAnimation(animation);
                lets.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}