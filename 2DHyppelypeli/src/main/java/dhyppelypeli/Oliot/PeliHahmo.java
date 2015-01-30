/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tommi
 */
public class PeliHahmo extends Hahmo {

    private int nopeus;
    private int vasenNappain;
    private int oikeaNappain;
    private int ylaNappain;
    private int alaNappain;
    private boolean liikuYlos;
    private boolean liikuAlas;
    private boolean liikuOikealle;
    private boolean liikuVasemmalle;

    public PeliHahmo() {
        setKorkeus(50);
        setLeveys(50);
        nopeus = 10;
        vasenNappain = (KeyEvent.VK_A);
        oikeaNappain = (KeyEvent.VK_D);
        ylaNappain = (KeyEvent.VK_W);
        alaNappain = (KeyEvent.VK_S);
    }

    public int getNopeus() {
        return nopeus;
    }

    public int getVasenNappain() {
        return vasenNappain;
    }

    public int getOikeaNappain() {
        return oikeaNappain;
    }

    public int getYlaNappain() {
        return ylaNappain;
    }

    public int getAlaNappain() {
        return alaNappain;
    }

    public void setLiikuYlosTrue() {
        liikuYlos = true;
    }

    public void setLiikuAlasTrue() {
        liikuAlas = true;
    }

    public void setLiikuVasemmalleTrue() {
        liikuVasemmalle = true;
    }

    public void setLiikuOikealleTrue() {
        liikuOikealle = true;
    }

    public void setLiikuYlosFalse() {
        liikuYlos = false;
    }

    public void setLiikuAlasFalse() {
        liikuAlas = false;
    }

    public void setLiikuVasemmalleFalse() {
        liikuVasemmalle = false;
    }

    public void setLiikuOikealleFalse() {
        liikuOikealle = false;
    }

    public Boolean getLiikuOikealle() {
        return liikuOikealle;
    }

    public Boolean getLiikuVasemmalle() {
        return liikuVasemmalle;
    }

    public Boolean getLiikuYlos() {
        return liikuYlos;
    }

    public Boolean getLiikuAlas() {
        return liikuAlas;
    }

}
