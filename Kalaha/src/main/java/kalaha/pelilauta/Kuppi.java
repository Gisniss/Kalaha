/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilauta;

/**
 *
 * @author Krista
 * 
 * Luokka asettaa kupille pisteet, numeron, vastakkaisen- ja seuraavan kupin.
 */
public class Kuppi {

    private int pisteet;
    private int kupinNumero;
    private Kuppi vastakkainenKuppi;
    private Kuppi seuraavaKuppi;

    
    public Kuppi(int pisteetAlussa, int numero) {
        pisteet = pisteetAlussa;
        kupinNumero = numero;

    }

    public void setVastakkainenKuppi(Kuppi kuppi) {
        vastakkainenKuppi = kuppi;
    }

    public void setSeuraavaKuppi(Kuppi kuppi) {
        seuraavaKuppi = kuppi;
    }

    public int getPisteet() {
        return pisteet;
    }
    
    /**
     * Lisää kuppiin pisteen.
     */

    public void lisaaPiste() {
        pisteet = pisteet + 1;
    }
    
    /**
     * Poistaa kupista kaikki pisteet.
     */

    public void poistaPisteet() {
        pisteet = 0;
    }

    public int getNumero() {
        return kupinNumero;
    }

    public Kuppi getVastakkainenKuppi() {
        return vastakkainenKuppi;
    }

    public Kuppi getSeuraavaKuppi() {
        return seuraavaKuppi;
    }
}
