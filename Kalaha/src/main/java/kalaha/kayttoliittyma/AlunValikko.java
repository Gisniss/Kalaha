/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Krista
 */
public class AlunValikko extends JPanel {
    
    public AlunValikko(){
        super(new GridLayout(1,3));
        luoKomponentit();
    }
    
    private void luoKomponentit(){
        add(new JButton("4 pistettä"));
        add(new JButton("6 pistettä"));
        add(new JButton("8 pistettä"));
    }
}
