package com.bkl.air.foi.mdrivingschool.vozila;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkl.air.foi.mdrivingschool.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Dalibor on 1.11.2016..
 */

public class VozilaAdapter extends RecyclerView.Adapter<VozilaAdapter.MyViewHolder> {
    private List<Vozilo> listaVozila;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView naziv;
        public ImageView slika;

        public MyViewHolder(View view) {
            super(view);
            naziv = (TextView) view.findViewById(R.id.naziv_vozila);
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

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Vozilo vozilo = listaVozila.get(position);
        holder.naziv.setText(vozilo.getNaziv());
        Picasso.with(context).load(vozilo.getImgUrl()).into(holder.slika);
    }

    @Override
    public int getItemCount() {
        return listaVozila.size();
    }
}
