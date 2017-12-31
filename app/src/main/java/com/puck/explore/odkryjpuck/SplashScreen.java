package com.puck.explore.odkryjpuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.myanimation);
        textView.startAnimation(myAnimation);
        imageView.startAnimation(myAnimation);

        final Intent intent = new Intent(this, MenuActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(SPLASH_TIME_OUT);
                }
                catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
