package de.deftone.musicapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.adapter.SongAdapter;
import de.deftone.musicapp.model.Key;
import de.deftone.musicapp.model.Song;

import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_LIST;
import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_POSITION;

public class ScaleActivity extends AppCompatActivity {

    public static final String SCALE_EXTRA = "scale";

    private Activity activity = this;
    @BindView(R.id.scale_name)
    TextView scaleName;
    @BindView(R.id.scale_name_penta)
    TextView scaleNamePenta;
    @BindView(R.id.scale_img)
    ImageView scaleImg;
    @BindView(R.id.scale_img_penta)
    ImageView scaleImgPenta;
    @BindView(R.id.recycler_view_song_list)
    RecyclerView recyclerViewSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        ButterKnife.bind(this);

        Key key = (Key) getIntent().getSerializableExtra(SCALE_EXTRA);
        scaleName.setText(key.getKeyData().getKeyName());
        scaleNamePenta.setText(key.getKeyData().getKeyName() + " Pentatonik");
        scaleImg.setImageResource(key.getKeyData().getScaleImgResId());
        scaleImgPenta.setImageResource(key.getKeyData().getPentaImgResId());
        //todo: get songs for that key!
        List<Song> songList = new ArrayList<>();
        String fileName = "fly_me_moon";
        int songId = getRawResIdByName(fileName);
        Song song = new Song(songId, fileName, "fly me to the moon", "dirko");
        songList.add(song);
        fileName = "blue_moon";
        songId = getRawResIdByName(fileName);
        song = new Song(songId, fileName, "blue moon", "dirko");
        songList.add(song);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerViewSongs.setLayoutManager(layoutManager);

        setSongsOnRecyclerView(songList);
    }

    // Find ID of resource in 'raw' folder.
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
    }

    private void setSongsOnRecyclerView(final List<Song> songList) {
        // specify an adapter
        SongAdapter adapter = new SongAdapter(songList);
        recyclerViewSongs.setAdapter(adapter);
        adapter.setListener(new SongAdapter.Listener() {
            @Override
            public void onClick(int position) {
                //open play activity
                Intent playIntent = new Intent(activity, PlayerActivity.class);
                playIntent.putExtra(INTENT_SONG_LIST, (Serializable) songList);
                playIntent.putExtra(INTENT_SONG_POSITION, position);
//                playIntent.putExtra(PlayerActivity.SONG_ID_EXTRA, songList.get(position).getId());
//                playIntent.putExtra(PlayerActivity.SONG_TITLE_EXTRA, songList.get(position).getTitle());
                startActivity(playIntent);
            }
        });
    }
}
