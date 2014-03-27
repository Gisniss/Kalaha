package kalaha.pelilogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import kalaha.pelilogiikka.Pelikuppi;
import kalaha.pelilogiikka.Pistekuppi;
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
public class PelikuppiTest {

    public PelikuppiTest() {
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
    public void pelikupinPistekuppinPisteetOikein() {
        Pelikuppi kuppi = new Pelikuppi(4, 6);
        kuppi.setPistekuppi(new Pistekuppi(7));
        assertEquals(0, kuppi.getPistekuppi().getPisteet());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
