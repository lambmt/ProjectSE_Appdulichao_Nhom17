package com.example.appvirtualtravel.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.appvirtualtravel.R;

public class HomeActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Animation in, out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.setAutoStart(true);

    }
}