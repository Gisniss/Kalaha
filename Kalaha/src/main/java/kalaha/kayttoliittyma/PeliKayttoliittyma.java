/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Krista
 * 
 * Luokka luo ikkunan jossa peli pelataan.
 */
public class PeliKayttoliittyma implements Runnable{
    
    private JFrame frame;
    private int pisteet;
    
    public PeliKayttoliittyma(int pisteetAlussa){
        pisteet=pisteetAlussa;
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
       GridLayout layout = new GridLayout(2,1);
       container.setLayout(layout);
       JTextArea teksti= new JTextArea();
       container.add(teksti);
       Pelialusta alusta = new Pelialusta(pisteet);
       container.add(alusta);
       
        
        
        
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
