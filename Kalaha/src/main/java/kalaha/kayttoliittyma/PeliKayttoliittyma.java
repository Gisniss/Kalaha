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
import kalaha.pelilogiikka.Peli;

/**
 *
 * @author Krista
 * 
 * Luokka luo ikkunan jossa peli pelataan ja luo Pelialustan.
 */
public class PeliKayttoliittyma implements Runnable{
    
    private JFrame frame;
    private int pisteet;
    private Peli peli;
    private JTextArea teksti;
    
    
    public PeliKayttoliittyma(int pisteetAlussa){
        pisteet=pisteetAlussa;
        peli= new Peli(pisteet);
        teksti= new JTextArea();
        
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
       teksti.setEditable(false);
       teksti.setLineWrap(true);
       teksti.setText("Pelilaudassa on kaksitoista kuppia asetettuna kahteen riviin sekä kupit laudan päissä."
               + " Kuusi alimmaista kuppia ovat sinun pelikuppejasi ja     oikealla puolella oleva kuppi on sinun pistekuppisi."
               + "Pelin tavoitteena on kerätä omaan pistekuppiin enemmän pisteitä kuin vastustaja               omaansa. "
               + "Valitse kuppi josta haluat siirtää pisteitä ja pisteet siirtyvät vastapäivään seuraaviin kuppeihin, "
               + "yksi piste kuhunkin kuppiin niin kauan kun pisteitä riittää. Myös omaan pistekuppiin laitetaan piste "
               + "mutta ei vastustajan pistekuppiin.Jos viimeinen laitettu piste osuu omaan                pistekuppiin, saat uuden vuoron. "
               + "Jos taas viimeinen piste osuu omanpuolen ennestään tyhjään kuppiin, saat "
               + "kaikki pisteet kupin laudan             vastakkaisella puolella olevasta kupista. Saadut pisteet menevät saajan "
               + "pistekuppiin.Peli päättyy, kun pisteet loppuvat pelikupeista "
               + "jaossa       olevista pisteistä. Voittaja on se, jolla on eniten pisteitä pistekupissaan pelin päätyttyä.");
       container.add(teksti);
       
       Pelialusta alusta = new Pelialusta(peli, teksti );
       container.add(alusta);
       
    }
    
    
    
    public JFrame getFrame(){
        return frame;
    }
}
