package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.database.Vozilo;

import java.util.List;

/**
 * Created by Dalibor on 3.11.2016..
 */

public class VozilaData {

    public static void nabaviPodatkeVozila(List<Vozilo> listaVozila) {
        Vozilo vozilo = new Vozilo(1, "Škoda Fabia", "http://autoskola-premuz.hr/wp-content/uploads/2014/12/fabia-silver1.jpg",
                "B kategorija", "Dizelski motor", "75ks, 55kw, 1600ccm");
        listaVozila.add(vozilo);
        vozilo.save();

        vozilo = new Vozilo(2, "Škoda Rapid", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/rapid.jpg",
                "B kategorija", "Dizelski motor", "90ks, 66kw, 1600ccm");
        listaVozila.add(vozilo);
        vozilo.save();

        vozilo = new Vozilo(3, "Škoda Octavia", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/octavia.jpg",
                "B kategorija", "Dizelski motor", "105ks, 77kw, 1600ccm");
        listaVozila.add(vozilo);
        vozilo.save();

        vozilo = new Vozilo(4, "Golf VII", "http://autoskola-premuz.hr/wp-content/uploads/2016/11/golf.jpg",
                "B kategorija", "Dizelski motor", "110 ks, 81 kw, 1600 ccm");
        listaVozila.add(vozilo);
        vozilo.save();

        vozilo = new Vozilo(5, "Renault Clio", "http://autoskola-premuz.hr/wp-content/uploads/2016/11/clio1.jpg",
                "B kategorija", "Dizelski motor", "75 ks, 55 kw, 1500 ccm");
        listaVozila.add(vozilo);
        vozilo.save();

        vozilo = new Vozilo(6, "Kymco Zing 125", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/kimco.jpg",
                "A1 kategorija", "Motocikl", "125 ccm");
        listaVozila.add(vozilo);
        vozilo.save();

        vozilo = new Vozilo(7, "Kawasaki Er 6n", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/kawasaki.jpg",
                "A kategorija", "Motocikl", "650ccm");
        listaVozila.add(vozilo);
        vozilo.save();
    }

}
