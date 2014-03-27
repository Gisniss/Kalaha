/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilogiikka;

/**
 *
 * @author Krista
 */
public class Pelikuppi extends Kuppi {
    
    private Pistekuppi pistekuppi;

    public Pelikuppi(int pisteetAlussa, int numero) {
        super(pisteetAlussa, numero);
        
    }
    
    public void setPistekuppi(Pistekuppi kuppi){
        pistekuppi=kuppi;
    }
    
    public Pistekuppi getPistekuppi(){
        return pistekuppi;
    }
    
   
        
    
}
