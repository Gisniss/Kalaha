/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha;

import java.util.Scanner;
import kalaha.pelilogiikka.Pelilauta;

/**
 *
 * @author Krista
 */
public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Aloitetaan peli");
        System.out.println("valitse pisteiden määrä alussa per kuppi: ");
        int pisteita = lukija.nextInt();

        Pelilauta pelilauta = new Pelilauta(pisteita);
        int luku = 1;
        while (luku > 0) {
            System.out.println("Valitse luku 1-6");
            luku = lukija.nextInt();
            pelilauta.valitseKuppi(luku);
        }
    }
}
