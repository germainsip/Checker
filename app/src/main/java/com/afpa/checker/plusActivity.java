package com.afpa.checker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class plusActivity extends AppCompatActivity  {
    private TextView textView ;
    private TextView resultView;
    private ImageView mImageView;

    ValueAnimator truc = new ValueAnimator();



    private static int count = 0, finalValue = 20;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
        textView = (TextView) findViewById(R.id.bidule);
        resultView = (TextView) findViewById(R.id.textView2);
mImageView = (ImageView) findViewById(R.id.imageView2);

        Intent intent = getIntent();
        //gString message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int res = (int) intent.getDoubleExtra(MainActivity.EXTRA_MESSAGE,0d);



//Valueanimator
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, res);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(String.valueOf(animation.getAnimatedValue()));
            }



        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                if (res< 30){
                    mImageView.setImageResource(R.drawable.hate);
                    resultView.setText("Ca va pas le faire vous deux!!!");


                }else if (res<80){
                    mImageView.setImageResource(R.drawable.friend);
                    resultView.setText("Copains cool !!!");

                }else {
                    mImageView.setImageResource(R.drawable.love);
                    resultView.setText("L'amour fou...");

                }
            }
        });
        animator.setDuration(2000); // here you set the duration of the anim
        animator.start();
        //textView.setText(message);


    }








}
