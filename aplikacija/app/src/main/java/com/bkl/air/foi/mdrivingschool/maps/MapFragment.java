package com.bkl.air.foi.mdrivingschool.maps;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bkl.air.foi.mdrivingschool.MainActivity;
import com.bkl.air.foi.mdrivingschool.R;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Jurica Bunić on 22.11.2016..
 */

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private com.google.android.gms.maps.MapFragment mapFragment;
    private GoogleMap map = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(com.bkl.air.foi.mdrivingschool.R.layout.fragment_map, container, false);
        mapFragment = new com.google.android.gms.maps.MapFragment();
        getFragmentManager().beginTransaction().add(R.id.frame, mapFragment).commit();
        return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Mapa");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        // Pokušaj dohvaćanja korisničke lokacije
        try{
            map.setMyLocationEnabled(true);
        }catch (SecurityException e){
            Toast.makeText(getActivity().getApplicationContext(),"Nije moguće dohvatiti vašu lokaciju",Toast.LENGTH_SHORT).show();
        }

        // Postavljanje markera na lokaciju Autoškole Premuž
        LatLng position = new LatLng(46.309999,16.341981);
        map.addMarker(new MarkerOptions().position(position).title("Autoškola Premuž")).showInfoWindow();

        map.moveCamera(CameraUpdateFactory.newLatLng(position));
        map.moveCamera(CameraUpdateFactory.zoomTo(13));
    }
}
