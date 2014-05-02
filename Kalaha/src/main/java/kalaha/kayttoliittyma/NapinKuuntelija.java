/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import kalaha.pelilauta.Kuppi;
import kalaha.pelilauta.Pelilauta;
import kalaha.pelilogiikka.Peli;

/**
 *
 * @author Krista
 * Luokka kuuntelee Pelikayttoliittimassa olevan pelialustan nappeja.
 */
public class NapinKuuntelija implements ActionListener {

    private Peli peli;
    private Pelialusta alusta;
    private int nopeus;

    public NapinKuuntelija(Peli b, Pelialusta a) {

        peli = b;
        alusta = a;
        nopeus = 2000;


    }

    @Override
    public void actionPerformed(ActionEvent a) {
        int nappi = Integer.parseInt(a.getActionCommand());
        System.out.println("nappia painettu " + nappi);
        if (peli.getPelilauta().getKupit().get(nappi).getPisteet() == 0) {
            return;
        }
        Kuppi vika = peli.viimeinen(nappi, peli.getPelilauta().getKupit().get(nappi).getPisteet());
        peli.kierros(nappi);
        if (peli.erikoistilanne2(vika) == true) {
            alusta.paivita();
            return;
        }
        if (peli.loppuikoPeli() == true) {
            peli.siirraLoputPisteet();
            peliLoppui();
            alusta.paivita();

            return;

        }

        peli.tietokoneenVuoro();

        if (peli.loppuikoPeli() == true) {
            peli.siirraLoputPisteet();
            peliLoppui();
        }
        alusta.paivita();

    }
    /**
     * asettaa lopputekstin pelin loppumisen jälkeen ylimmäiseen tekstikenttään.
     */

    public void peliLoppui() {
        if (peli.getPelilauta().getKupit().get(7).getPisteet() > peli.getPelilauta().getKupit().get(14).getPisteet()) {
            alusta.getTekstikentta().setText("Onneksi olkoon voitit pelin!!!");
        }
        else if (peli.getPelilauta().getKupit().get(7).getPisteet() == peli.getPelilauta().getKupit().get(14).getPisteet()) {
            alusta.getTekstikentta().setText("Tasapeli.");
        }else{
            alusta.getTekstikentta().setText("Hävisit pelin, parempi onni ensikerralla.");
            System.out.println(peli.getPelilauta().getKupit().get(7).getPisteet() + peli.getPelilauta().getKupit().get(14).getPisteet());
        }
    }
}
