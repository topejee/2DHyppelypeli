/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhyppelypeli.Nappaimet;

import dhyppelypeli.PelinTiedot.PelinTiedot;
import dhyppelypeli.dhyppelypeli.NappaintenVaihtoValikko;
import dhyppelypeli.dhyppelypeli.Paavalikko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.KeyEvent.VK_W;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Luokassa on NappaintenVaihtoValkko luokan näppäinten ja teksti alueiden
 * toiminnallisuus
 *
 * @author Tommi
 */
public class NappaintenVaihto implements ActionListener {

    private NappaintenVaihtoValikko valikko;
    private PelinTiedot pelinTiedot;
    private int nappain;
    private boolean totta;
    private JTextField nappainTeksti;
    private char x;
    private JButton nappula;
    private String teksti;
    private Object VK;

    /**
     *
     * @param NappainTeksti teksti mihin uusi nappula kirjoitetaan
     * @param valikko valikko missä nappuloiden vaihtotehdään
     * @param tiedot pelintiedot
     */
    public NappaintenVaihto(JTextField NappainTeksti, NappaintenVaihtoValikko valikko, PelinTiedot tiedot) {
        this.valikko = valikko;
        this.pelinTiedot = tiedot;
        this.nappain = VK_W;
        this.totta = true;
        this.nappainTeksti = NappainTeksti;
        this.nappainTeksti.setText("          ");
        this.nappula = null;
        this.teksti = "";
    }

    /**
     * Metodi vaihtaa peli näppäimet
     *
     * @param ae nappula mitä on painettu
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        totta = true;
        nappula = (JButton) ae.getSource();
        teksti = nappula.getName();
        if (teksti.equals("alas")) {
            nappain();
            pelinTiedot.getPeliHahmo().setAlaNappain(nappain);
        }
        if (teksti.equals("vasen")) {
            nappain();
            pelinTiedot.getPeliHahmo().setVasenNappain(nappain);
        }
        if (teksti.equals("oikea")) {
            nappain();
            pelinTiedot.getPeliHahmo().setOikeaNappain(nappain);
        }
        if (teksti.equals("ylos")) {
            nappain();
            pelinTiedot.getPeliHahmo().setYlaNappain(nappain);
        }
        if (teksti.equals("Takaisin")) {
            valikko.setVisible(false);
            Paavalikko x = new Paavalikko(pelinTiedot);
        }
    }

    /**
     * Metodi varmistaa, että syötetty arvo on kirjain ja asettaa nappain intiin
     * uuden nappaimen teksti, sekä vaihtaa tekstit uusiksi.
     */
    public void nappain() {
        if (onkoKirjain()) {
            x = (nappainTeksti.getText()).charAt(0);
            String xx = "";
            xx += x;
            xx = xx.toUpperCase();
            x = xx.charAt(0);
            nappain = (int) x;
            nappula.setText(x + "");
        }
    }

    /**
     * @return palauttaa totta tai epätotta arvon sen perusteella onko
     * Stringissä kirjain vai ei
     */
    public boolean onkoKirjain() {

        return nappainTeksti.getText().matches("[a-zA-Z]");
    }
}
