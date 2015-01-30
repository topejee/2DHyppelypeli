/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tommi
 */
public class PeliHahmoTest {
    private PeliHahmo pelihahmo;
    
    public PeliHahmoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelihahmo = new PeliHahmo();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void onkoYlaNappainTrue() {
        pelihahmo.setLiikuYlosTrue();
        assertEquals(true, pelihahmo.getLiikuYlos());
    }
       @Test
    public void onkoAlaNappainTrue() {
        pelihahmo.setLiikuAlasTrue();
        assertEquals(true, pelihahmo.getLiikuAlas());
    }
       @Test
    public void onkoVasenNappainTrue() {
        pelihahmo.setLiikuVasemmalleTrue();
        assertEquals(true, pelihahmo.getLiikuVasemmalle());
    }
       @Test
    public void onkoYlaOikealleTrue() {
        pelihahmo.setLiikuOikealleTrue();
        assertEquals(true, pelihahmo.getLiikuOikealle());
    }
       @Test
    public void onkoYlaNappainFalse() {
        pelihahmo.setLiikuYlosFalse();
        assertEquals(false, pelihahmo.getLiikuYlos());
    }
      @Test
    public void onkoAlaNappainFalse() {
        pelihahmo.setLiikuAlasFalse();
        assertEquals(false, pelihahmo.getLiikuAlas());
    }
      @Test
    public void onkoVasenNappainFalse() {
        pelihahmo.setLiikuVasemmalleFalse();
        assertEquals(false, pelihahmo.getLiikuVasemmalle());
    }
      @Test
    public void onkoOikealleNappainFalse() {
        pelihahmo.setLiikuOikealleFalse();
        assertEquals(false, pelihahmo.getLiikuOikealle());
    }
}
