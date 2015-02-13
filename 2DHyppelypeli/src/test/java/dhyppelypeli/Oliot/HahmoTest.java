/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import dhyppelypeli.PelinTiedot.PelinTiedot;
import java.awt.Graphics;
import java.awt.Rectangle;
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

    @Test
    public void onkoHahmoOikea() {
        Rectangle x = new Rectangle();
        x = hahmo.getHahmo();
        assertEquals(x, hahmo.getHahmo());
    }
    @Test
    public void liikkumisenXjaYarvo(){
        hahmo.liiku(new Peli(new PelinTiedot()));
        System.out.println("asdas" + hahmo.getHahmo().getBounds());
      //  assertArrayEquals(java.awt.Rectangle[x=0,y=0,width=0,height=0], hahmo.getHahmo().getBounds());
    }

}
