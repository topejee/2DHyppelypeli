/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Aloitus;

import dhyppelypeli.Grafiikka.PeliPiirto;

import dhyppelypeli.Oliot.Laatikko;
import dhyppelypeli.Oliot.PeliHahmo;
import dhyppelypeli.PelinTiedot.PelinTiedot;
import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tommi
 */
public class Peli extends Canvas implements Runnable {

    private PelinTiedot pelinTiedot;
    private boolean tauko;
    private PeliHahmo peliHahmo;
    private ArrayList<Laatikko> laatikot;
    private int pisteet;
    private PeliPiirto piirto;
    private int laatikoidenNopeus;
    public boolean maassa;

    public Peli(PelinTiedot tiedot) {
        pisteet = 0;
        laatikoidenNopeus = 5;
        laatikot = new ArrayList<Laatikko>();
        this.pelinTiedot = tiedot;
        this.peliHahmo = tiedot.getPeliHahmo();
        this.peliHahmo.setX(10);
        this.peliHahmo.setY(pelinTiedot.getPelilaudanKorkeus() - peliHahmo.getKorkeus());
        piirto = new PeliPiirto(pelinTiedot, this);
        piirto.pelinGrafiikka();
        maassa = true;
    }

    /**
     * Metodi toteuttaa pelin kulun
     */
    @Override
    public void run() {
        while (true) {
            pisteet++;
            piirto.setPisteet(pisteet);
            if (tauko == false) {
                pelinSiirrotKulku();
            }
            if (pisteet % 100 == 0) {
                laatikoidenNopeus++;
            }
            if (pisteet >= 100) {
                getPeliHahmo().setMaassa(false);
                maassa = false;
            }
            hidastus();
        }
    }

    /**
     * Metodi aloittaa pelin
     */
    public void aloita() {
        new Thread(this).start();
    }

    public PelinTiedot getPelinTiedot() {
        return pelinTiedot;
    }

    /**
     * Metodi lopettaa pelin
     */
    private void lopeta() {
        System.exit(0);
    }

    /**
     * Metodi liikuttaa peli hahmoja
     */
    public void pelinSiirrotKulku() {
        liikeLaatikot();
        peliHahmo.liiku(this);
        piirto.piirra();
    }

    /**
     * Metodi hidastaa pelin kulkua
     */
    public void hidastus() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Peli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodi liikuttaa laatikkoja
     */
    public void liikeLaatikot() {
        lisaaMahdollisestiLaatikko();
        for (Laatikko laatikko : laatikot) {
            laatikko.liiku(this);

        }
    }

    /**
     * Metodi lisaa mahdollisesti uuden laatikon
     */
    public void lisaaMahdollisestiLaatikko() {
        Random x = new Random();
        int satunnainen = x.nextInt(80) + 1;
        if (satunnainen == 10) {
            Laatikko laatikko = new Laatikko();
            laatikko.setX(pelinTiedot.getPelilaudanLeveys() - peliHahmo.getKorkeus());
            if (maassa) {
                laatikko.setY(pelinTiedot.getPelilaudanKorkeus() - peliHahmo.getKorkeus());
            } else {
                satunnainen = x.nextInt(pelinTiedot.getPelilaudanKorkeus()) + 1;
                laatikko.setY(pelinTiedot.getPelilaudanKorkeus() - satunnainen);
            }
            laatikko.setLiikkumisNopeus(laatikoidenNopeus);
            laatikot.add(laatikko);
            piirto.LisaaLaatikot(laatikot);
        }
    }

    public PeliHahmo getPeliHahmo() {
        return peliHahmo;
    }

    public PeliPiirto getPeliPiirto() {
        return piirto;
    }

    public void setTaukoTrue() {
        tauko = true;
    }

    public void setTaukoFalse() {
        tauko = false;
    }

    public boolean getTauko() {
        return tauko;
    }

    public int getPisteet() {
        return pisteet;
    }

}
