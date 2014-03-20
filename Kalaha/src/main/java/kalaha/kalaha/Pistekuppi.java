/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kalaha;

/**
 *
 * @author Krista
 */
public class Pistekuppi extends Kuppi {

    

    public Pistekuppi() {
        super(0);
    }
    
    public void lisaaPisteita(int maara){
        for(int i=1;i<=maara;i++){
            lisaaPiste();
        }
    }
}
