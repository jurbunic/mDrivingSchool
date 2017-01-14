package com.bkl.air.foi.mdrivingschool.trainee_fragments;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dalibor on 11.1.2017..
 */

public class TraineeDrivingStatusFragment extends Fragment {

    @BindView(R.id.textView_driving_hours)
    TextView currentDrivingHours;

    @BindView(R.id.textView_driving_session)
    TextView nextDrivingSession;

    private String currentUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_trainee_driving_status,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Moji satovi vožnje");

        currentUserId = getArguments().getString("USER_ID");
        UserInfo info = new UserInfo(getActivity());
        Korisnik currentUser = info.getInfoById(currentUserId);

        currentDrivingHours.setText(String.valueOf(currentUser.getSati_voznje()));

        String nextDrive = String.valueOf(currentUser.getDatum_voznje() + " u " + currentUser.getVrijeme_voznje());
        nextDrivingSession.setText(nextDrive);
    }
}
