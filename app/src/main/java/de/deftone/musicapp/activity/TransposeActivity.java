package de.deftone.musicapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.KeyData;
import de.deftone.musicapp.model.Scales;

//todo: Bb hinzufuegen
public class TransposeActivity extends AppCompatActivity {

    @BindView(R.id.spinner_klingend_eb)
    Spinner spinnerKlinendEb;
    @BindView(R.id.spinner_notiert_eb)
    Spinner spinnerNotiertEb;
    @BindView(R.id.spinner_klingend_bb)
    Spinner spinnerKlinendBb;
    @BindView(R.id.spinner_notiert_bb)
    Spinner spinnerNotiertBb;

    private ArrayAdapter<KeyData> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transpose);
        ButterKnife.bind(this);

        addItemsOnSpinner();
        addListenerOnSpinner();

    }

    public void addItemsOnSpinner() {
        dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Scales.getScale());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKlinendEb.setAdapter(dataAdapter);
        spinnerNotiertEb.setAdapter(dataAdapter);
        spinnerKlinendBb.setAdapter(dataAdapter);
        spinnerNotiertBb.setAdapter(dataAdapter);
    }

    private void addListenerOnSpinner() {
        //setze den ton des notierten spinners
        spinnerNotiertEb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KeyData selectedNotierterTon = (KeyData) spinnerNotiertEb.getItemAtPosition(i);
                KeyData klingenderTon = Scales.getKlingenderToneForEb(selectedNotierterTon);
                spinnerKlinendEb.setSelection(dataAdapter.getPosition(klingenderTon));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //setze den ton des notierten spinners
        spinnerKlinendEb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KeyData selectedKlingenderTon = (KeyData) spinnerNotiertEb.getItemAtPosition(i);
                KeyData notierterTon = Scales.getNotierterToneForEb(selectedKlingenderTon);
                spinnerNotiertEb.setSelection(dataAdapter.getPosition(notierterTon));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
