package com.bkl.air.foi.mdrivingschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.mdrivingschool.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Bunic on 2.11.2016..
 */

public class KontaktAdapter extends RecyclerView.Adapter<KontaktAdapter.KontaktViewHolder>{
    private List<Kontakt> listaKontakt;
    Context context;



    public static class KontaktViewHolder extends RecyclerView.ViewHolder {
        public TextView mKontaktIme;
        public TextView mKontaktPrezime;
        public TextView mKontaktMobitel;
        public TextView mKontaktEmail;
        public ImageView mKontaktSlika;

        public KontaktViewHolder(View itemView) {
            super(itemView);
            mKontaktIme = (TextView) itemView.findViewById(R.id.kontakt_ime);
            mKontaktPrezime = (TextView) itemView.findViewById(R.id.kontakt_prezime);
            mKontaktMobitel = (TextView) itemView.findViewById(R.id.kontakt_mobitel);
            mKontaktEmail = (TextView) itemView.findViewById(R.id.kontakt_email);
           mKontaktSlika = (ImageView) itemView.findViewById(R.id.kontakt_slike);
        }
    }

    public KontaktAdapter(List<Kontakt> listaKontakta, Context context) {
        this.context = context;
        this.listaKontakt = listaKontakta;
    }

    @Override
    public KontaktViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kontakt_list_item, parent, false);
        return new KontaktViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(KontaktViewHolder holder, int position) {
        Kontakt kontakt = listaKontakt.get(position);
        holder.mKontaktIme.setText(kontakt.getIme());
        holder.mKontaktPrezime.setText(kontakt.getPrezime());
        holder.mKontaktMobitel.setText(kontakt.getMobitel());
        holder.mKontaktEmail.setText(kontakt.getEmail());
        Picasso.with(context).load(kontakt.getSlikaUrl()).into(holder.mKontaktSlika);
    }

    @Override
    public int getItemCount() {
        return listaKontakt.size();
    }
}
