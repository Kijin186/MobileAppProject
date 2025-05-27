package com.example.finalprojectmobile.Player;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.finalprojectmobile.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils.FadeViewHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views.YouTubePlayerSeekBar;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views.YouTubePlayerSeekBarListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class PlayerUIController extends AbstractYouTubePlayerListener {
    private final YouTubePlayer youTubePlayer;
    private final YouTubePlayerTracker playerTracker;

    private final YouTubePlayerView youTubePlayerView;

    private boolean isFullScreen = false;

    public PlayerUIController(View controlsUI, YouTubePlayerView youTubePlayerView, YouTubePlayer youTubePlayer) {
        this.youTubePlayerView = youTubePlayerView;
        this.youTubePlayer = youTubePlayer;
        playerTracker = new YouTubePlayerTracker();
        youTubePlayer.addListener(playerTracker);

        initViews(controlsUI);
    }

    private void initViews(View view) {
        View container = view.findViewById(R.id.container);
        RelativeLayout relativeLayout = view.findViewById(R.id.root);
        YouTubePlayerSeekBar seekBar = view.findViewById(R.id.playerSeekbar);
        ImageButton pausePlay = view.findViewById(R.id.pausePlay);
        ImageButton fullScreen = view.findViewById(R.id.toggleFullScreen);
        youTubePlayer.addListener(seekBar);

        seekBar.setYoutubePlayerSeekBarListener(new YouTubePlayerSeekBarListener() {
            @Override
            public void seekTo(float v) {
                youTubePlayer.seekTo(v);
            }
        });

        pausePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerTracker.getState() == PlayerConstants.PlayerState.PLAYING) {
                    pausePlay.setImageResource(R.drawable.baseline_play_circle_filled_24);
                    youTubePlayer.pause();
                } else {
                    pausePlay.setImageResource(R.drawable.baseline_pause_circle_filled_24);
                    youTubePlayer.play();
                }
            }
        });

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFullScreen) {
                    fullScreen.setImageResource(R.drawable.baseline_fullscreen_24);
                    youTubePlayerView.wrapContent();
                } else {
                    fullScreen.setImageResource(R.drawable.baseline_fullscreen_exit_24);
                    youTubePlayerView.matchParent();
                }
                isFullScreen = !isFullScreen;
            }
        });

        FadeViewHelper fadeViewHelper = new FadeViewHelper(container);
        fadeViewHelper.setAnimationDuration(FadeViewHelper.DEFAULT_ANIMATION_DURATION);
        fadeViewHelper.setFadeOutDelay(FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
        youTubePlayer.addListener(fadeViewHelper);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeViewHelper.toggleVisibility();
            }
        });

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeViewHelper.toggleVisibility();
            }
        });
    }
}
