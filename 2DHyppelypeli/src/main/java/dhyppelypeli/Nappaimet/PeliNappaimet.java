/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Nappaimet;

import dhyppelypeli.Aloitus.Peli;
import dhyppelypeli.Grafiikka.PeliPiirto;
import dhyppelypeli.Oliot.PeliHahmo;
import dhyppelypeli.PelinTiedot.PelinTiedot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_R;
import java.awt.event.KeyListener;

/**
 *
 * @author Tommi
 */
public class PeliNappaimet implements KeyListener {

    private PeliHahmo pelaaja;
    private PelinTiedot pelinTiedot;
    private Peli peli;
    private PeliHahmo peliHahmo;
    private PeliPiirto peliPiirto;

    public PeliNappaimet(PelinTiedot pelinTiedot, Peli peli) {
        this.pelinTiedot = pelinTiedot;
        this.pelaaja = pelinTiedot.getPeliHahmo();
        peli.addKeyListener(this);
        this.peli = peli;
        this.peliHahmo = pelinTiedot.getPeliHahmo();
    }

    public PeliNappaimet(PelinTiedot pelinTiedot, PeliPiirto peli) {
        this.pelinTiedot = pelinTiedot;
        this.pelaaja = pelinTiedot.getPeliHahmo();
        this.peliPiirto = peli;
        this.peli = peliPiirto.getPeli();
        this.peliPiirto.addKeyListener(this);
        this.peliHahmo = pelinTiedot.getPeliHahmo();
    }

    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metodi laittaa olion liikkumaan tai tekee jonkun muun asian kun näppäintä
     * on painettu
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int nappain = e.getKeyCode();
        ensimmainenPelaaja(nappain);
        if (nappain == VK_P) {
            if (peli.getTauko()) {
                peli.setTaukoFalse();
            } else {
                peli.getPeliPiirto().tauko();
                peli.setTaukoTrue();
            }
        }
        if (nappain == VK_R) {
            uusiPeli();
        }
    }

    /**
     * Metodi lopettaa siirron jos näppäin ei ole enään pohjassa
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int nappain = e.getKeyCode();
        if (peliHahmo.getMaassa()) {
            if (nappain == peliHahmo.getVasenNappain()) {
                peliHahmo.setLiikuVasemmalleFalse();
            }
            if (nappain == peliHahmo.getOikeaNappain()) {
                peliHahmo.setLiikuOikealleFalse();
            }
            if (nappain == peliHahmo.getYlaNappain()) {
                peliHahmo.setLiikuYlosFalse();
            }
            if (nappain == peliHahmo.getAlaNappain()) {
                peliHahmo.setLiikuAlasFalse();
            }
        } else {
            if (nappain == peliHahmo.getVasenNappain()) {
                peliHahmo.setLiikuVasemmalleFalse();
            }
            if (nappain == peliHahmo.getOikeaNappain()) {
                peliHahmo.setLiikuOikealleFalse();
            }
        }
    }

    /**
     * Metodi aloittaa pelin uudestaan
     */
    private void uusiPeli() {
        peli.getPeliAlusta().setVisible(false);
        peli.getPeliPiirto().tauko();
        peli = null;
        Peli peli = new Peli(pelinTiedot);
        peli.aloita();
    }

    /**
     * Metodi asettaa pelattavan hahmon liikkumisen todeksi
     *
     * @param nappain
     */
    private void ensimmainenPelaaja(int nappain) {
        if (!peliHahmo.getMaassa()) {
            if (nappain == peliHahmo.getVasenNappain()) {
                peliHahmo.setLiikuVasemmalleTrue();
            }
            if (nappain == peliHahmo.getOikeaNappain()) {
                peliHahmo.setLiikuOikealleTrue();
            }
            if (nappain == peliHahmo.getYlaNappain()) {
                peliHahmo.setLiikuYlosTrue();
            }
            if (nappain == peliHahmo.getAlaNappain()) {
                peliHahmo.setLiikuAlasTrue();
            }
        } else {

            if (nappain == peliHahmo.getVasenNappain()) {
                peliHahmo.setLiikuVasemmalleTrue();
            }
            if (nappain == peliHahmo.getOikeaNappain()) {
                peliHahmo.setLiikuOikealleTrue();
            }
            if (nappain == peliHahmo.getYlaNappain()) {
                if (peliHahmo.getHyppaaTrue() == 0) {
                    peliHahmo.setHyppaaTrue();
                }
            }
        }
    }
}
