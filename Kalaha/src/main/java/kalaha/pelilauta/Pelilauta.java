/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilauta;

import kalaha.pelilauta.Pelikuppi;
import kalaha.pelilauta.Kuppi;
import java.util.HashMap;

/**
 *
 * @author Krista
 * 
 * Luokka luo HashMapin jonne lisätään 2 pistekuppia ja 12 pelikuppia ja 
 * asetetaan mikä kuppi on minkäkin seuraava-, vastakkainen- ja pistekuppi.
 */
public class Pelilauta {

    private HashMap<Integer, Kuppi> kupit = new HashMap<Integer, Kuppi>();

    public Pelilauta(int pisteetAlussa) {
        luoKupit(pisteetAlussa);
        asetaVastakkaisetKupitPelikuppeihin();
        kupit.get(7).setVastakkainenKuppi(kupit.get(14));
        kupit.get(14).setVastakkainenKuppi(kupit.get(7));
        asetaPistekupit();
        asetaSeuraavatKupit();



    }
    
    public HashMap<Integer,Kuppi> getKupit(){
        return kupit;
    }

    private void asetaVastakkaisetKupitPelikuppeihin() {
        for (int j = 1; j < 7; j++) {
            kupit.get(j).setVastakkainenKuppi(kupit.get(14 - j));
            kupit.get(14 - j).setVastakkainenKuppi(kupit.get(j));
        }
    }

    private void asetaSeuraavatKupit() {
        for (int n = 1; n < 14; n++) {
            kupit.get(n).setSeuraavaKuppi(kupit.get(n + 1));
        }
        kupit.get(14).setSeuraavaKuppi(kupit.get(1));
    }

    private void luoKupit(int pisteetAlussa) {
        kupit.put(7, new Pistekuppi(7));
        kupit.put(14, new Pistekuppi(14));
        for (int i = 1; i < 7; i++) {
            kupit.put(i, new Pelikuppi(pisteetAlussa, i));
            kupit.put(14 - i, new Pelikuppi(pisteetAlussa, 14 - i));
        }
    }

    private void asetaPistekupit() {
        for (int k = 1; k < 7; k++) {
            Pelikuppi kuppi = (Pelikuppi) kupit.get(k);
            kuppi.setPistekuppi((Pistekuppi) kupit.get(7));
            kuppi = (Pelikuppi) kupit.get(14 - k);
            kuppi.setPistekuppi((Pistekuppi) kupit.get(14));
        }
    }

    
}
