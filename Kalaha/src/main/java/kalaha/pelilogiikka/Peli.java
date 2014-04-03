package kalaha.pelilogiikka;

import kalaha.pelilauta.Kuppi;
import kalaha.pelilauta.Pelikuppi;
import kalaha.pelilauta.Pelilauta;
import kalaha.pelilauta.Pistekuppi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Krista
 * 
 * Luokka luo pelilaudan ja määrittelee kuinka pisteitä liikutetaan.
 */
public class Peli {

    private Pelilauta pelilauta;

    public Peli(int pisteetAlussa) {
        pelilauta = new Pelilauta(pisteetAlussa);
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    public void askel(int numero1, int numero2) {
        Kuppi kuppi = pelilauta.getKupit().get(numero2);
        if (numero1 < 7 && kuppi.getNumero() == 14) {
            kuppi = kuppi.getSeuraavaKuppi();
        }
        if (numero1 > 7 && kuppi.getNumero() == 7) {
            kuppi = kuppi.getSeuraavaKuppi();
        }
        kuppi.lisaaPiste();

    }

    public int poistaPisteet(Kuppi kuppi) {
        int pisteet = kuppi.getPisteet();
        kuppi.poistaPisteet();
        return pisteet;
    }

    public Kuppi viimeinen(int numero, int pisteet) {
        Kuppi kuppi = pelilauta.getKupit().get(numero).getSeuraavaKuppi();
        Kuppi viimeisin = kuppi;
        for (int i = pisteet; i > 0; i--) {
            if (numero < 7 && kuppi.getNumero() == 14) {
                kuppi = kuppi.getSeuraavaKuppi();
            }
            if (numero > 7 && kuppi.getNumero() == 7) {
                kuppi = kuppi.getSeuraavaKuppi();
            }

            viimeisin = kuppi;
            kuppi = kuppi.getSeuraavaKuppi();
        }
        return viimeisin;
    }

    public boolean erikoistilanne1(Kuppi kuppi) {
        if (kuppi.getPisteet() == 1 && kuppi.getClass() == Pelikuppi.class) {

            return true;
        } else {
            return false;
        }
    }

    public boolean erikoistilanne2(Kuppi kuppi) {
        if (kuppi.getClass() == Pistekuppi.class) {

            return true;
        } else {
            return false;
        }
    }
}
