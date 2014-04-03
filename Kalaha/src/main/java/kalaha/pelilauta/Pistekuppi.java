/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilauta;

import kalaha.pelilauta.Kuppi;

/**
 *
 * @author Krista
 * 
 * Luokka asettaa pistekupille numeron.
 */
public class Pistekuppi extends Kuppi {

    public Pistekuppi(int numero) {
        super(0, numero);
    }

    public void lisaaPisteita(int maara) {
        if (maara <= 0) {
        } else {
            for (int i = 1; i <= maara; i++) {
                lisaaPiste();
            }
        }
    }
}
