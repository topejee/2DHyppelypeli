/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
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
public class HahmoTest {

    private Hahmo hahmo;

    public HahmoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hahmo = new Hahmo();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lisaantuukoHahmonXarvo() {
        hahmo.setX(10);
        assertEquals(10, hahmo.getX());
    }

    @Test
    public void lisaantuukoHahmonYarvo() {
        hahmo.setY(10);
        assertEquals(10, hahmo.getY());
    }

    @Test
    public void lisaantuukoHahmonLeveysarvo() {
        hahmo.setLeveys(10);
        assertEquals(10, hahmo.getLeveys());
    }

    @Test
    public void lisaantuukoHahmonKorkeusarvo() {
        hahmo.setKorkeus(10);
        assertEquals(10, hahmo.getKorkeus());
    }

    @Test
    public void meneekoLeveysAlleNollan() {
        hahmo.setLeveys(-10);
        assertEquals(0, hahmo.getLeveys());
    }

    @Test
    public void meneekoKorkeusAlleNollan() {
        hahmo.setKorkeus(-10);
        assertEquals(0, hahmo.getKorkeus());
    }

    @Test
    public void kasvaakoXyhdella() {
        hahmo.kasvataX();
        assertEquals(1, hahmo.getX());
    }

    @Test
    public void kasvaakoYyhdella() {
        hahmo.kasvataY();
        assertEquals(1, hahmo.getY());
    }

}
