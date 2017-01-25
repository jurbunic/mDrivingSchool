package com.bkl.air.foi.mdrivingschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.StringDateParser;

import java.util.List;

/**
 * Created by Jurica Bunić on 14.1.2017..
 */

public class SchedulaAdapter extends RecyclerView.Adapter<SchedulaAdapter.ScheduelViewHolder>{
    private List<Korisnik> korisnikList;
    Context context;
    int helper;
    StringDateParser dateParser = new StringDateParser();

    public  static class ScheduelViewHolder extends RecyclerView.ViewHolder{
        public TextView mAppointmentDate;
        public TextView mAppointmentTrainee;
        public TextView mAppointmentStartTime;


        public ScheduelViewHolder(View itemView) {
            super(itemView);
            mAppointmentDate = (TextView) itemView.findViewById(R.id.schedule_date);
            mAppointmentTrainee = (TextView) itemView.findViewById(R.id.schedule_trainee);
            mAppointmentStartTime = (TextView) itemView.findViewById(R.id.schedule_hour_start);

        }
    }

    public SchedulaAdapter(List<Korisnik> korisnikList, Context context) {
        this.korisnikList = korisnikList;
        this.context = context;
    }

    @Override
    public ScheduelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_employee_schedule_item,parent,false);
        return new ScheduelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScheduelViewHolder holder, int position) {

        Korisnik korisnik = korisnikList.get(position);
        holder.mAppointmentDate.setText(dateParser.toUserForm(korisnik.getDatum_voznje()));
        holder.mAppointmentTrainee.setText(korisnik.getIme()+" "+korisnik.getPrezime());
        holder.mAppointmentStartTime.setText(korisnik.getVrijeme_voznje());


    }

    @Override
    public int getItemCount() {
        return korisnikList.size();
    }
}
