package com.example.uee;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class Introduction_Page extends AppCompatActivity {

    ImageView splashImg;
    LottieAnimationView lottieAnimationView;

    Timer timer;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_page);

       // logo = findViewById(R.id.logo);
        //appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);


        //logo.animate().translationY(-1600).setDuration(7000).setStartDelay(4000);
        //appName.animate().translationY(1400).setDuration(7000).setStartDelay(4000);
        splashImg.animate().translationY(-2200).setDuration(4000).setStartDelay(3000);
        lottieAnimationView.animate().translationY(1400).setDuration(4000).setStartDelay(3000);

        timer = new Timer();
        timer.schedule (new TimerTask()  {
            @Override
            public void run() {
                Intent intent = new Intent (Introduction_Page.this, Login_Page.class);
                startActivity(intent);
                finish();
            }
        }, 6000);

    }

}
