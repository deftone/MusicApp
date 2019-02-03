package de.deftone.musicapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.adapter.SongAdapter;
import de.deftone.musicapp.model.Key;
import de.deftone.musicapp.model.Song;

public class ScaleActivity extends AppCompatActivity {

    public static final String SCALE_EXTRA = "scale";

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
        scaleName.setText("C-Dur");
        scaleNamePenta.setText("C-Dur Pentatonik");
        scaleImg.setImageResource(R.drawable.c_dur);
        scaleImgPenta.setImageResource(R.drawable.c_dur_penta);
        //todo: get scales and songs for that key!
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

    private void setSongsOnRecyclerView(List<Song> songList) {
        // specify an adapter
        SongAdapter adapter = new SongAdapter(songList);
        recyclerViewSongs.setAdapter(adapter);
        adapter.setListener(new SongAdapter.Listener() {
            @Override
            public void onClick(int position) {
                //open play activity
//                Intent playIntent = new Intent(this, PlayActivity.class);
//                playIntent.putExtra(INTENT_SONGLIST, (Serializable) songList);
//                playIntent.putExtra(INTENT_SONG_ID, position);
//                startActivity(playIntent);
            }
        });
    }
}
