/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Nappaimet;

import dhyppelypeli.Aloitus.Peli;
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

    public PeliNappaimet(PelinTiedot pelinTiedot, Peli peli) {
        this.pelinTiedot = pelinTiedot;
        this.pelaaja = pelinTiedot.getPeliHahmo();
        peli.addKeyListener(this);
        this.peli = peli;
        this.peliHahmo = pelinTiedot.getPeliHahmo();

    }

    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int nappain = e.getKeyCode();
        ensimmainenPelaaja(nappain);
        if (nappain == VK_P) {
            peli.tauko();
        }
        if (nappain == VK_R) {
            uusiPeli();
        }
        if (peliHahmo.getLiikuAlas()) {
            peliHahmo.setY(peliHahmo.getY() + peliHahmo.getNopeus());
        }
        if (peliHahmo.getLiikuYlos()) {
            peliHahmo.setY(peliHahmo.getY() - peliHahmo.getNopeus());
        }
        if (peliHahmo.getLiikuVasemmalle()) {
            peliHahmo.setX(peliHahmo.getX() - peliHahmo.getNopeus());
        }
        if (peliHahmo.getLiikuOikealle()) {
            peliHahmo.setX(peliHahmo.getX() + peliHahmo.getNopeus());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int nappain = e.getKeyCode();
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

    }

    private void uusiPeli() {
        peli.getPeliAlusta().setVisible(false);
        peli.tauko();
        peli = null;
        Peli peli = new Peli(pelinTiedot);
        peli.aloita();
    }

    private void ensimmainenPelaaja(int nappain) {
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
    }
}
