package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.adapters.SchedulaAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Jurica Bunić on 14.1.2017..
 */

public class ScheduleFragment extends Fragment{

    private List<Korisnik> korisnikList;
    private RecyclerView recyclerView;
    private RecyclerView secondRecyclerView;
    private SchedulaAdapter mAdapter1;
    private SchedulaAdapter mAdapter2;

    private String token;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_schedule, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Raspored vožnje");
        recyclerView = (RecyclerView) getView().findViewById(R.id.main_recycler);
        secondRecyclerView = (RecyclerView) getView().findViewById(R.id.main_recycler1);
        ImageButton button = (ImageButton) getActivity().findViewById(R.id.schedule_toolbar_addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            UpdateDrivingStatusFragment udsf = new UpdateDrivingStatusFragment();
            StartFragment.StartNewFragment(udsf,getActivity(),"");
            }
        });

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        Date drivingDate;


        korisnikList = new ArrayList<>();
        UserInfo userInfo = new UserInfo(getActivity().getApplicationContext());
        korisnikList = userInfo.getTrainees(getActivity().getIntent().getStringExtra("USER"));

        List<Korisnik> todayAppointment = new ArrayList<>();
        List<Korisnik> futureAppointment = new ArrayList<>();

        Korisnik korisnik;


        for(int i=0; i<korisnikList.size();i++){
            korisnik = korisnikList.get(i);
            drivingDate = convertStringToDate(korisnik.getDatum_voznje());
            if(isToday(drivingDate,currentDate)){
                todayAppointment.add(korisnik);
            }
            if(drivingDate.after(currentDate)){
                futureAppointment.add(korisnik);
            }

        }

        mAdapter1 = new SchedulaAdapter(todayAppointment,getActivity());
        mAdapter2 = new SchedulaAdapter(futureAppointment,getActivity());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        secondRecyclerView.setLayoutManager(mLayoutManager1);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        secondRecyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter1);
        secondRecyclerView.setAdapter(mAdapter2);

        mAdapter1.notifyDataSetChanged();
        mAdapter2.notifyDataSetChanged();
    }

    private Date convertStringToDate(String sDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = new Date();
        try {
            return convertedDate = dateFormat.parse(sDate);
        }catch(ParseException e){
            return null;
        }

    }

    private boolean isToday(Date date1, Date date2){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateA = sdf.parse(sdf.format(date1));
            Date dateB = sdf.parse(sdf.format(date2));
            if(dateA.equals(dateB)){
                return true;
            }else {
                return false;
            }
        }catch (ParseException p){
            return false;
        }



    }


}
