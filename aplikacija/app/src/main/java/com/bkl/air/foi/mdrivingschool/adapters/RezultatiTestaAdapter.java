package com.bkl.air.foi.mdrivingschool.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.Vozilo;
import com.bkl.air.foi.mdrivingschool.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalibor on 26.11.2016..
 */

public class RezultatiTestaAdapter extends RecyclerView.Adapter<RezultatiTestaAdapter.MyViewHolder>{
    private List<Pitanje> listaPitanja;
    private List<Integer> tocniIds;
    Context context;
    private int imgId;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView pitanje;
        public ImageView slika;
        public TextView odg1;
        public TextView odg2;
        public TextView odg3;
        public TextView status;

        public MyViewHolder(View view) {
            super(view);
            pitanje = (TextView) view.findViewById(R.id.textView_pitanje_text);
            odg1 = (TextView) view.findViewById(R.id.textView_odg1_text);
            odg2 = (TextView) view.findViewById(R.id.textView_odg2_text);
            odg3 = (TextView) view.findViewById(R.id.textView_odg3_text);
            slika = (ImageView) view.findViewById(R.id.ImageView_slika_pitanja);
            status = (TextView) view.findViewById(R.id.textView_status);
        }
    }


    public RezultatiTestaAdapter(List<Pitanje> listaPitanja, List<Integer> tocniIds, Context context) {
        this.context = context;
        this.listaPitanja = listaPitanja;
        this.tocniIds = tocniIds;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rezultati_testa_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pitanje pitanje = listaPitanja.get(position);
        holder.pitanje.setText(pitanje.getPitanje());

        holder.odg1.setText("a) " + pitanje.getOdg1());
        if(pitanje.isTocan1()==true){holder.odg1.setTextColor(Color.GREEN);}
        holder.odg2.setText("b) " + pitanje.getOdg2());
        if(pitanje.isTocan2()==true){holder.odg2.setTextColor(Color.GREEN);}
        holder.odg3.setText("c) " + pitanje.getOdg3());
        if(pitanje.isTocan3()==true){holder.odg3.setTextColor(Color.GREEN);}
        imgId = context.getResources().getIdentifier(pitanje.getImgUrl(), "drawable", context.getPackageName());
        holder.slika.setImageDrawable(context.getResources().getDrawable(imgId));
        for (int i = 0; i < tocniIds.size(); i++) {
            if (pitanje.getId() == tocniIds.get(i)) {
                holder.status.setText("STATUS: TOČNO");
                holder.status.setTextColor(Color.GREEN);
                break;
            } else {
                holder.status.setText("STATUS: NETOČNO");
                holder.status.setTextColor(Color.RED);
            }
        }
    }

    @Override
    public int getItemCount() {
        return listaPitanja.size();
    }
}
