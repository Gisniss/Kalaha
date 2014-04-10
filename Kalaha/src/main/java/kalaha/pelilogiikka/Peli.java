package kalaha.pelilogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
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
public class Peli extends Timer implements ActionListener{

    private Pelilauta pelilauta;

    public Peli(int pisteetAlussa) {
        super(1000,null);
        pelilauta = new Pelilauta(pisteetAlussa);
        
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }
    /**
     * Liikuttaa yhtä pistettä eteenpäin.
     * @param numero1 , kupin numero josta piste on alkuperäisesti otettu.
     * @param numero2 , kupin numero johon piste laitetaan.
     */

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
    /**
     * Poistaa kupista pisteet ja palauttaa pisteiden määrän.
     * @param kuppi
     * @return 
     */

    public int poistaPisteet(Kuppi kuppi) {
        int pisteet = kuppi.getPisteet();
        kuppi.poistaPisteet();
        return pisteet;
    }
    
    /**
     * Palauttaa kupin mihin kuppiin viimeinen piste laitetaan.
     * @param numero, kupin numero josta pisteet poistetaan.
     * @param pisteet, kupissa olevat pisteet.
     * @return 
     */

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
    
    /**
     * Palauttaa arvon true jos piste on lisätty tyhjään kuppiin.
     * @param kuppi
     * @return 
     */

    public boolean erikoistilanne1(Kuppi kuppi) {
        if (kuppi.getPisteet() == 1 && kuppi.getClass() == Pelikuppi.class) {

            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Palauttaa arvon true jos piste on lisätty pistekuppiin.
     * @param kuppi
     * @return 
     */

    public boolean erikoistilanne2(Kuppi kuppi) {
        if (kuppi.getClass() == Pistekuppi.class) {

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
