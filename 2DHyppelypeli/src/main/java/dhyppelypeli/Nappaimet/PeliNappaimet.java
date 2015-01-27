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

    }

    @Override
    public void keyReleased(KeyEvent e) {

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
            peliHahmo.setX(peliHahmo.getX() - peliHahmo.getNopeus());
        }
        if (nappain == peliHahmo.getOikeaNappain()) {
            peliHahmo.setX(peliHahmo.getX() + peliHahmo.getNopeus());
        }
          if (nappain == peliHahmo.getYlaNappain()) {
            peliHahmo.setY(peliHahmo.getY() - peliHahmo.getNopeus());
        }
        if (nappain == peliHahmo.getAlaNappain()) {
            peliHahmo.setY(peliHahmo.getY() + peliHahmo.getNopeus());
        }
    }
}
