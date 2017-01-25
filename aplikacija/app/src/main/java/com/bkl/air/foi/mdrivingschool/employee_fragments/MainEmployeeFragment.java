package com.bkl.air.foi.mdrivingschool.employee_fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.TestoviMainFragment;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jurica Bunić on 8.12.2016..
 */

public class MainEmployeeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_main, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Početna stranica");
        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik = info.getInfoById(getActivity().getIntent().getStringExtra("USER"));
        TextView textView = (TextView) getView().findViewById(R.id.employee_user_name);
        textView.setText(korisnik.getIme()+" "+korisnik.getPrezime());


    }

    @OnClick(R.id.employee_main_img_btn_polaznici)
    public void onImageButtonTzzClicked(){
        MyTraineesFragment fk = new MyTraineesFragment();
        StartFragment.StartNewFragment(fk,getActivity());
    }

    @OnClick(R.id.employee_main_img_btn_raspored)
    public void onImageButtonRasporedClicked(){
        ScheduleFragment sf = new ScheduleFragment();
        StartFragment.StartNewFragment(sf,getActivity());
    }

    @OnClick(R.id.employee_main_img_btn_administracija)
    public void onImageButtonAdministracijaClicked(){
        AdministrationFragment adf = new AdministrationFragment();
        StartFragment.StartNewFragment(adf,getActivity());
    }

}
