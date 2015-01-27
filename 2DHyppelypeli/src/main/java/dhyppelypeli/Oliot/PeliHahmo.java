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

}
