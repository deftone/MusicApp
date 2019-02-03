package de.deftone.musicapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.KeyData;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openScaleIntent(KeyData keyData) {
        Intent scaleIntent = new Intent(this, ScaleActivity.class);
        scaleIntent.putExtra(ScaleActivity.INTENT_SCALE_EXTRA, keyData);
        startActivity(scaleIntent);
    }

    @OnClick(R.id.button_c)
    void showScaleC() {
        openScaleIntent(KeyData.C);
    }

    @OnClick(R.id.button_d)
    void showScaleD() {
        openScaleIntent(KeyData.D);
    }

    @OnClick(R.id.button_e)
    void showScaleE() {
        openScaleIntent(KeyData.E);
    }

    @OnClick(R.id.button_f)
    void showScaleF() {
        openScaleIntent(KeyData.F);
    }

    @OnClick(R.id.button_g)
    void showScaleG() {
        openScaleIntent(KeyData.G);
    }

    @OnClick(R.id.button_a)
    void showScaleA() {
        openScaleIntent(KeyData.A);
    }

    @OnClick(R.id.button_b)
    void showScaleB() {
        openScaleIntent(KeyData.B);
    }

    @OnClick(R.id.button_fis)
    void showScaleFis() {
        openScaleIntent(KeyData.FIS);
    }

    @OnClick(R.id.button_bb)
    void showScaleBb() {
        openScaleIntent(KeyData.BB);
    }

    @OnClick(R.id.button_eb)
    void showScaleEb() {
        openScaleIntent(KeyData.EB);
    }

    @OnClick(R.id.button_ab)
    void showScaleAb() {
        openScaleIntent(KeyData.AB);
    }

    @OnClick(R.id.button_db)
    void showScaleDb() {
        openScaleIntent(KeyData.DB);
    }

}
