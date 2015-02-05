/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import dhyppelypeli.Grafiikka.PeliHahmoPiirto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    private boolean maassa;
    private int hyppaa;
    private int osuma;
    private int elamat;
    private PeliHahmoPiirto peliHahmoPiirto;

    public PeliHahmo() {
        setKorkeus(50);
        setLeveys(50);
        nopeus = 10;
        vasenNappain = (KeyEvent.VK_A);
        oikeaNappain = (KeyEvent.VK_D);
        ylaNappain = (KeyEvent.VK_W);
        alaNappain = (KeyEvent.VK_S);
        maassa = true;
        hyppaa = 0;
        osuma = 0;
        elamat = 3;
        this.peliHahmoPiirto = new PeliHahmoPiirto(this);
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

    public Boolean getMaassa() {
        return maassa;
    }
/**
 * Metodi liikuttaa PeliHahmoa
 * @param This 
 */
    @Override
    public void liiku(Peli This) {
        getHahmo().setBounds(getX(), getY(), getLeveys(), getKorkeus());
        if (!getMaassa()) {
            if (getLiikuAlas()) {
                setY(getY() + getNopeus());
            }
            if (getLiikuYlos()) {
                setY(getY() - getNopeus());
            }
            if (getLiikuVasemmalle()) {
                setX(getX() - getNopeus());
            }
            if (getLiikuOikealle()) {
                setX(getX() + getNopeus());
            }
        } else {
            if (getLiikuVasemmalle()) {
                setX(getX() - getNopeus());
            }
            if (getLiikuOikealle()) {
                setX(getX() + getNopeus());
            }
            if (hyppaa >= 21) {
                setY(getY() - getNopeus());
                hyppaa--;
            } else if (hyppaa < 21 && getY() < 550 && osuma == 0) {
                setY(getY() + getNopeus());
                hyppaa = 1;
            } else {
                hyppaa = 0;
            }
            if (osuma != 0) {
                osuma--;
            }
        }
    }

    public void setOsuma() {
        osuma = 10;
    }

    public void setHyppaaTrue() {
        hyppaa = 40;
    }

    public int getHyppaaTrue() {
        return hyppaa;
    }

    public int getElamat() {
        return elamat;
    }

    public void vahennaElamat() {
        elamat--;
    }

    public PeliHahmoPiirto getPeliHahmoPiirto() {
        return peliHahmoPiirto;
    }

}
