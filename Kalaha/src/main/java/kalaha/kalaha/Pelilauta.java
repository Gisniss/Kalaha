/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kalaha;

import java.util.HashMap;

/**
 *
 * @author Krista
 */
public class Pelilauta {

    private HashMap<Integer, Kuppi> kupit = new HashMap<Integer,Kuppi>();

    public Pelilauta(int pisteetAlussa) {
        for(int i=1;i<=6;i++){
            kupit.put(i, new Pelikuppi(pisteetAlussa));
        }
        kupit.put(7, new Pistekuppi());
        for(int j=8;j<=13;j++){
            kupit.put(j, new Pelikuppi(pisteetAlussa));
        }
        kupit.put(14, new Pistekuppi());
    }
}
