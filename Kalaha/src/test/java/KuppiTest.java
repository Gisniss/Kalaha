/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import kalaha.kalaha.Kuppi;
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
public class KuppiTest {
    
    public KuppiTest() {
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
    public void kuppiAntaaOikeanPistemaaran(){
        Kuppi kuppi= new Kuppi(5);
        int vastaus=kuppi.getPisteet();
        assertEquals(5,vastaus);
    }
    
    @Test
    public void kuppiLisaaPisteita(){
        Kuppi kuppi= new Kuppi(2);
        kuppi.lisaaPiste();
        kuppi.lisaaPiste();
        assertEquals(4,kuppi.getPisteet());
    }
    
    @Test
    public void kuppiPoistaaPisteet(){
        Kuppi kuppi=new Kuppi(3);
        kuppi.poistaPisteet();
        assertEquals(0,kuppi.getPisteet());
    }
        
        
        
        
        // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
