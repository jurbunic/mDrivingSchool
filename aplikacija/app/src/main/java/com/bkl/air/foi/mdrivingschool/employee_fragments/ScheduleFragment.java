package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.bkl.air.foi.database.Appointment;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.adapters.SchedulaAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jurica Bunić on 14.1.2017..
 */

public class ScheduleFragment extends Fragment {

    private List<Appointment> appointmentList;
    private RecyclerView recyclerView;
    private SchedulaAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_schedule, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Raspored vožnje");
        recyclerView = (RecyclerView) getView().findViewById(R.id.main_recycler);

        ImageButton button = (ImageButton) getActivity().findViewById(R.id.schedule_toolbar_addButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        appointmentList = new ArrayList<>();
        appointmentList = Appointment.getAll();


        if(appointmentList.size()==0) {


            Appointment appointment = new Appointment();
            appointment.setStartTime("11:20");
            appointment.setEndTime("12:20");
            appointment.setStartDate("12-11-2000");
            appointment.save();
            appointmentList.add(appointment);
        }


        mAdapter = new SchedulaAdapter(appointmentList,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }
}
