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
    public void asettaaOikeanVastakkaisenKupin1(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(13, lauta.getKupit().get(1).getVastakkainenKuppi().getNumero());
    }
    
    @Test
    public void asettaaOikeanPistekupin1(){
        Pelilauta lauta=new Pelilauta(5);
        Pelikuppi kuppi=(Pelikuppi)lauta.getKupit().get(1);
        assertEquals(7, kuppi.getPistekuppi().getNumero());
    }
    
    @Test
    public void asettaaOikeanSeuraavanKupin1(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(2, lauta.getKupit().get(1).getSeuraavaKuppi().getNumero());
    }
    
    @Test
    public void luoOikeanMaaranKuppeja(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(14,lauta.getKupit().size());
    }
    
    @Test
    public void asettaaVastakkaisetKupitPistekupeille1(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(lauta.getKupit().get(14),lauta.getKupit().get(7).getVastakkainenKuppi());
    }
    
    @Test
    public void asettaaVastakkaisetKupitPistekupeille2(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(lauta.getKupit().get(7),lauta.getKupit().get(14).getVastakkainenKuppi());
    }
    
    @Test
    public void asettaaOikeanVastakkaisenKupin2(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(1, lauta.getKupit().get(13).getVastakkainenKuppi().getNumero());
    }
    
    @Test
    public void asettaaOikeanSeuraavanKupin2(){
        Pelilauta lauta=new Pelilauta(5);
        assertEquals(1, lauta.getKupit().get(14).getSeuraavaKuppi().getNumero());
    }
    
    @Test
    public void asettaaOikeanPistekupin2(){
        Pelilauta lauta=new Pelilauta(5);
        Pelikuppi kuppi=(Pelikuppi)lauta.getKupit().get(8);
        assertEquals(14, kuppi.getPistekuppi().getNumero());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
