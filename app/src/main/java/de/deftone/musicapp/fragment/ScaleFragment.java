package de.deftone.musicapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.activity.PlayerActivity;
import de.deftone.musicapp.adapter.SongAdapter;
import de.deftone.musicapp.model.KeyData;
import de.deftone.musicapp.model.Scales;
import de.deftone.musicapp.model.Song;
import de.deftone.musicapp.model.SongData;

import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_LIST;
import static de.deftone.musicapp.activity.PlayerActivity.INTENT_SONG_POSITION;


public class ScaleFragment extends Fragment {

    public static final String INTENT_SCALE_EXTRA = "scale";
    private KeyData key;

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

    public ScaleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scale, container, false);

        ButterKnife.bind(this, view);

        showBackArrow();

        key = (KeyData) getArguments().getSerializable(INTENT_SCALE_EXTRA);
        scaleName.setText(key.getKeyData().getKeyName());
        scaleNamePenta.setText(key.getKeyData().getKeyName() + " Pentatonik");
        scaleImg.setImageResource(key.getKeyData().getScaleImgResId());
        scaleImgPenta.setImageResource(key.getKeyData().getPentaImgResId());
        switch (InstrumentFragment.getInstrument()) {
            case BB:
                key = Scales.getKlingenderToneForBb(key);
                break;
            case EB:
                key = Scales.getKlingenderToneForEb(key);
                break;
            default:
                //do nothing;
                break;
        }
        List<Song> songList = SongData.getSongsInKey(key);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerViewSongs.setLayoutManager(layoutManager);

        setSongsOnRecyclerView(songList);

        return view;
    }

    private void showBackArrow() {
        //show up arrow
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(),
                drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        //show up arrow (setting it first false and then true is "best practise"...)
        actionBar.setDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //and implement up arrow functionality: set correct tab of viewpager
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show up arrow (setting it first false and then true is "best practise"...)
                actionBar.setDisplayHomeAsUpEnabled(false);
                toggle.setDrawerIndicatorEnabled(true);
                getFragmentManager().popBackStackImmediate();
            }
        });

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
                playIntent.putExtra(INTENT_SCALE_EXTRA, key);
//                playIntent.putExtra(PlayerActivity.SONG_ID_EXTRA, songList.get(position).getId());
//                playIntent.putExtra(PlayerActivity.SONG_TITLE_EXTRA, songList.get(position).getTitle());
                startActivity(playIntent);
            }
        });
    }

}
