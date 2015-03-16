/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import javax.swing.ImageIcon;

/**
 *
 * @author Frizky
 */
public class Valsspeler extends SpelVoorwerp {

    int waarde;

    public Valsspeler() {
        ImageIcon valsspeler = new ImageIcon("src//images/valsspeler.png");
        super.setImage(valsspeler.getImage());
        
        this.waarde = 1 + ((int) (Math.random() * 20));
    }

    public int getWaarde() {
        return waarde;
    }

}
