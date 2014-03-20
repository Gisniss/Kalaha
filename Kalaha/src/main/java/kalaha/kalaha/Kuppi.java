/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kalaha;

/**
 *
 * @author Krista
 */
public class Kuppi {

    private int pisteet;

    public Kuppi(int pisteetAlussa) {
        pisteet = pisteetAlussa;
    }

    public int getPisteet() {
        return pisteet;
    }
    
    public void lisaaPiste(){
        pisteet=pisteet+1;
    }
    
    public void poistaPisteet(){
        pisteet=0;
    }
}
