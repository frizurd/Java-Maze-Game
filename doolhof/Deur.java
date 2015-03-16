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
public class Deur extends SpelVoorwerp {
    
    public Deur() {
        ImageIcon deur = new ImageIcon("src//images/deur.png");
        super.setImage(deur.getImage());
    }
}
