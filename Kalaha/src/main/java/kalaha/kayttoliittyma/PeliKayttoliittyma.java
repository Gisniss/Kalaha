/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Krista
 * 
 * Luokka luo ikkunan jossa peli pelataan.
 */
public class PeliKayttoliittyma implements Runnable{
    
    private JFrame frame;
    
    public PeliKayttoliittyma(){
        
    }
    
    @Override
    public void run(){
        frame = new JFrame("Kalaha");
        frame.setPreferredSize(new Dimension(800,500));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container){
       
        container.add(new JLabel("Kuinka monta pistettä aluksi?"), BorderLayout.CENTER);
        container.add(new AlunValikko(), BorderLayout.SOUTH);
        container.add(new Piirtoalusta());
        
        
        
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
