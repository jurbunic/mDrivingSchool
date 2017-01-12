package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.maps.MapFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 9.11.2016..
 */

public class MainScreenFragment extends Fragment {

    Animation Fade_in, Fade_out;

    @BindView(R.id.bckgrndViewFlipper)
    ViewFlipper viewFlipper;

    @BindView(R.id.imageButton)
    ImageButton imageButton1;

    @BindView(R.id.imageButton2)
    ImageButton imageButton2;

    @BindView(R.id.imageButton3)
    ImageButton imageButton3;

    @BindView(R.id.adView)
    AdView adView;

    NavigationView navigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.main_screen_fragment, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Početna stranica");
        ButterKnife.bind(this, View);

        Fade_in = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
        Fade_out = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_out);

        viewFlipper.setInAnimation(Fade_in);
        viewFlipper.setOutAnimation(Fade_out);


        navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();

        initializeAds();
        return View;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Metoda sluzi za inicijaciju banner ad reklame
     */
    private void initializeAds(){
        AdRequest.Builder adBuilder = new AdRequest.Builder();
        adView.loadAd(adBuilder.build());
    }


    @OnClick(R.id.imageButton)
    public void onButtonImageClick1(){
        OnlinePrijavaFragment fop = new OnlinePrijavaFragment();
        StartFragment.StartNewFragment(fop,getActivity());
    }

    @OnClick(R.id.imageButton2)
    public void onButtonImageClick2(){
        TestoviMainFragment fk = new TestoviMainFragment();
        StartFragment.StartNewFragment(fk,getActivity());
    }

    @OnClick(R.id.imageButton3)
    public void onButtonImageClick3(){
        MapFragment fv = new MapFragment();
        StartFragment.StartNewFragment(fv,getActivity());
    }
}
