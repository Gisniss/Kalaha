package kalaha.pelilogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Timer;
import kalaha.kayttoliittyma.Pelialusta;
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
    
    /**
     * metodi saa parametrina kupin numeron jonka pisteet se jakaa ja tarkistaa menikö viimeinen piste tyhjään kuppiin.
     * @param numero 
     */

    public void kierros(int numero) {
        int pisteet = poistaPisteet(pelilauta.getKupit().get(numero));
        Kuppi vika = viimeinen(numero, pisteet);
        jaaPisteet(numero, pisteet);
        if (erikoistilanne1(vika) == true) {
            if ((numero > 0 && numero < 7 && vika.getNumero() > 0 && vika.getNumero() < 7) || (numero > 7 && numero < 14 && vika.getNumero() > 7 && vika.getNumero() < 14)) {
                int a = poistaPisteet(vika.getVastakkainenKuppi());
                lisaaPisteetPistekuppiin((Pelikuppi) vika, a);
            }
        }



    }
    /**
     * Suorittaa tietokoneen vuorolla tapahtuvat toimitukset.
     * valitsee randomilla epätyhjän kupin numeron ja siirtää pisteitä.
     */

    public void tietokoneenVuoro() {
        Random random = new Random();
        int numero = random.nextInt(6) + 8;
        while(onkoTyhja(numero)==true){
            numero=random.nextInt(6)+8;
        }
        Kuppi vika = viimeinen(numero, pelilauta.getKupit().get(numero).getPisteet());
        kierros(numero);
        if (erikoistilanne2(vika) == true) {
            tietokoneenVuoro();
        }
    }
    /**
     * tarkistaa onko kuppi tyhjä eli ovatko sen pisteet 0.
     * jos kuppi on tyhjä palauttaa true.
     * @param numero
     * @return 
     */
    
    private boolean onkoTyhja(int numero){
        if(pelilauta.getKupit().get(numero).getPisteet()==0){
            return true;
        }
        return false;
    }

    /**
     * Jakaa valitun kupin pisteet seuraaviin.
     *
     * @param numero1 , kupin numero josta piste on alkuperäisesti otettu.
     * @param numero2 , kupin pisteet
     */
    public void jaaPisteet(int numero, int pisteet) {
        Kuppi kuppi = pelilauta.getKupit().get(numero);
        Kuppi apu = kuppi;
        if (numero > 0 && numero < 7) {
            jaaPelaajanPisteet(kuppi, apu, pisteet);
        }
        if (numero > 7 && numero < 14) {
            jaaTietokoneenPisteet(kuppi, apu, pisteet);
        } else {
        }


    }

    /**
     * Poistaa kupista pisteet ja palauttaa pisteiden määrän.
     *
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
     *
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
     *
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
     *
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
    
    /**
     * jakaa pelaaja pisteet.
     * @param kuppi
     * @param apu
     * @param pisteet 
     */

    private void jaaPelaajanPisteet(Kuppi kuppi, Kuppi apu, int pisteet) {
        for (int i = 0; i < pisteet; i++) {
            apu = apu.getSeuraavaKuppi();
            if (apu.getNumero() == 14) {
                apu = apu.getSeuraavaKuppi();
            }
            apu.lisaaPiste();
        }
    }
    /**
     * jakaa vastustajan eli tietokoneen pisteet.
     * @param kuppi
     * @param apu
     * @param pisteet 
     */

    private void jaaTietokoneenPisteet(Kuppi kuppi, Kuppi apu, int pisteet) {
        for (int i = 0; i < pisteet; i++) {
            apu = apu.getSeuraavaKuppi();
            if (apu.getNumero() == 7) {
                apu = apu.getSeuraavaKuppi();
            }
            apu.lisaaPiste();
        }
    }
    /**
     * lisää parametrina annetut pisteet kyseisen kupin pistekuppiin.
     * @param kuppi
     * @param pisteet 
     */

    private void lisaaPisteetPistekuppiin(Pelikuppi kuppi, int pisteet) {
        kuppi.getPistekuppi().lisaaPisteita(pisteet);
    }
    /**
     * tarkistaa onko peli ohi. Palauttaa true jos peli on ohi.
     * @return 
     */

    public boolean loppuikoPeli() {
        if(onkoPelaajanKupitTyhjat()==true||onkoTietokoneenKupitTyhjat()==true){
            return true;
        }

        return false;

    }
    /**
     * Tarkistaa onko pelaajan kaikki pelikupit tyhjät jos on niin palauttaa true.
     * @return 
     */

    private boolean onkoPelaajanKupitTyhjat() {
        for (int i = 1; i < 7; i++) {
            if (pelilauta.getKupit().get(i).getPisteet() != 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Tarkistaa onko tietokoneen kaikki pelikupit tyhjät.
     * @return 
     */
    
    private boolean onkoTietokoneenKupitTyhjat(){
        for (int i = 8; i < 14; i++) {
            if (pelilauta.getKupit().get(i).getPisteet() != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * siirtää jäljellä olevat pisteet sen pelaajan pistekuppin kenen kaikki pelikupit ovat tyhjiä.
     */
    
    public void siirraLoputPisteet(){
        if(onkoPelaajanKupitTyhjat()==true){
            int pisteet1=0;
            for(int i=8;i<14;i++){
                pisteet1+=poistaPisteet(pelilauta.getKupit().get(i));
            }
            lisaaPisteetPistekuppiin((Pelikuppi)pelilauta.getKupit().get(1),pisteet1);
        }else{
            int pisteet2=0;
            for(int i=1;i<7;i++){
                pisteet2+=poistaPisteet(pelilauta.getKupit().get(i));
            }
            lisaaPisteetPistekuppiin((Pelikuppi)pelilauta.getKupit().get(8),pisteet2);
        }
    }
}
