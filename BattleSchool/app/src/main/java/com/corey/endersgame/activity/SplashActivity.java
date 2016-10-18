package com.corey.endersgame.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.corey.endersgame.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Example of a splash screen using custom drawable and font resources.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/sf-fourche.regular.ttf");
        TextView myTextView = (TextView)findViewById(R.id.txt_title);
        myTextView.setTypeface(myTypeface);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ReceiverActivity.class));
                finish();
            }
        }, 3000);
    }
}
