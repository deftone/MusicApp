package de.deftone.musicapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

import de.deftone.musicapp.R;
import de.deftone.musicapp.fragment.CircleFragment;
import de.deftone.musicapp.fragment.InstrumentFragment;
import de.deftone.musicapp.fragment.TransposeFragment;
import de.deftone.musicapp.fragment.WarmUpFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(
                getString(R.string.app_name) + " (" + InstrumentFragment.getInstrument() + ")");

        setUpViewPager();

    }


    private void setUpViewPager() {
        //Attach the SectionsPagerAdapter to the Viewpager
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);

        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Zirkel");
        tabLayout.getTabAt(1).setText("Warm up");
        tabLayout.getTabAt(2).setText("Transpo");
    }

    //viewpager
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CircleFragment();
                case 1:
                    return new WarmUpFragment();
                case 2:
                    return new TransposeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}

