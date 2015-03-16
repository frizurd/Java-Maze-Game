/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Frizky
 */
public class GameFrame extends JFrame {

    private static final String TITEL = "Doolhof Game";
    private static final String VERSIE = "0.1";
    
    private int frameBreedte = 595;
    private int frameHoogte = 480;

    private Speelveld veld;
    
    public GameFrame() {

        veld = new Speelveld();
        add(veld, BorderLayout.CENTER);

        KnoppenPaneel knoppenpaneel = new KnoppenPaneel();
        veld.setKnoppenpaneel(knoppenpaneel);
        knoppenpaneel.setSpeelveld(veld);
        veld.setSpeler();
        veld.setFrame(this);
        add(knoppenpaneel, BorderLayout.SOUTH);
        
        setTitle(TITEL + " " + VERSIE);

        setResizable(false);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void berekenGrootte() {
        char[][] charArray = veld.getLevelIndeling();

        frameBreedte    = (charArray[0].length * 32) + 6;
        frameHoogte     = (charArray.length * 32) + 64;
        
        setSize(frameBreedte, frameHoogte);
        
    }
}
