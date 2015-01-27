/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Aloitus;

import dhyppelypeli.Oliot.PeliHahmo;
import dhyppelypeli.PelinTiedot.PelinTiedot;
import dhyppelypeli.dhyppelypeli.Paavalikko;

/**
 *
 * @author Tommi
 */
public class Main {

    public static void main(String[] args) {
        PeliHahmo peliHahmo = new PeliHahmo();
        PelinTiedot pelinTiedot = new PelinTiedot(peliHahmo);
        Peli pelaa = new Peli(pelinTiedot);
        pelaa.aloita();
    }
}
