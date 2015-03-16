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
public class BuitenMuur extends SpelVoorwerp {

    public BuitenMuur() {
        ImageIcon buitenMuur = new ImageIcon("src//images/buitenmuur.png");
        super.setImage(buitenMuur.getImage());
    }
    
}
