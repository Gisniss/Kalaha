/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Krista
 * 
 * Luokka luo ikkunan josta peli aloitetaan.
 */
public class AlkuKayttoliittyma implements Runnable{
    
    private JFrame frame;
    
    public AlkuKayttoliittyma(){
        
    }
    @Override
    public void run(){
        frame = new JFrame("Kalaha");
        frame.setPreferredSize(new Dimension(400,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        JTextArea teksti= new JTextArea("Tervetuloa pelaamaan Kalahaa!\n Valitse kuinka monta pistettä on alussa per kuppi.");
        container.add(teksti);
        container.add(new AlunValikko());
        
        
        
        
    }
    
    public JFrame getFrame(){
        return frame;}
}
