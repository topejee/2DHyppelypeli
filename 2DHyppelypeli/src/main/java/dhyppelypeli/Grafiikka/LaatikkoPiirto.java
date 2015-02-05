/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Grafiikka;

import dhyppelypeli.Oliot.Laatikko;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Tommi
 */
public class LaatikkoPiirto {

    private Laatikko hahmo;

    public LaatikkoPiirto(Laatikko hahmo) {
        this.hahmo = hahmo;
    }

    /**
     * Piirtää kuvan laatikosta
     *
     * @param g
     */
    public void piirra(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(hahmo.getX(), hahmo.getY(), hahmo.getLeveys(), hahmo.getKorkeus());
    }
}
