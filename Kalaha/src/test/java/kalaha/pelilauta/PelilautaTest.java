/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.pelilauta;

import kalaha.pelilauta.Pelilauta;
import kalaha.pelilauta.Pelikuppi;
import kalaha.pelilauta.Kuppi;
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
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
