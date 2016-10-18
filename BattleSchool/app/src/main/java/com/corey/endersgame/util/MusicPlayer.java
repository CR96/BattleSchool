package com.corey.endersgame.util;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * A simple class that plays a specified audio file with an option to loop.
 */
public class MusicPlayer {
    private static MediaPlayer player;

    /**
     * Plays a specified audio file.
     * @param ctx the context object passed from the calling Activity
     * @param raw_id the resource ID of the audio file to be played
     * @param loop play the audio file on a loop
     */
    public static void play(Context ctx, int raw_id, boolean loop){
        player = MediaPlayer.create(ctx, raw_id);
        if (loop) {
            player.setLooping(true);
        }
        player.start();
    }

    public static void stop() {
        player.stop();
    }
}
