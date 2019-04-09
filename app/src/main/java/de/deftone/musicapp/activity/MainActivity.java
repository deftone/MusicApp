package de.deftone.musicapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import de.deftone.musicapp.R;
import de.deftone.musicapp.fragment.CircleFragment;
import de.deftone.musicapp.fragment.InstrumentFragment;
import de.deftone.musicapp.fragment.TransposeFragment;
import de.deftone.musicapp.fragment.WarmUpFragment;
//https://code.tutsplus.com/tutorials/how-to-code-a-bottom-navigation-bar-for-an-android-app--cms-30305

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(
                getString(R.string.app_name) + " (" + InstrumentFragment.getInstrument() + ")");

        initBottomTabs();
        initFirstFragment();

    }

    //todo: warum funktioniert das antippen beim erten mal nicht???
    private void initFirstFragment() {
        Fragment fragment = new CircleFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }


    private void initBottomTabs() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_circle:
                    default:
                        fragment = new CircleFragment();
                        break;
                    case R.id.navigation_warm_up:
                        fragment = new WarmUpFragment();
                        break;
                    case R.id.navigation_transpose:
                        fragment = new TransposeFragment();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);

                transaction.commit();
                return true;
            }
        });

    }

    //bottom tabs und viewpager
    ///https://stackoverflow.com/questions/47714606/viewpager-using-bottom-navigation-view-is-not-swiping-the-fragments

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}

