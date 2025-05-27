package com.example.finalprojectmobile.Player;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalprojectmobile.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YoutubeDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_youtube);

        // ✅ Get video ID from Intent (key must match the one used in Intent.putExtra)
        String intentVideoId = getIntent().getStringExtra("videoId");
        String videoId = (intentVideoId == null || intentVideoId.isEmpty()) ? "dQw4w9WgXcQ" : intentVideoId;


        YouTubePlayerView youtubePlayerView = findViewById(R.id.youtubePlayer);
        getLifecycle().addObserver(youtubePlayerView);
        youtubePlayerView.setEnableAutomaticInitialization(false);

        View controlsUI = youtubePlayerView.inflateCustomPlayerUi(R.layout.custom_control);

        YouTubePlayerListener youTubePlayerListener = new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                PlayerUIController controller = new PlayerUIController(controlsUI, youtubePlayerView, youTubePlayer);
                youTubePlayer.addListener(controller);

                // ✅ Load video
                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, getLifecycle(), videoId, 0f);
            }
        };

        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();
        youtubePlayerView.initialize(youTubePlayerListener, options);
    }
}
