package de.deftone.musicapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.deftone.musicapp.R;
import de.deftone.musicapp.model.KeyData;

//todo: wenn scale fragment aufpoppt darf man dieses fragment nicht mehr sehen!
public class CircleFragment extends Fragment {

    @BindView(R.id.button_c)
    Button buttonC;
    @BindView(R.id.button_g)
    Button buttonG;
    @BindView(R.id.button_d)
    Button buttonD;
    @BindView(R.id.button_a)
    Button buttonA;
    @BindView(R.id.button_e)
    Button buttonE;
    @BindView(R.id.button_b)
    Button buttonB;
    @BindView(R.id.button_fis)
    Button buttonFis;
    @BindView(R.id.button_db)
    Button buttonDb;
    @BindView(R.id.button_ab)
    Button buttonAb;
    @BindView(R.id.button_eb)
    Button buttonEb;
    @BindView(R.id.button_bb)
    Button buttonBb;
    @BindView(R.id.button_f)
    Button buttonF;
    @BindView(R.id.circle_top_text)
    TextView topText;
    @BindView(R.id.circle_bottom_text)
    TextView bottomText;
    @BindView(R.id.circle_image)
    ImageView circleImage;

    public CircleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        ButterKnife.bind(this, view);
        initLayout();
//        updateVisibility(View.VISIBLE);
        return view;
    }

    private void initLayout() {
        DisplayMetrics metrics = new DisplayMetrics();
        Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;
        int usableWidth = metrics.widthPixels;

        //real height is larger and contains also status bar and soft keys bar (i guess)
//        getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
//        int realHeight = metrics.heightPixels; //width is the same!

        int actionbarHeight = Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).getHeight();

        //size of button in px (although it is defined in dp)
        int buttonWidth = (int) getResources().getDimension(R.dimen.button_width);

        //center coordinates (and also include button dimensions)
        int centerX = usableWidth / 2 - buttonWidth / 2;
        int centerY = usableHeight / 2 - actionbarHeight - buttonWidth / 5;  //hier ist noch ein bug? muesste /2 und nicht /5 sein... aber dann simmt es nicht

        //radius of circle is half of the width
        int radius = usableWidth / 2;

        float sin30 = (float) Math.sin(30. / 180 * Math.PI);
        float cos30 = (float) Math.cos(30. / 180 * Math.PI);

        float distanceFromCenter = .75f * radius;

        //the 4 buttons "on the cross" (i.e 0, 3, 6 and 9 o'clock)
        buttonC.setX(centerX);
        buttonC.setY(centerY - distanceFromCenter);

        buttonA.setX(centerX + distanceFromCenter);
        buttonA.setY(centerY);

        buttonEb.setX(centerX - distanceFromCenter);
        buttonEb.setY(centerY);

        buttonFis.setX(centerX);
        buttonFis.setY(centerY + distanceFromCenter);

        //the 4 buttons shifted by 30 degrees from y-axis (i.e. 1, 5, 7 and 11 o'clock)
        buttonG.setX(centerX + sin30 * distanceFromCenter);
        buttonG.setY(centerY - cos30 * distanceFromCenter);

        buttonF.setX(centerX - sin30 * distanceFromCenter);
        buttonF.setY(centerY - cos30 * distanceFromCenter);

        buttonB.setX(centerX + sin30 * distanceFromCenter);
        buttonB.setY(centerY + cos30 * distanceFromCenter);

        buttonDb.setX(centerX - sin30 * distanceFromCenter);
        buttonDb.setY(centerY + cos30 * distanceFromCenter);

        // the 4 buttons shifted by 30 degrees from x-axis (i.e.  2, 4, 8 and 10 o'clock)
        buttonD.setX(centerX + cos30 * distanceFromCenter);
        buttonD.setY(centerY - sin30 * distanceFromCenter);

        buttonE.setX(centerX + cos30 * distanceFromCenter);
        buttonE.setY(centerY + sin30 * distanceFromCenter);

        buttonBb.setX(centerX - cos30 * distanceFromCenter);
        buttonBb.setY(centerY - sin30 * distanceFromCenter);

        buttonAb.setX(centerX - cos30 * distanceFromCenter);
        buttonAb.setY(centerY + sin30 * distanceFromCenter);

        //set text views between top/bottom border and circle
        int textHeight = (int) getResources().getDimension(R.dimen.large_text);
        int midWayCircleBorder = ((usableHeight - actionbarHeight) / 2 - radius) / 2;
        topText.setY(midWayCircleBorder - textHeight);
        bottomText.setY((usableHeight - actionbarHeight) - midWayCircleBorder - textHeight);
    }

    private void openScaleFragment(KeyData keyData) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ScaleFragment.INTENT_SCALE_EXTRA, keyData);
        Fragment scaleFragment = new ScaleFragment();
        scaleFragment.setArguments(bundle);
        FragmentTransaction ft = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, scaleFragment);
        ft.addToBackStack(null);
        ft.commit();
        //don't show texts and circle in next fragment todo! muessen aber bei popBackStackImmediate wieder alle sehen!
//        updateVisibility(View.GONE);
    }

    private void updateVisibility(int visibility) {
        bottomText.setVisibility(visibility);
        topText.setVisibility(visibility);
        circleImage.setVisibility(visibility);
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
