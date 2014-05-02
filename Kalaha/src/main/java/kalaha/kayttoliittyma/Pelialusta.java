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
import kalaha.pelilogiikka.Peli;

/**
 *
 * @author Krista
 */
public class Pelialusta extends JPanel {

    private ArrayList<JTextArea> tekstialueet;
    private ArrayList<JButton> napit;
    
    private Peli peli;
    private JTextArea tekstikentta;

    public Pelialusta( Peli b, JTextArea c) {
        
        super(new GridLayout(3, 6));
        tekstikentta=c;
        peli = b;
        napit=  luoNappeja(6);
        tekstialueet = luoTekstialueita(12);
        luoKomponentit();
        

    }

    private void luoKomponentit() {

        for (int i = 0; i < 7; i++) {
            tekstialueet.get(i).setBackground(Color.yellow);
            if (i % 2 == 0) {
                tekstialueet.get(i).setBackground(Color.ORANGE);
                if (i == 6) {
                    tekstialueet.get(i).setBackground(Color.pink);
                }
            }

            add(tekstialueet.get(i));
        }
        for (int j = 7; j < 11; j++) {
            add(tekstialueet.get(j));
        }
        tekstialueet.get(11).setBackground(Color.pink);
        add(tekstialueet.get(11));
        for (int k = 0; k < 6; k++) {
            add(napit.get(k));
        }


        asetaPisteetKuppeihin();


    }

    private ArrayList<JTextArea> luoTekstialueita(int lkm) {
        ArrayList<JTextArea> lista = new ArrayList<JTextArea>();
        for (int i = 0; i < lkm; i++) {
            JTextArea alue=new JTextArea();
            alue.setEditable(false);

            lista.add(alue);
        }
        return lista;
    }

    private ArrayList<JButton> luoNappeja(int lkm) {
        ArrayList<JButton> lista = new ArrayList<JButton>();
        for (int i = 0; i < lkm; i++) {
            JButton nappi = new JButton();
            lista.add(nappi);
            int apu1 = i + 1;
            String apu2 = "";
            apu2 += apu1;
            nappi.setActionCommand(apu2);
            nappi.addActionListener(new NapinKuuntelija(peli, this));
        }
        return lista;
    }

    private void asetaPisteetKuppeihin() {
        for (int i = 0; i < 6; i++) {
            String apu="";
            apu+=peli.getPelilauta().getKupit().get(13-i).getPisteet();
            tekstialueet.get(i).setText(apu);
            String apu2="";
            apu2+=peli.getPelilauta().getKupit().get(i+1).getPisteet();
            napit.get(i).setText(apu2);
        }
        String a="";
        a+=peli.getPelilauta().getKupit().get(14).getPisteet();
        tekstialueet.get(6).setText(a);
        String b="";
        b+=peli.getPelilauta().getKupit().get(7).getPisteet();
        tekstialueet.get(11).setText(b);
        
    }

    public void paivita() {
        asetaPisteetKuppeihin();
        
        revalidate();
        repaint();
        
        
        
    }
    
    public JTextArea getTekstikentta(){
        return tekstikentta;
    }
    
    
    
}
