/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.PelinTiedot;

import dhyppelypeli.Oliot.PeliHahmo;

/**
 * Sisältää pelissä olevat tiedot
 * @author Tommi
 */
public class PelinTiedot {

    private int peliLaudanKorkeus;
    private int peliLaudanLeveys;
    private PeliHahmo peliHahmo;

    public PelinTiedot() {
        this.peliHahmo = new PeliHahmo();
        peliLaudanKorkeus = 600;
        peliLaudanLeveys = 800;
    }

    public int getPelilaudanKorkeus() {
        return peliLaudanKorkeus;
    }

    public int getPelilaudanLeveys() {
        return peliLaudanLeveys;
    }

    public void setPeliLaudanLeveys(int i) {
        peliLaudanLeveys = i;
    }

    public void setPeliLaudanKorkeus(int i) {
        peliLaudanKorkeus = i;
    }

    public PeliHahmo getPeliHahmo() {
        return peliHahmo;
    }

}
