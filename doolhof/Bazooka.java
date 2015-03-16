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
public class Bazooka extends SpelVoorwerp {

    private int munitie;
    private BinnenMuur muur;
    
    public Bazooka() {
        ImageIcon bazooka = new ImageIcon("src//images/bazooka.png");
        super.setImage(bazooka.getImage());

        munitie = 0;
        muur = new BinnenMuur();
    }

    public void schieten(String richting, Speler speler) {
        int teller = 1;
        
        int vakX = speler.getVakX();
        int vakY = speler.getVakY();
        
        char[][] level = speler.getLevel();
        muur.setLevel(level);
        
        if (munitie >= 1) {
            switch (richting) {
                case "boven":
                    while ((level[vakX - teller][vakY]) != 'b') {
                        if (level[vakX - teller][vakY] == 'm') {

                            muur.vernietigMuur(vakX - teller, vakY);
                            munitie--;
                            break;
                        }
                        teller++;
                    }
                    break;
                case "onder":
                    while ((level[vakX + teller][vakY]) != 'b') {
                        if (level[vakX + teller][vakY] == 'm') {

                            muur.vernietigMuur(vakX + teller, vakY);
                            munitie--;
                            break;
                        }
                        teller++;
                    }
                    break;
                case "rechts":
                    while ((level[vakX][vakY + teller]) != 'b') {
                        if (level[vakX][vakY + teller] == 'm') {

                            muur.vernietigMuur(vakX, vakY + teller);
                            munitie--;
                            break;
                        }
                        teller++;
                    }
                    break;
                case "links":
                    while ((level[vakX][vakX - teller]) != 'b') {
                        if (level[vakX][vakY - teller] == 'm') {

                            muur.vernietigMuur(vakX, vakY - teller);
                            munitie--;
                            break;
                        }
                        teller++;
                    }
                    break;
            }
        }
    }

    public void munitieOppakken() {
        munitie++;
    }
    
    public int getMunitie() {
        return munitie;
    }
}
