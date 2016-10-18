package com.corey.endersgame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.corey.endersgame.R;

/**
 * Shows the selected army, its logo, a short description, and a confirmation button.
 */
public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String army_name = getIntent().getStringExtra("army_name");
        String army_desc = getIntent().getStringExtra("army_descs");
        int army_image = getIntent().getIntExtra("army_image", -1);

        switch(army_name) {
            case "Dragon":
                setTheme(R.style.DragonTheme);
                break;
            case "Phoenix":
                setTheme(R.style.PhoenixTheme);
                break;
            case "Rabbit":
                setTheme(R.style.RabbitTheme);
                break;
            case "Rat":
                setTheme(R.style.RatTheme);
                break;
            case "Salamander":
                setTheme(R.style.SalamanderTheme);
                break;
        }

        setContentView(R.layout.activity_confirm);
        setTitle(army_name);

        ImageView image = (ImageView) findViewById(R.id.img_army);
        image.setImageResource(army_image);

        TextView name = (TextView) findViewById(R.id.txt_description);
        name.setText(army_desc);

        Button confirm = (Button) findViewById(R.id.btn_confirm);
        confirm.setText("JOIN THE " + army_name + " ARMY");

        confirm.setOnClickListener(v -> {
            startActivity(new Intent(ConfirmActivity.this, PromptActivity.class));
            finish();
        });
    }

}
