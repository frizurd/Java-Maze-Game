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
public class BinnenMuur extends SpelVoorwerp {
    
    private char[][] levelArray;
    
    public BinnenMuur() {
        ImageIcon binnenMuur = new ImageIcon("src//images/binnenmuur.png");
        super.setImage(binnenMuur.getImage());
    }
    
    public void setLevel(char[][] level) {
        this.levelArray = level;
    }
    
    public void vernietigMuur(int x, int y) {
        char[] xArray = levelArray[x];
        xArray[y] = 'p';
    }
    
}
