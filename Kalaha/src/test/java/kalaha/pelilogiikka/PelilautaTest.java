/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilogiikka;

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
public class PelilautaTest {

    public PelilautaTest() {
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
    public void asettaaOikeanVastakkaisenKupin(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(13, lauta.getKupit().get(1).getVastakkainenKuppi().getNumero());
    }
    
    @Test
    public void asettaaOikeanPistekupin(){
        Pelilauta lauta=new Pelilauta(5);
        Pelikuppi kuppi=(Pelikuppi)lauta.getKupit().get(1);
        assertEquals(7, kuppi.getPistekuppi().getNumero());
    }
    
    @Test
    public void asettaaOikeanSeuraavanKupin(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(2, lauta.getKupit().get(1).getSeuraavaKuppi().getNumero());
    }
    
    @Test
    public void luoOikeanMaaranKuppeja(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(14,lauta.getKupit().size());
    }
    
    @Test
    public void poistaaPisteet(){
        Pelilauta lauta=new Pelilauta(5);
        lauta.poistaPisteet(lauta.getKupit().get(1));
        assertEquals(0, lauta.getKupit().get(1).getPisteet());
    }
    
    @Test
    public void poistaPisteetPalauttaaOikeanMaaranPisteita(){
        Pelilauta lauta=new Pelilauta(5);
        int apu=lauta.poistaPisteet(lauta.getKupit().get(1));
        assertEquals(5, apu);
    }
    
    @Test
    public void palauttaaOikeinErikoistilanne2(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(true, lauta.erikoistilanne2(lauta.getKupit().get(7).getNumero()));
    }
    
    @Test
    public void jaaPisteetPalauttaaOikeanKupin(){
        Pelilauta lauta=new Pelilauta(5);
        Kuppi kuppi=lauta.jaaPisteet(1, 4);
        assertEquals(5,kuppi.getNumero());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
