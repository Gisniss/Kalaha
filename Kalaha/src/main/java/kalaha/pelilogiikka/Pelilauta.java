/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilogiikka;

import java.util.HashMap;

/**
 *
 * @author Krista
 */
public class Pelilauta {

    private HashMap<Integer, Kuppi> kupit = new HashMap<Integer, Kuppi>();

    public Pelilauta(int pisteetAlussa) {
        kupit.put(7, new Pistekuppi(7));
        kupit.put(14, new Pistekuppi(14));
        for (int i = 1; i < 7; i++) {
            kupit.put(i, new Pelikuppi(pisteetAlussa, i));
            kupit.put(14 - i, new Pelikuppi(pisteetAlussa, 14 - i));
        }
        for (int j = 1; j < 7; j++) {
            kupit.get(j).setVastakkainenKuppi(kupit.get(14 - j));
            kupit.get(14 - j).setVastakkainenKuppi(kupit.get(j));
        }
        kupit.get(7).setVastakkainenKuppi(kupit.get(14));
        kupit.get(14).setVastakkainenKuppi(kupit.get(7));
        for (int k = 1; k < 7; k++) {
            Pelikuppi kuppi = (Pelikuppi) kupit.get(k);
            kuppi.setPistekuppi((Pistekuppi) kupit.get(7));
            kuppi = (Pelikuppi) kupit.get(14 - k);
            kuppi.setPistekuppi((Pistekuppi) kupit.get(14));
        }
        for (int n = 1; n < 14; n++) {
            kupit.get(n).setSeuraavaKuppi(kupit.get(n + 1));
        }
        kupit.get(14).setSeuraavaKuppi(kupit.get(1));



    }
    
    public HashMap<Integer,Kuppi> getKupit(){
        return kupit;
    }

    public void valitseKuppi(int numero) {
        Kuppi kuppi = kupit.get(numero);
        int pisteet = poistaPisteet(kuppi);
        Kuppi viimeisin = jaaPisteet(numero, pisteet);
        erikoistilanne1(viimeisin.getNumero());


    }

    public int poistaPisteet(Kuppi kuppi) {
        int pisteet = kuppi.getPisteet();
        kuppi.poistaPisteet();
        return pisteet;
    }

    public Kuppi jaaPisteet(int numero, int pisteet) {
        Kuppi kuppi = kupit.get(numero).getSeuraavaKuppi();
        Kuppi viimeisin = kuppi;
        for (int i = pisteet; i > 0; i--) {
            if (numero < 7 && kuppi.getNumero() == 14) {
                kuppi = kuppi.getSeuraavaKuppi();
            }
            if (numero > 7 && kuppi.getNumero() == 7) {
                kuppi = kuppi.getSeuraavaKuppi();
            }
            kuppi.lisaaPiste();
            viimeisin = kuppi;
            kuppi = kuppi.getSeuraavaKuppi();
        }
        return viimeisin;




    }

    public void erikoistilanne1(int numero) {
        if (kupit.get(numero).getPisteet() == 1 && kupit.get(numero).getClass() == Pelikuppi.class) {
            Kuppi vastakkainenKuppi = kupit.get(numero).getVastakkainenKuppi();
            int pisteet = poistaPisteet(vastakkainenKuppi);
            Pelikuppi kuppi = (Pelikuppi) kupit.get(numero);
            kuppi.getPistekuppi().lisaaPisteita(pisteet);
        } else {
        }
    }

    public boolean erikoistilanne2(int numero) {
        if (kupit.get(numero).getClass() == Pistekuppi.class) {
            return true;
        } else {
            return false;
        }
    }
}
