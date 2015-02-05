/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Aloitus;

import dhyppelypeli.Grafiikka.PeliPiirto;
import dhyppelypeli.Nappaimet.PeliNappaimet;
import dhyppelypeli.Oliot.Laatikko;
import dhyppelypeli.Oliot.PeliHahmo;
import dhyppelypeli.PelinTiedot.PelinTiedot;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Tommi
 */
public class Peli extends Canvas implements Runnable {

    private JFrame frame;
    private Dimension peliLauta;
    private PeliNappaimet nappaimet;
    private BufferStrategy grafiikat;
    private BufferedImage kuva;
    private PelinTiedot pelinTiedot;
    private boolean tauko;
    private PeliHahmo peliHahmo;
    private ArrayList<Laatikko> laatikot;
    private int pisteet;
    private PeliPiirto piirto;

    public Peli(PelinTiedot tiedot) {
        pisteet = 0;
        laatikot = new ArrayList<Laatikko>();
        this.pelinTiedot = tiedot;
        this.peliHahmo = tiedot.getPeliHahmo();
        this.peliHahmo.setX(10);
        this.peliHahmo.setY(pelinTiedot.getPelilaudanKorkeus() - peliHahmo.getKorkeus());
        piirto = new PeliPiirto(pelinTiedot,this);
        piirto.pelinGrafiikka();
    }

    /**
     * Metodi toteuttaa pelin kulun
     */
    @Override
    public void run() {
        while (true) {
            pisteet++;
            if (tauko == false) {
                pelinSiirrotKulku();
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

    public JFrame getPeliAlusta() {
        return frame;
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
            laatikko.setY(pelinTiedot.getPelilaudanKorkeus() - peliHahmo.getKorkeus());
            laatikko.setX(pelinTiedot.getPelilaudanLeveys() - peliHahmo.getKorkeus());
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

}
