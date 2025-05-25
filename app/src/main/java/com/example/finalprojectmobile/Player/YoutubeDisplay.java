package com.example.finalprojectmobile.Player;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalprojectmobile.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YoutubeDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_youtube);

        YouTubePlayerView youtubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youtubePlayerView);
    }
}
