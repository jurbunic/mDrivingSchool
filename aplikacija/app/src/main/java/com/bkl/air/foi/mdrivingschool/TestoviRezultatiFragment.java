package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.mdrivingschool.adapters.RezultatiTestaAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.PitanjaData;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dalibor on 26.11.2016..
 */

public class TestoviRezultatiFragment extends Fragment {

    private int tocnost;

    private ArrayList<Integer> poljeZadataka = new ArrayList<>(5);
    private ArrayList<Integer> tocniIds = new ArrayList<>(5);

    private List<Pitanje> listaPitanja = new ArrayList<>();
    private RecyclerView recyclerView;
    private RezultatiTestaAdapter mAdapter;

    private String tipPitanja;

    private InterstitialAd mInterstitial;

    @BindView(R.id.textView_tocnost)
    TextView tocnostTesta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        tocnost=getArguments().getInt("Tocnost");
        poljeZadataka=getArguments().getIntegerArrayList("randomZadaci");
        tocniIds=getArguments().getIntegerArrayList("tocniIds");
        tipPitanja = getArguments().getString("tipPitanja");
        View View = inflater.inflate(R.layout.fragment_testovi_rezultati, container, false);
        ButterKnife.bind(this, View);

        //poziv reklame "interstitial ad"
        mInterstitial = new InterstitialAd(this.getActivity());
        mInterstitial.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitial.show();
            }
        });
        mInterstitial.loadAd(new AdRequest.Builder().build());

        return View;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Testovi znanja - rezultati");
        tocnostTesta.setText("" + tocnost + "/5");

        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_rezultati);

        if (tipPitanja=="propisi") {
            PitanjaData.nabaviPodatkeOdredenihPitanja(listaPitanja, poljeZadataka, 1);
        }else {
            PitanjaData.nabaviPodatkeOdredenihPitanja(listaPitanja, poljeZadataka, 2);
        }

        mAdapter = new RezultatiTestaAdapter(listaPitanja, tocniIds, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }
}
