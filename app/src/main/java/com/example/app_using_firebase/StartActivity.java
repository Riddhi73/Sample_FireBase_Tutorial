package com.example.app_using_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class StartActivity extends AppCompatActivity {

    private ImageView icon_Image;
    private Button logIn,Register;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        icon_Image = findViewById(R.id.Picvillage_image);
        linearLayout = findViewById(R.id.ll1);
        Register = findViewById(R.id.start_register);
        logIn = findViewById(R.id.start_login);
        linearLayout.animate().alpha(0f).setDuration(1);
        TranslateAnimation animation = new TranslateAnimation(0,0,0,-1000);
        animation.setDuration(2000);
        animation.setFillAfter(false);
        animation.setAnimationListener(new MyanimationListener());
        icon_Image.setAnimation(animation);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,RegisterActivity.class).
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,LoginActivity.class).
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

    }
    private class MyanimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            icon_Image.clearAnimation();
            icon_Image.setVisibility(View.INVISIBLE);
            linearLayout.animate().alpha(1f).setDuration(1000);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}