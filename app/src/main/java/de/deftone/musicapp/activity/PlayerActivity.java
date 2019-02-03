package de.deftone.musicapp.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.Song;

public class PlayerActivity extends AppCompatActivity {

    public static final String INTENT_SONG_LIST = "song list";
    public static final String INTENT_SONG_POSITION = "song position in list";

    @BindView(R.id.textView_maxTime)
    TextView textMaxTime;
    @BindView(R.id.textView_currentPosion)
    TextView textCurrentPosition;
    @BindView(R.id.button_start)
    ImageButton buttonStart;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.scale_name)
    TextView scaleName;
    @BindView(R.id.scale_img)
    ImageView scaleImg;
    @BindView(R.id.scale_img_penta)
    ImageView scaleImgPenta;
    @BindView(R.id.song_title)
    TextView songTitle;

    private Handler threadHandler = new Handler();
    private MediaPlayer mediaPlayer;
    private boolean isPlaying;
    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        //todo: das hier dynamisch
        scaleName.setText("C-Dur");
        scaleImg.setImageResource(R.drawable.c_dur);
        scaleImgPenta.setImageResource(R.drawable.c_dur_penta);

        songList = new ArrayList<>((ArrayList<Song>) getIntent().getSerializableExtra(INTENT_SONG_LIST));
        int songPosition = getIntent().getIntExtra(INTENT_SONG_POSITION, 1);

//        int songId = getIntent().getExtras().getInt(SONG_ID_EXTRA);
//        String songTitle = getIntent().getExtras().getString(SONG_TITLE_EXTRA);
        this.seekBar.setClickable(false);

        // Create MediaPlayer and use ressource id of song
        this.mediaPlayer = MediaPlayer.create(this, songList.get(songPosition).getId());

        // The duration in milliseconds
        int duration = this.mediaPlayer.getDuration();
        this.seekBar.setMax(duration);
        String maxTimeString = this.millisecondsToString(duration);
        this.textMaxTime.setText(maxTimeString);

        //title
        songTitle.setText(songList.get(songPosition).getTitle());

    }


    // Convert millisecond to string.
    private String millisecondsToString(int milliseconds) {
        //aktuelle Position in Sekunden
        int secAbsolute = milliseconds / 1000;
        //minuten und sekunden berechnen
        int min = secAbsolute / 60;
        int sec = secAbsolute % 60;
        if (sec < 10)
            return min + ":0" + sec;
        else
            return min + ":" + sec;
    }

    @OnClick(R.id.button_start)
    void doStart() {
        if (!isPlaying) {
            isPlaying = true;
            buttonStart.setImageResource(R.drawable.icon_pause);
            this.mediaPlayer.start();
            // Create a thread to update position of SeekBar.
            UpdateSeekBarThread updateSeekBarThread = new UpdateSeekBarThread();
            threadHandler.postDelayed(updateSeekBarThread, 50);
        } else {
            isPlaying = false;
            buttonStart.setImageResource(R.drawable.icon_play);
            this.mediaPlayer.pause();
        }
    }

    // Thread to Update position for SeekBar.
    class UpdateSeekBarThread implements Runnable {

        public void run() {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            textCurrentPosition.setText(currentPositionStr);

            seekBar.setProgress(currentPosition);
            // Delay thread 50 milisecond.
            threadHandler.postDelayed(this, 50);
        }
    }


    // When user click to "Rewind".
    @OnClick(R.id.button_rewind)
    void doRewind() {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        // 5 seconds.
        int SUBTRACT_TIME = 5000;

        if (currentPosition - SUBTRACT_TIME > 0) {
            this.mediaPlayer.seekTo(currentPosition - SUBTRACT_TIME);
        }
    }

    // When user click to "Fast-Forward".
    @OnClick(R.id.button_fastForward)
    void doFastForward() {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        // 5 seconds.
        int ADD_TIME = 5000;

        if (currentPosition + ADD_TIME < duration) {
            this.mediaPlayer.seekTo(currentPosition + ADD_TIME);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }
}
