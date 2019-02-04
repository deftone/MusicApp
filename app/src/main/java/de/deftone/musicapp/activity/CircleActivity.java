package de.deftone.musicapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.KeyData;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        ButterKnife.bind(this);
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
