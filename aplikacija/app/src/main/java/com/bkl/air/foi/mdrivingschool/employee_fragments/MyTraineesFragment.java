package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.adapters.TraineesAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jurica Bunić on 13.12.2016..
 */

public class MyTraineesFragment extends Fragment {
    private List<Korisnik> listKorisnik = new ArrayList<>();
    private RecyclerView recyclerView;
    private TraineesAdapter mAdapter;
    private String userId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_my_trainees, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Moji polaznici");
        recyclerView = (RecyclerView) getView().findViewById(R.id.main_recycler);
        userId = getActivity().getIntent().getStringExtra("USER");
        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        listKorisnik = info.getTrainees(userId);


        mAdapter =new TraineesAdapter(listKorisnik,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
