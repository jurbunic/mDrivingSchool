package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.mdrivingschool.vozila.Vozilo;

import java.util.List;

/**
 * Created by Dalibor on 3.11.2016..
 */

public class VozilaData {

    public static void nabaviPodatkeVozila(List<Vozilo> listaVozila) {
        Vozilo vozilo = new Vozilo(1, "Škoda Fabia", "http://autoskola-premuz.hr/wp-content/uploads/2014/12/fabia-silver1.jpg");
        listaVozila.add(vozilo);

        vozilo = new Vozilo(2, "Škoda Rapid", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/rapid.jpg");
        listaVozila.add(vozilo);

        vozilo = new Vozilo(3, "Škoda Octavia", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/octavia.jpg");
        listaVozila.add(vozilo);

    }

}
