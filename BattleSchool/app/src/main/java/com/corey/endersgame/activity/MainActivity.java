package com.corey.endersgame.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.corey.endersgame.R;
import com.corey.endersgame.adapter.ArmyAdapter;

/**
 * Prompts the player to select an army by populating a RecyclerView and starting background music.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_activity_main);

        //Background music not included for copyright reasons.
        //TODO: To play background music, add a compatible audio file named bgm1 to res/raw.
        //MusicPlayer.play(MainActivity.this, R.raw.bgm1, true);

        Resources res = getResources();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        ArmyAdapter armyAdapter = new ArmyAdapter(
                res.getStringArray(R.array.army_names),
                res.getStringArray(R.array.army_descs),
                res.obtainTypedArray(R.array.army_images),
                res.getIntArray(R.array.army_colors));

        RecyclerView lst = (RecyclerView) findViewById(R.id.list);
        lst.setLayoutManager(layoutManager);
        lst.setAdapter(armyAdapter);
    }
}
