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
public class LaatikkoTest {

    private Laatikko laatikko;

    public LaatikkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        laatikko = new Laatikko();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoLaatikonLeveysOikea() {
        assertEquals(40, laatikko.getLeveys());
    }

    @Test
    public void onkoLaatikonKorkeusOikea() {
        assertEquals(40, laatikko.getKorkeus());
    }

}
