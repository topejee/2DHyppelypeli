/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Tommi
 */
public class Hahmo {

    private int x;
    private int y;
    private int korkeus;
    private int leveys;
    private Rectangle hahmo;

    public Hahmo() {
        this.x = 0;
        this.y = 0;
        this.korkeus = 0;
        this.leveys = 0;
        this.hahmo = new Rectangle(x, y, leveys, korkeus);
    }

    public void setKorkeus(int x) {
        this.korkeus = Math.max(x, 0);

    }

    public void setLeveys(int x) {
        this.leveys = Math.max(x, 0);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int x) {
        this.y = x;
    }

    public void kasvataX() {
        this.x++;
    }

    public void kasvataY() {
        this.y++;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void piirra(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, leveys, korkeus);
    }
    public Rectangle getHahmo(){
        return hahmo;
    }
    
    public void liiku(Peli This) {
        getHahmo().setBounds(getX(), getY(), getLeveys(), getKorkeus());
    }

}
