package com.example.eratingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    //variables
    private Animation topAnimation, bottomAnimation;
    private ImageView splash_image;
    private TextView splash_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        // Animation load from res..anim
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        splash_image = findViewById(R.id.imgSplashScreen);
        splash_text = findViewById(R.id.txtSplashScreen);

        //setup animation to variables
        splash_image.setAnimation(topAnimation);
        splash_text.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }

}