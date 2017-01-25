package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.mdrivingschool.OnlinePrijavaFragment;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 25.1.2017..
 */

public class AdministrationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_administration,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Administracija");
    }

    @OnClick(R.id.button_new_trainee_add)
    public void onNewTraineeAddButtonClicked(){
        AddNewTraineeFragment adn = new AddNewTraineeFragment();
        StartFragment.StartNewFragment(adn,getActivity(), "novipolaznik");
    }
    @OnClick(R.id.button_trainee_ins_add)
    public void onNewTraineeInsAddButtonClicked(){
        AssignTraineeToEmployeeFragment atef = new AssignTraineeToEmployeeFragment();
        StartFragment.StartNewFragment(atef,getActivity(), "polaznikinstruktor");
    }
    @OnClick(R.id.button_exam_update)
    public void onExamUpdateButtonClicked(){
        UpdateExamStatusFragment axsf= new UpdateExamStatusFragment();
        StartFragment.StartNewFragment(axsf,getActivity(), "statustestova");
    }
    @OnClick(R.id.button_driving_update)
    public void onDrivingUpdateButtonClicked(){
        UpdateDrivingStatusFragment adsf= new UpdateDrivingStatusFragment();
        StartFragment.StartNewFragment(adsf,getActivity(), "statusvoznje");
    }
}
