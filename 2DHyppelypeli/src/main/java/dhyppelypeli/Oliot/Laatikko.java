/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Tommi
 */
public class Laatikko extends Hahmo {

    public Laatikko() {
        setLeveys(40);
        setKorkeus(40);
    }

    @Override
    public void liiku(Peli This) {
        setX(getX()-5);
        getHahmo().setBounds(getX(), getY(), getLeveys(), getKorkeus());
    }
    @Override
     public void piirra(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getX(),getY(), getLeveys(), getKorkeus());
    }

}
