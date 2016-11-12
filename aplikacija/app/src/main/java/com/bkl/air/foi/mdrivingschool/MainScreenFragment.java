package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dalibor on 9.11.2016..
 */

public class MainScreenFragment extends Fragment {

    Animation Fade_in, Fade_out;
    private Unbinder unbinder;

    @BindView(R.id.bckgrndViewFlipper)
    ViewFlipper viewFlipper;

    @BindView(R.id.imageButton)
    ImageButton imageButton1;

    @BindView(R.id.imageButton2)
    ImageButton imageButton2;

    @BindView(R.id.imageButton3)
    ImageButton imageButton3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View calcView = inflater.inflate(R.layout.main_screen_fragment, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Početna stranica");
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

    @OnClick(R.id.imageButton)
    public void onButtonImageClick1(){
        OnlinePrijavaFragment fop = new OnlinePrijavaFragment();
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fop);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack("Online prijava     ");
        fm.commit();
    }

    @OnClick(R.id.imageButton2)
    public void onButtonImageClick2(){
        KontaktFragment fk = new KontaktFragment();
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fk);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack("Kontakt     ");
        fm.commit();
    }

    @OnClick(R.id.imageButton3)
    public void onButtonImageClick3(){
        VozilaFragment fv = new VozilaFragment();
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fv);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack("vozila   ");
        fm.commit();
    }
}
