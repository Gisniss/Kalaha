/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilogiikka;

import kalaha.pelilauta.Kuppi;
import kalaha.pelilauta.Pelilauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krista
 */
public class PeliTest {
    
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void poistaaPisteet(){
        Peli peli=new Peli(5);
        peli.poistaPisteet(peli.getPelilauta().getKupit().get(1));
        assertEquals(0, peli.getPelilauta().getKupit().get(1).getPisteet());
    }
    
    @Test
    public void poistaPisteetPalauttaaOikeanMaaranPisteita(){
        Peli peli=new Peli(5);
        int apu=peli.poistaPisteet(peli.getPelilauta().getKupit().get(1));
        assertEquals(5, apu);
    }
    
    @Test
    public void palauttaaOikeinErikoistilanne2(){
        Peli peli=new Peli(5);
        assertEquals(true, peli.erikoistilanne2(peli.getPelilauta().getKupit().get(7)));
    }
    
    
    
    @Test
    public void viimeinenPalauttaaOikein(){
        Peli peli= new Peli(5);
       
        assertEquals(peli.getPelilauta().getKupit().get(5), peli.viimeinen(2, 3));
    }
    
    @Test
    public void kierrosJakaaPisteet(){
        Peli peli= new Peli(5);
        peli.kierros(5);
        assertEquals(6,peli.getPelilauta().getKupit().get(6).getPisteet());
        
        
    }
    
    @Test
    public void tietokoneenVuoroJakaaPisteet(){
        Peli peli= new Peli(5);
        peli.tietokoneenVuoro();
        assertEquals(6,peli.getPelilauta().getKupit().get(13).getPisteet());
    }
    
    @Test
    public void jaaPisteetJakaaPisteet(){
        Peli peli=new Peli(5);
        peli.jaaPisteet(5, 13);
        assertEquals(6,peli.getPelilauta().getKupit().get(5).getPisteet());
    }
    
    @Test
    public void erikoistilanne1Toimii(){
        Peli peli=new Peli(5);
        peli.jaaPisteet(5, 13);
        assertEquals(false,peli.erikoistilanne1(peli.getPelilauta().getKupit().get(5)));
    }
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
