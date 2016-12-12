package com.bkl.air.foi.mdrivingschool.employee_fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by Jurica Bunić on 8.12.2016..
 */

public class MainEmployeeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_main, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Početna stranica");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik = info.getInfoById(getActivity().getIntent().getStringExtra("USER"));
        TextView textView = (TextView) getView().findViewById(R.id.employee_user_name);
        textView.setText(korisnik.getIme()+" "+korisnik.getPrezime());
        /*
        String data = getActivity().getIntent().getStringExtra("USER");
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("korisnik");
            JSONObject JO = jsonArray.getJSONObject(0);
            String name = JO.getString("ime");
            String surname = JO.getString("prezime");
            TextView textView =(TextView) getView().findViewById(R.id.employee_user_name);
            textView.setText(name +" "+ surname);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

    }
}
