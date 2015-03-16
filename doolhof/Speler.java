/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Frizky
 */
public class Speler extends SpelVoorwerp {

    private int vakX, vakY;
    private ImageIcon spelerImage;
    private String spelerRichting;
    private int totaleStappenTeller = 0;
    private int stappenTellerLevel = 0;
    private char[][] levelArray;
    private boolean heeftSleutel;
    
    private Bazooka bazooka;
    private Helper helper;
    private Valsspeler valsspeler;
    private Deur deur;
    
    private Vak vak;
    
    public Speler(Vak vak) {
        
        this.vak = vak;
        
        ImageIcon speler = new ImageIcon("src//images/speler.png");
        spelerImage = speler;
        
        bazooka = null;
        helper = null;
        valsspeler = null;
        
        heeftSleutel = false;
    }
    
    public void bepaalBeginCoordinaten() {

        for (int i = 0; i < levelArray.length; i++) {
            for (int j = 0; j < levelArray[1].length; j++) {

                if (levelArray[i][j] == 's') {
                    vakX = j;
                    vakY = i;
                }
            }
        }
    }
    
    public void beweeg(String richting) {

        ImageIcon spelerBeneden, spelerOmhoog, spelerLinks, spelerRechts;

        spelerBeneden   = new ImageIcon("src//images/speler.png");
        spelerOmhoog    = new ImageIcon("src//images/speler-up.png");
        spelerLinks     = new ImageIcon("src//images/speler-left.png");
        spelerRechts    = new ImageIcon("src//images/speler-right.png");

        switch (richting) {
            case "boven":
                
                char vakBoven = levelArray[vakX - 1][vakY];
                
                if (vakBoven != 'm' && vakBoven != 'b')
                {
                    if (vakBoven == 'd') { 
                        if (heeftSleutel) {
                            vakX -= 1;
                            stappenTellerLevel++;
                        }
                    } else {
                        vakX -= 1;
                        stappenTellerLevel++;
                    }
                }
                setSpelerImage(spelerOmhoog);
                setSpelerRichting(richting);
                
                break;

            case "onder":
                
                char vakOnder = levelArray[vakX + 1][vakY];
                
                if (vakOnder != 'm' && vakOnder != 'b') {
                    if (vakOnder == 'd') { 
                        if (heeftSleutel) {
                            vakX += 1;
                            stappenTellerLevel++;
                        }
                    } else {
                        vakX += 1;
                        stappenTellerLevel++;
                    }
                }
                setSpelerImage(spelerBeneden);
                setSpelerRichting(richting);
                
                break;

            case "links":

                char vakLinks = levelArray[vakX][vakY - 1];

                if (vakLinks != 'm' && vakLinks != 'b') {
                    if (vakLinks == 'd') { 
                        if (heeftSleutel) {
                            vakY -= 1;
                            stappenTellerLevel++;
                        }
                    } else {
                        vakY -= 1;
                        stappenTellerLevel++;
                    }
                }
                setSpelerImage(spelerLinks);
                setSpelerRichting(richting);

                break;

            case "rechts":
                
                char vakRechts = levelArray[vakX][vakY + 1];
                
                if (vakRechts != 'm' && vakRechts != 'b') {
                    if (vakRechts == 'd') { 
                        if (heeftSleutel) {
                            vakY += 1;
                            stappenTellerLevel++;
                        }
                    } else {
                        vakY += 1;
                        stappenTellerLevel++;
                    }
                }
                setSpelerImage(spelerRechts);
                setSpelerRichting(richting);
                
                break;
                
        }
       
        voorwerpOppakken();
    }

    public void voorwerpOppakken() {
        
        char objectVeld = levelArray[vakX][vakY];
        
        if (objectVeld != 'v' && objectVeld != 'd') {
            if (objectVeld == 'c') {
                stappenTellerLevel = stappenTellerLevel - valsspeler.getWaarde();
            } else if (objectVeld == 'r') {
                bazooka.munitieOppakken();
            } else if (objectVeld == 'h') {
                gebruikHelper();
            } else if (objectVeld == 'y') {
                heeftSleutel = true;
            }

            verdwijnVoorwerp(vakX, vakY);
        }
    }
    
    public void verdwijnVoorwerp(int x, int y) {
        char[] xArray = levelArray[x];
        xArray[y] = 'p';
    }
    
    public void vuurBazookaAf() {
        if (bazooka != null) {
            bazooka.schieten(spelerRichting, this);
            bazooka = null;
        }
    }
    
    public void gebruikHelper() {
        if (helper != null) {
            helper.vindKortstePad(vak, this);
        }
    }
    
    public void setTotaleStappenTeller(int totaleStappenTeller) {
        this.totaleStappenTeller = totaleStappenTeller;
    }

    public void setSleutel(boolean antwoord) {
        heeftSleutel = antwoord;
    }
    
    public void setSpelerStappen(int stappen) {
        stappenTellerLevel = stappen;
    } 

    public void setSpelerImage(ImageIcon image) {
        spelerImage = image;
    }
    
    public void setSpelerRichting(String richting) {
        spelerRichting = richting;
    }
    
    public void setDeur(SpelVoorwerp deur) {
        this.deur = (Deur) deur;
    }

    public void setLevel(char[][] level) {
        this.levelArray = level;
    }
    
    public void setValsspeler(SpelVoorwerp valsspeler) {
        this.valsspeler = (Valsspeler) valsspeler;
    }
    
    public void setBazooka(SpelVoorwerp bazooka) {
        this.bazooka = (Bazooka) bazooka;
    }

    public void setHelper(SpelVoorwerp helper) {
        this.helper = (Helper) helper;
    }

    public void setVak(Vak vak) {
        this.vak = vak;
    }
        
    public int getVakX() {
        return vakX;
    }

    public int getVakY() {
        return vakY;
    }
    
    public int getStappen() {
        return stappenTellerLevel;
    }
    
    public Bazooka getBazooka() {
        return bazooka;
    }
    
    public char[][] getLevel() {
        return levelArray;
    }
    
    public ImageIcon getSpelerImage() {
        return spelerImage;
    }

    public int getTotaleStappenTeller() {
        return totaleStappenTeller;
    }

}
