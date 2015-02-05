/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Grafiikka;

import dhyppelypeli.Aloitus.Peli;
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
public class PeliPiirto extends Canvas {

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
    private Peli peli;

    public PeliPiirto(PelinTiedot tiedot, Peli peli) {
        this.peli = peli;
        this.pelinTiedot = tiedot;
        pisteet = 0;
        laatikot = new ArrayList<Laatikko>();
        this.pelinTiedot = tiedot;
        this.peliHahmo = tiedot.getPeliHahmo();
        this.peliHahmo.setX(10);
        this.peliHahmo.setY(pelinTiedot.getPelilaudanKorkeus() - peliHahmo.getKorkeus());
        this.tauko = true;
    }

    public void pelinGrafiikka() {
        frame = new JFrame();
        peliLauta = new Dimension(pelinTiedot.getPelilaudanLeveys() + 10, pelinTiedot.getPelilaudanKorkeus() + 20);
        frame.setAutoRequestFocus(true);
        frame.setMinimumSize(peliLauta);
        frame.setPreferredSize(peliLauta);
        frame.setMaximumSize(peliLauta);
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setTitle("2D hyppely peli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        nappaimet = new PeliNappaimet(pelinTiedot, this);
        kuva = new BufferedImage(pelinTiedot.getPelilaudanLeveys() + 50, pelinTiedot.getPelilaudanKorkeus() + 40, BufferedImage.TYPE_INT_RGB);
        this.requestFocus();
    }

    /**
     * Metodi piirtää pelin
     *
     * @param kuvaa
     * @return
     */
    private Graphics pelinPiirto(BufferStrategy kuvaa) {
        Graphics g = kuvaa.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.drawImage(kuva, 0, 0, pelinTiedot.getPelilaudanLeveys() + 10, pelinTiedot.getPelilaudanKorkeus() + 47, null);
        g.drawString("Uusi peli: R   Tauko: P    NAPPAIMET W,A,S,D   PISTEET " + pisteet + "  ELÄMÄT " + peliHahmo.getElamat() + "/3", pelinTiedot.getPelilaudanLeveys() - 480, 10);
        peliHahmo.getPeliHahmoPiirto().piirra(g);
        g.setColor(Color.red);
        piirtoLaatikot(g);
        return g;
    }

    /**
     * Metodi piirtää laatikot
     *
     * @param g
     */
    private void piirtoLaatikot(Graphics g) {

        g.setColor(Color.ORANGE);
        for (Laatikko laatikko : laatikot) {
            laatikko.getLaatikkoPiirto().piirra(g);
        }
    }

    /**
     * *
     * Metodi tekee uuden kuvan
     */
    public void piirra() {
        BufferStrategy kuvaa = getBufferStrategy();
        if (kuvaa == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = pelinPiirto(kuvaa);
        g.dispose();
        kuvaa.show();
    }

    /**
     * Metodi pysäyttää pelin
     */
    public void tauko() {
        if (tauko) {
            tauko = false;
        } else {
            tauko = true;
            BufferStrategy kuvaa = getBufferStrategy();
            if (kuvaa == null) {
                createBufferStrategy(3);
                return;
            }
            Graphics g = pelinPiirto(kuvaa);
            g.setColor(Color.WHITE);
            g.setFont(new Font("timesRoman", Font.ITALIC, 50));
            g.drawString("TAUKO", 300, 300);
            g.dispose();
            kuvaa.show();
        }
    }

    /**
     * Metodi laittaa laatikoiden arvoksi peli logiikassa olevat laatikot
     *
     * @param laatikot pelissä olevat laatikot
     */
    public void LisaaLaatikot(ArrayList<Laatikko> laatikot) {
        this.laatikot = laatikot;
    }
    public Peli getPeli(){
        return peli;
    }
}
