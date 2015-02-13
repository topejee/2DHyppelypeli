/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Grafiikka;

import dhyppelypeli.Oliot.Laatikko;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

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
        try {
            BufferedImage kuva = ImageIO.read(getClass().getResourceAsStream("/laatikko.png"));
            g.drawImage(kuva, hahmo.getX(), hahmo.getY(), Color.yellow, null);
        } catch (IOException e) {
            System.out.println("Ei ollut kuvaa");
        }
    }
}
