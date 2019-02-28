package de.deftone.musicapp.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.deftone.musicapp.R;
import de.deftone.musicapp.fragment.InstrumentFragment;
import de.deftone.musicapp.model.KeyData;

import static de.deftone.musicapp.fragment.ScaleFragment.INTENT_SCALE_EXTRA;


public class PlayerActivity extends AppCompatActivity {

    public static final String SONG_FILE_NAME_EXTRA = "song file name";
    public static final String SONG_TITLE_EXTRA = "song title";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        KeyData key = (KeyData) getIntent().getSerializableExtra(INTENT_SCALE_EXTRA);
        if (key == KeyData.DEFAULT) {
            switch (InstrumentFragment.getInstrument()) {
                case BB:
                    scaleImg.setImageResource(R.drawable.warm_up_bb);
                    break;
                case EB:
                    scaleImg.setImageResource(R.drawable.warm_up_eb);
                    break;
                default:
                    scaleImg.setImageResource(R.drawable.warm_up_c);

                    break;
            }
            scaleName.setText("Warm up (lange Töne)");
            scaleImgPenta.setVisibility(View.GONE);
        } else {
            scaleName.setText(key.getKeyData().getKeyName());
            scaleImg.setImageResource(key.getKeyData().getScaleImgResId());
            scaleImgPenta.setImageResource(key.getKeyData().getPentaImgResId());
        }

        int songRessourceId = getRawResIdByName(getIntent().getStringExtra(SONG_FILE_NAME_EXTRA));

        this.seekBar.setClickable(false);

        // Create MediaPlayer and use ressource id of song - das geht nur in onCreate!
        //wenn man also zwischen den songs wechseln moechte, dann muss man das grundsaetzlich anders loesen
        this.mediaPlayer = MediaPlayer.create(this, songRessourceId);

        // The duration in milliseconds
        int duration = this.mediaPlayer.getDuration();
        this.seekBar.setMax(duration);
        String maxTimeString = this.millisecondsToString(duration);
        this.textMaxTime.setText(maxTimeString);

        //title
        songTitle.setText(getIntent().getStringExtra(SONG_TITLE_EXTRA));
    }

    // Find ID of resource in 'raw' folder.
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
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


    @OnClick(R.id.button_rewind)
    void doRewind() {
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        // 5 seconds.
        int SUBTRACT_TIME = 5000;

        if (currentPosition - SUBTRACT_TIME > 0) {
            this.mediaPlayer.seekTo(currentPosition - SUBTRACT_TIME);
        }
    }

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
