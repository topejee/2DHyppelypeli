/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Aloitus;

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

    public Peli(PelinTiedot tiedot) {
        pisteet = 0;
        laatikot = new ArrayList<Laatikko>();
        this.pelinTiedot = tiedot;
        this.peliHahmo = tiedot.getPeliHahmo();
        this.peliHahmo.setX(10);
        this.peliHahmo.setY(pelinTiedot.getPelilaudanKorkeus() / 2);
        pelinGrafiikka();
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

    public void aloita() {
        new Thread(this).start();
    }

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

    private Graphics pelinPiirto(BufferStrategy kuvaa) {
        Graphics g = kuvaa.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.drawImage(kuva, 0, 0, pelinTiedot.getPelilaudanLeveys() + 10, pelinTiedot.getPelilaudanKorkeus() + 47, null);
        g.drawString("Uusi peli: R   Tauko: P    NAPPAIMET W,A,S,D   PISTEET "+pisteet, pelinTiedot.getPelilaudanLeveys() - 480, 10);
        peliHahmo.piirra(g);
        g.setColor(Color.red);
        piirtoLaatikot(g);
        return g;
    }

    public PelinTiedot getPelinTiedot() {
        return pelinTiedot;
    }

    private void lopeta() {
        System.exit(0);
    }

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

    public JFrame getPeliAlusta() {
        return frame;
    }

    public void liiku() {
        peliHahmo.liiku(this);
    }

    public void pelinSiirrotKulku() {
        liikeLaatikot();
        liiku();
        piirra();
    }

    public void hidastus() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Peli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void liikeLaatikot() {
        lisaaMahdollisestiLaatikko();
        for (Laatikko laatikko : laatikot) {
            laatikko.liiku(this);
        }
    }

    private void piirtoLaatikot(Graphics g) {
        g.setColor(Color.ORANGE);
        for (Laatikko laatikko : laatikot) {
            laatikko.piirra(g);
        }

    }

    public void lisaaMahdollisestiLaatikko() {
        Random x = new Random();
        int satunnainen = x.nextInt(400) + 1;
        if (satunnainen == 10) {
            Laatikko laatikko = new Laatikko();
            laatikko.setY(pelinTiedot.getPelilaudanKorkeus()- x.nextInt(pelinTiedot.getPelilaudanKorkeus()) + 1);
            laatikko.setX(pelinTiedot.getPelilaudanLeveys()- x.nextInt(pelinTiedot.getPelilaudanLeveys())/2 + 1);
            laatikot.add(laatikko);
        }
    }

}
