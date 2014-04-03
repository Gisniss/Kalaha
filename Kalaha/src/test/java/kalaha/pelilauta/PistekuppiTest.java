package kalaha.pelilauta;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import kalaha.pelilauta.Pistekuppi;
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
public class PistekuppiTest {

    public PistekuppiTest() {
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
    public void pistekuppiLisaaPisteita() {
        Pistekuppi kuppi = new Pistekuppi(7);
        kuppi.lisaaPisteita(3);
        assertEquals(3, kuppi.getPisteet());
    }

    @Test
    public void eiLisaaPisteitaJosLisattavaMaaraOnNegatiivinen() {
        Pistekuppi kuppi = new Pistekuppi(7);
        kuppi.lisaaPisteita(-2);
        assertEquals(0, kuppi.getPisteet());
    }
    
    @Test
    public void eiLisaaPisteitaJosLisattavaOnNolla(){
        Pistekuppi kuppi=new Pistekuppi(7);
        kuppi.lisaaPisteita(0);
        assertEquals(0, kuppi.getPisteet());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
