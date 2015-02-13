/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Oliot;

import dhyppelypeli.Aloitus.Peli;
import dhyppelypeli.Grafiikka.LaatikkoPiirto;

/**
 *
 * @author Tommi
 */
public class Laatikko extends Hahmo {

    private LaatikkoPiirto laatikkoPiirto;
    private int liikkumisNopeus;

    public Laatikko() {
        setLeveys(40);
        setKorkeus(40);
        this.laatikkoPiirto = new LaatikkoPiirto(this);
        this.liikkumisNopeus = 0;
    }

    /**
     * Metodi liikuttaa laatikkoa
     *
     * @param This
     */
    @Override
    public void liiku(Peli This) {
        setX(getX() - liikkumisNopeus);
        getHahmo().setBounds(getX(), getY(), getLeveys(), getKorkeus());
        tormaustestiPeliHahmo(This);
    }

    /**
     * Testaa törmääkö PeliHahmo esineeseen
     *
     * @param peli pelattava peli
     */
    public void tormaustestiPeliHahmo(Peli peli) {
        if (getHahmo().intersects(peli.getPeliHahmo().getHahmo())) {
            peli.getPeliHahmo().setOsuma();
            if (getHahmo().intersects(peli.getPeliHahmo().getHahmo()) && peli.getPeliHahmo().getX() - getX() == -45) {
                peli.getPeliHahmo().vahennaElamat();
            } else {
                peli.getPeliHahmo().setY(501);
            }
        }
    }

    /**
     * Metodi testaa törmääkö laatikko toiseen laatikkoon
     *
     * @param peli pelattava peli
     * @return
     */

    
    public LaatikkoPiirto getLaatikkoPiirto() {
        return laatikkoPiirto;
    }

    public void setLiikkumisNopeus(int x) {
        liikkumisNopeus = x;
    }

    public int getLiikkumisNopeus() {
        return liikkumisNopeus;
    }

}
