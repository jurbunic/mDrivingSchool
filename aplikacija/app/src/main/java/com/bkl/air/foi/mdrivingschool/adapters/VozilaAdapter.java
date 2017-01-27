package com.bkl.air.foi.mdrivingschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkl.air.foi.database.Vozilo;
import com.bkl.air.foi.mdrivingschool.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dalibor on 1.11.2016..
 */

public class VozilaAdapter extends RecyclerView.Adapter<VozilaAdapter.MyViewHolder> {
    private List<Vozilo> listaVozila;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView naziv;
        public ImageView slika;
        public TextView kategorija;
        public TextView motor;
        public TextView detalji;

        public MyViewHolder(View view) {
            super(view);
            naziv = (TextView) view.findViewById(R.id.naziv_vozila);
            kategorija = (TextView) view.findViewById(R.id.kategorija);
            motor = (TextView) view.findViewById(R.id.motor);
            detalji = (TextView) view.findViewById(R.id.detalji_vozila);
            slika = (ImageView) view.findViewById(R.id.slika_vozila);
        }
    }


    public VozilaAdapter(List<Vozilo> listaVozila, Context context) {
        this.context = context;
        this.listaVozila = listaVozila;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vozila_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    /**
     * Metoda postavlja podatke o vozilima i slike vozila na card-view
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Vozilo vozilo = listaVozila.get(position);
        holder.naziv.setText(vozilo.getNaziv());
        holder.kategorija.setText(vozilo.getKategorija());
        holder.motor.setText(vozilo.getMotor());
        holder.detalji.setText(vozilo.getDetalji());
        Picasso.with(context).load(vozilo.getImgUrl()).into(holder.slika);
    }

    @Override
    public int getItemCount() {
        return listaVozila.size();
    }
}
