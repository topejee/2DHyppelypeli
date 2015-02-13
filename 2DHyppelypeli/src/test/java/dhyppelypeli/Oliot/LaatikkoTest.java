/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import dhyppelypeli.PelinTiedot.PelinTiedot;
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

    @Test
    public void toimiikoLiikeOikeinX() {
        int a = laatikko.getX();
        laatikko.liiku(new Peli(new PelinTiedot()));
        assertEquals(laatikko.getX(), a);
    }

    @Test
    public void liikkumisNopeus() {
        assertEquals(0, laatikko.getLiikkumisNopeus());
    }

    @Test
    public void liikkumisNopeusVaihto() {
        laatikko.setLiikkumisNopeus(10);
        assertEquals(10, laatikko.getLiikkumisNopeus());
    }

    @Test
    public void peliHahmoElamatVahennusTormaus() {
        Peli peli = new Peli(new PelinTiedot());
        PeliHahmo hahmo = peli.getPeliHahmo();
        hahmo.setX(laatikko.getX() - 45);
        laatikko.tormaustestiPeliHahmo(peli);
        assertEquals(3, hahmo.getElamat());
    }

    @Test
    public void peliHahmoTormaus() {
        Peli peli = new Peli(new PelinTiedot());
        PeliHahmo hahmo = peli.getPeliHahmo();
        hahmo.setX(laatikko.getX() - 25);
        laatikko.tormaustestiPeliHahmo(peli);
        assertEquals(550, hahmo.getY());
    }

}
