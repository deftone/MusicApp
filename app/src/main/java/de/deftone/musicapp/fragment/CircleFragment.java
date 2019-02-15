package de.deftone.musicapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.KeyData;

public class CircleFragment extends Fragment {

    public CircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void openScaleFragment(KeyData keyData) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ScaleFragment.INTENT_SCALE_EXTRA, keyData);
        Fragment scaleFragment = new ScaleFragment();
        scaleFragment.setArguments(bundle);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, scaleFragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    @OnClick(R.id.button_c)
    void showScaleC() {
        openScaleFragment(KeyData.C);
    }

    @OnClick(R.id.button_d)
    void showScaleD() {
        openScaleFragment(KeyData.D);
    }

    @OnClick(R.id.button_e)
    void showScaleE() {
        openScaleFragment(KeyData.E);
    }

    @OnClick(R.id.button_f)
    void showScaleF() {
        openScaleFragment(KeyData.F);
    }

    @OnClick(R.id.button_g)
    void showScaleG() {
        openScaleFragment(KeyData.G);
    }

    @OnClick(R.id.button_a)
    void showScaleA() {
        openScaleFragment(KeyData.A);
    }

    @OnClick(R.id.button_b)
    void showScaleB() {
        openScaleFragment(KeyData.B);
    }

    @OnClick(R.id.button_fis)
    void showScaleFis() {
        openScaleFragment(KeyData.FIS);
    }

    @OnClick(R.id.button_bb)
    void showScaleBb() {
        openScaleFragment(KeyData.BB);
    }

    @OnClick(R.id.button_eb)
    void showScaleEb() {
        openScaleFragment(KeyData.EB);
    }

    @OnClick(R.id.button_ab)
    void showScaleAb() {
        openScaleFragment(KeyData.AB);
    }

    @OnClick(R.id.button_db)
    void showScaleDb() {
        openScaleFragment(KeyData.DB);
    }

}
