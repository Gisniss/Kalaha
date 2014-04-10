/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kalaha.pelilauta.Pelilauta;
import kalaha.pelilogiikka.Peli;

/**
 *
 * @author Krista
 */
public class NapinKuuntelija implements ActionListener{
    
    private Peli peli;
    
    public NapinKuuntelija(int a){
        peli= new Peli(a);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        int nappi = Integer.parseInt(a.getActionCommand());
        if(peli.getPelilauta().getKupit().get(nappi).getPisteet()==0){
            
        }
        peli.askel(nappi, peli.viimeinen(nappi,peli.getPelilauta().getKupit().get(nappi).getPisteet() ).getNumero());
        
        
    }
    
}
