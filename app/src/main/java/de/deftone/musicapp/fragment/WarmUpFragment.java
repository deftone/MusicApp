package de.deftone.musicapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.activity.PlayerActivity;
import de.deftone.musicapp.adapter.SongAdapter;
import de.deftone.musicapp.model.KeyData;
import de.deftone.musicapp.model.Song;

import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_LIST;
import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_POSITION;
import static de.deftone.musicapp.fragment.ScaleFragment.INTENT_SCALE_EXTRA;


public class WarmUpFragment extends Fragment {

    @BindView(R.id.warmup_img)
    ImageView warmUpImg;
    @BindView(R.id.warmup_text)
    TextView warmUpText;
    @BindView(R.id.recycler_view_song_list_warmup)
    RecyclerView recyclerViewSongs;

    public WarmUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_warm_up, container, false);
        ButterKnife.bind(this, view);

        switch (InstrumentFragment.getInstrument()) {
            case BB:
                warmUpImg.setImageResource(R.drawable.warm_up_bb);
                warmUpText.setText("Übe lange Töne für eine gute Atmung, Stütze und Intonation. " +
                        "Spiele vom mittleren g bis zum tiefen b und dann vom mittlerem g bis zum hohen f. " +
                        "Alternativ eine Oktave höher.");
                break;
            case EB:
                warmUpImg.setImageResource(R.drawable.warm_up_eb);
                warmUpText.setText("Übe lange Töne für eine gute Atmung, Stütze und Intonation. " +
                        "Spiele vom mittleren d bis zum tiefen f und dann vom tiefen d bis zum mittleren c. " +
                        "Alternativ (teilweise) eine Oktave höher.");
                break;
            default:
                warmUpImg.setImageResource(R.drawable.warm_up_c);
                warmUpText.setText("Übe lange Töne für eine gute Atmung, Stütze und Intonation. " +
                        "Spiele vom mittleren a bis zum tiefen c und dann vom mittlerem a bis zum hohem f. " +
                        "Alternativ eine Oktave höher.");
                break;
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerViewSongs.setLayoutManager(layoutManager);
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(KeyData.DEFAULT, "warm_up_full", "warm up (with sax)", "T. Skringer"));
        songList.add(new Song(KeyData.DEFAULT, "warm_up_band", "warm up (band only)", "T. Skringer"));
        setSongsOnRecyclerView(songList);
        return view;
    }

    private void setSongsOnRecyclerView(final List<Song> songList) {
        // specify an adapter
        SongAdapter adapter = new SongAdapter(songList);
        recyclerViewSongs.setAdapter(adapter);
        adapter.setListener(new SongAdapter.Listener() {
            @Override
            public void onClick(int position) {
                //open play activity
                Intent playIntent = new Intent(getActivity(), PlayerActivity.class);
                playIntent.putExtra(INTENT_SONG_LIST, (Serializable) songList);
                playIntent.putExtra(INTENT_SONG_POSITION, position);
                playIntent.putExtra(INTENT_SCALE_EXTRA, KeyData.DEFAULT);
//                playIntent.putExtra(PlayerActivity.SONG_ID_EXTRA, songList.get(position).getId());
//                playIntent.putExtra(PlayerActivity.SONG_TITLE_EXTRA, songList.get(position).getTitle());
                startActivity(playIntent);
            }
        });
    }

}
