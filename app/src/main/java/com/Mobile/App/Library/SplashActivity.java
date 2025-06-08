package com.Mobile.App.Library;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMEOUT = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Load animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);

        // Set animation to your splash screen
        findViewById(R.id.imageView3).startAnimation(animation);

        // PostDelayed for a specific duration to transition to HomePageActivity after the animation duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToLoginActivity();
            }
        }, SPLASH_SCREEN_TIMEOUT + 3000); // Set timeout based on your animation duration
    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // This prevents the user from returning to the SplashActivity using the back button
    }
}
