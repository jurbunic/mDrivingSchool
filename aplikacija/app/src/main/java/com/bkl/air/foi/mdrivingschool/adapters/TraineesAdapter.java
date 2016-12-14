package com.bkl.air.foi.mdrivingschool.adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.employee_fragments.TraineeDetails;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;

import java.util.List;

/**
 * Created by Jurica Bunić on 14.12.2016..
 */

public class TraineesAdapter extends  RecyclerView.Adapter<TraineesAdapter.KorisnikViewHolder> {

    private List<Korisnik> korisnikList;
    Context context;



    public static class KorisnikViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView mKorisnikNaziv;
        public TextView mKorisnikMobitel;
        public TextView mKorisnikEmail;
        public TextView mKorisnikVoznja;
        public TextView mKorisnikId;

        private Context context;

        public KorisnikViewHolder(View itemView ,Context context) {
            super(itemView);

            this.context = context;
            mKorisnikNaziv = (TextView) itemView.findViewById(R.id.naziv_polaznika);
            mKorisnikMobitel = (TextView) itemView.findViewById(R.id.mobitel);
            mKorisnikEmail = (TextView) itemView.findViewById(R.id.email);
            mKorisnikVoznja = (TextView) itemView.findViewById(R.id.sat_voznja);
            mKorisnikId =(TextView) itemView.findViewById(R.id.trainee_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Bundle args = new Bundle();
            args.putString("id",(String)mKorisnikId.getText());

            TraineeDetails td = new TraineeDetails();
            td.setArguments(args);

            FragmentTransaction ft = ((Activity)context).getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container,td);
            ft.addToBackStack("novi_fragment");
            ft.commit();

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    public TraineesAdapter(List<Korisnik> korisnikList, Context context) {
        this.korisnikList = korisnikList;
        this.context = context;
    }

    @Override
    public KorisnikViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainee_list_item,parent,false);
        return new KorisnikViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(KorisnikViewHolder holder, int position) {
        Korisnik korisnik = korisnikList.get(position);
        holder.mKorisnikNaziv.setText(korisnik.getIme()+" "+korisnik.getPrezime());
        holder.mKorisnikMobitel.setText(korisnik.getMobitel());
        holder.mKorisnikEmail.setText(korisnik.getEmail());
        holder.mKorisnikId.setText(Integer.toString(korisnik.getId()));
        holder.mKorisnikVoznja.setText(Integer.toString(korisnik.getSati_voznje()));

    }

    @Override
    public int getItemCount() {
        return korisnikList.size();
    }

}
