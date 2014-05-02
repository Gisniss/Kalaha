/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Krista
 */
public class ValikonKuuntelija implements ActionListener {
    
   

    public ValikonKuuntelija() {
        
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        int pisteet = Integer.parseInt(a.getActionCommand());
        
        PeliKayttoliittyma kayttoliittyma = new PeliKayttoliittyma(pisteet);
        SwingUtilities.invokeLater(kayttoliittyma);
        
        

    }
}
