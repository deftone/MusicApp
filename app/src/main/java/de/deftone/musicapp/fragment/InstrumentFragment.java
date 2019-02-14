package de.deftone.musicapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.deftone.musicapp.R;
import de.deftone.musicapp.activity.ScaleActivity;
import de.deftone.musicapp.model.KeyData;


public class InstrumentFragment extends Fragment {

    //todo: title anpassen, wenn instrument gewechselt wurde
    //todo: (evtl) spinner layout mit rand und weissem drop down button

    @BindView(R.id.instrument_spinner)
    Spinner instrumentSpinner;

    public InstrumentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instrument, container, false);
        ButterKnife.bind(this, view);
        addItemsOnSpinner();
        addListenerOnSpinner();
        return view;
    }

    public void addItemsOnSpinner() {
        List<KeyData> data = Arrays.asList(KeyData.C, KeyData.BB, KeyData.EB);
        Context context = null;
        if (getActivity() != null)
            context = getActivity();
        else if (getContext() != null)
            context = getContext();
        if (context != null) {
            ArrayAdapter<KeyData> dataAdapter = new ArrayAdapter<>(context,
                    R.layout.spinner_item_layout, data);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            instrumentSpinner.setAdapter(dataAdapter);
            instrumentSpinner.setSelection(data.indexOf(ScaleActivity.getInstrument()));
        }
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
