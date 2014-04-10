/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Krista
 */
public class Pelialusta extends JPanel {
    
    private ArrayList<JTextArea> tekstialueet = luoTekstialueita(12);
    private ArrayList<JButton> napit=luoNappeja(6);
    private int pisteet;

    public Pelialusta(int a) {
        super(new GridLayout(3,6));
        luoKomponentit();
        pisteet=a;
    }

    private void luoKomponentit() {
        
        for(int i=0;i<7;i++){
            tekstialueet.get(i).setBackground(Color.yellow);
            if(i%2==0){
                tekstialueet.get(i).setBackground(Color.ORANGE);
            if(i==6){
                tekstialueet.get(i).setBackground(Color.pink);
            }
            }
            
            add(tekstialueet.get(i));
        }
        for(int j=7;j<11;j++){
            add(tekstialueet.get(j));
        }
        tekstialueet.get(11).setBackground(Color.pink);
        add(tekstialueet.get(11));
        for(int k=0;k<6;k++){
            add(napit.get(k));
        }
        
        
    }
    
    public ArrayList<JTextArea> luoTekstialueita(int lkm){
        ArrayList<JTextArea> lista =new ArrayList<JTextArea>();
        for(int i=0; i<lkm;i++){
            
            lista.add(new JTextArea());
        }
        return lista;
    }
    
    public ArrayList<JButton> luoNappeja(int lkm){
        ArrayList<JButton> lista = new ArrayList<JButton>();
        for(int i=0;i<lkm;i++){
            JButton nappi= new JButton();
            lista.add(nappi);
            int apu1=i+1;
            String apu2="";
            apu2+=apu1;
            nappi.setActionCommand(apu2);
            nappi.addActionListener(new NapinKuuntelija(pisteet));
        }
        return lista;
    }
    
    
    
    
   
}
