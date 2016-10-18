package com.corey.endersgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;

import com.corey.endersgame.R;

/**
 * This activity is an example of how a "challenge" would be displayed to the player.
 */
public class PromptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Background music not included for copyright reasons.
        //TODO: To play background music, add a compatible audio file named bgm2 to res/raw.
        //MusicPlayer.stop();
        //MusicPlayer.play(PromptActivity.this, R.raw.bgm2, true);

        setContentView(R.layout.activity_prompt);

        setTitle(getString(R.string.title_activity_prompt));

        RadioButton rdo1 = (RadioButton) findViewById(R.id.rdo_answer1);
        RadioButton rdo2 = (RadioButton) findViewById(R.id.rdo_answer2);
        RadioButton rdo3 = (RadioButton) findViewById(R.id.rdo_answer3);
        RadioButton rdo4 = (RadioButton) findViewById(R.id.rdo_answer4);

        Button button = (Button) findViewById(R.id.btn_confirm);

        rdo1.setOnClickListener(v -> button.setEnabled(true));
        rdo2.setOnClickListener(v -> button.setEnabled(true));
        rdo3.setOnClickListener(v -> button.setEnabled(true));
        rdo4.setOnClickListener(v -> button.setEnabled(true));

        button.setOnClickListener(view -> {
            startActivity(new Intent(PromptActivity.this, UploadActivity.class));
            finish();
        });
    }
}
