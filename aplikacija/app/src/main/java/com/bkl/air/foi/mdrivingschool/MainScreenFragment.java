package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dalibor on 9.11.2016..
 */

public class MainScreenFragment extends Fragment {

    Animation Fade_in, Fade_out;
    private Unbinder unbinder;

    @BindView(R.id.bckgrndViewFlipper)
    ViewFlipper viewFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View calcView = inflater.inflate(R.layout.main_screen_fragment, container, false);
        unbinder = ButterKnife.bind(this,calcView);

        Fade_in = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
        Fade_out = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_out);

        viewFlipper.setInAnimation(Fade_in);
        viewFlipper.setOutAnimation(Fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();
        return calcView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
