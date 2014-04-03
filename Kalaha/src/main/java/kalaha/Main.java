/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import kalaha.kayttoliittyma.AlkuKayttoliittyma;
import kalaha.kayttoliittyma.PeliKayttoliittyma;
import kalaha.pelilauta.Pelilauta;

/**
 *
 * @author Krista
 * 
 * Luokka käynnistää pelin.
 */
public class Main {

    public static void main(String[] args) {
        AlkuKayttoliittyma kayttoliittyma =new AlkuKayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
