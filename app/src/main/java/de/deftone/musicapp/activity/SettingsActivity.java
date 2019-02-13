package de.deftone.musicapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.KeyData;

public class SettingsActivity extends AppCompatActivity {

    //todo: spinner einstellen, dass man sieht was ausgewaehlt war
    @BindView(R.id.instrument_spinner)
    Spinner instrumentSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        addItemsOnSpinner();
        addListenerOnSpinner();
    }

    public void addItemsOnSpinner() {
        List<KeyData> data = Arrays.asList(KeyData.C, KeyData.BB, KeyData.EB);
        ArrayAdapter<KeyData> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, data);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        instrumentSpinner.setAdapter(dataAdapter);

    }

    private void addListenerOnSpinner() {
        instrumentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KeyData selectedInstrument = (KeyData) instrumentSpinner.getItemAtPosition(i);
                ScaleActivity.setInstrument(selectedInstrument);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
