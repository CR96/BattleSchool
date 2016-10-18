package com.corey.endersgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.corey.endersgame.R;
import com.corey.endersgame.util.MusicPlayer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This activity prompts the player to connect a peripheral to continue.
 * This is simulated using an animation started on a preset delay.
 */
public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        MusicPlayer.play(this, R.raw.searching, false);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.prog);
        final ImageView image = (ImageView) findViewById(R.id.imgConnect);
        final TextView text = (TextView) findViewById(R.id.txtConnect);
        final Animation disappear = AnimationUtils.loadAnimation(
                ReceiverActivity.this,
                R.anim.disappear);
        final Animation overshoot = AnimationUtils.loadAnimation(
                ReceiverActivity.this,
                R.anim.overshoot);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    MusicPlayer.play(ReceiverActivity.this, R.raw.connected, false);

                    progressBar.startAnimation(disappear);
                    progressBar.setVisibility(View.GONE);

                    image.setVisibility(View.VISIBLE);
                    image.startAnimation(overshoot);
                    text.setText(R.string.found);
                });
            }
        }, 6000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    startActivity(new Intent(ReceiverActivity.this, MainActivity.class));
                    finish();
                });
            }
        }, 8000);
    }
}
