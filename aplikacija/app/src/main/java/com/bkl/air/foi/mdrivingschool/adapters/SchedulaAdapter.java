package com.bkl.air.foi.mdrivingschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Appointment;
import com.bkl.air.foi.mdrivingschool.R;

import java.util.List;

/**
 * Created by Jurica Bunić on 14.1.2017..
 */

public class SchedulaAdapter extends RecyclerView.Adapter<SchedulaAdapter.ScheduelViewHolder>{
    private List<Appointment> appointmentList;
    Context context;

    public  static class ScheduelViewHolder extends RecyclerView.ViewHolder{
        public TextView mAppointmentDate;
        public TextView mAppointmentTrainee;
        public TextView mAppointmentStartTime;
        public TextView mAppointmentEndTime;

        public ScheduelViewHolder(View itemView) {
            super(itemView);
            mAppointmentDate = (TextView) itemView.findViewById(R.id.schedule_date);
            mAppointmentTrainee = (TextView) itemView.findViewById(R.id.schedule_trainee);
            mAppointmentStartTime = (TextView) itemView.findViewById(R.id.schedule_hour_start);
            mAppointmentEndTime = (TextView) itemView.findViewById(R.id.schedule_hour_finish);
        }
    }

    public SchedulaAdapter(List<Appointment> appointmentList, Context context) {
        this.appointmentList = appointmentList;
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
        Appointment appointment = appointmentList.get(position);
        holder.mAppointmentDate.setText(appointment.getStartDate().toString());
        holder.mAppointmentTrainee.setText("Ivo");
        holder.mAppointmentStartTime.setText(appointment.getStartTime());
        holder.mAppointmentEndTime.setText(appointment.getEndTime());
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }
}
