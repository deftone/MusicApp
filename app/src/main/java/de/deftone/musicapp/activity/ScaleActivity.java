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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.adapter.SongAdapter;
import de.deftone.musicapp.model.KeyData;
import de.deftone.musicapp.model.Song;
import de.deftone.musicapp.model.SongData;

import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_LIST;
import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_POSITION;

public class ScaleActivity extends AppCompatActivity {

    public static final String INTENT_SCALE_EXTRA = "scale";

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
    private KeyData key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        ButterKnife.bind(this);

        key = (KeyData) getIntent().getSerializableExtra(INTENT_SCALE_EXTRA);
        scaleName.setText(key.getKeyData().getKeyName());
        scaleNamePenta.setText(key.getKeyData().getKeyName() + " Pentatonik");
        scaleImg.setImageResource(key.getKeyData().getScaleImgResId());
        scaleImgPenta.setImageResource(key.getKeyData().getPentaImgResId());
        List<Song> songList = SongData.getSongsInKey(key);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerViewSongs.setLayoutManager(layoutManager);

        setSongsOnRecyclerView(songList);
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
                playIntent.putExtra(INTENT_SCALE_EXTRA, key);
//                playIntent.putExtra(PlayerActivity.SONG_ID_EXTRA, songList.get(position).getId());
//                playIntent.putExtra(PlayerActivity.SONG_TITLE_EXTRA, songList.get(position).getTitle());
                startActivity(playIntent);
            }
        });
    }
}
