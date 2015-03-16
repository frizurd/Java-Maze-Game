/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Frizky
 */
public class DoolhofSpel {

    /**
     * @param args the command line arguments
     */
    private static final int FRAMEBREEDTE = 595;
    private static final int FRAMEHOOGTE = 480;
    
    private static final String TITEL = "Doolhof Game";
    private static final String VERSIE = "0.1";
    
    public static void main(String[] args) {
        DoolhofSpel spel = new DoolhofSpel();
    }

    public DoolhofSpel() {

        StartFrame startframe = new StartFrame();
        startframe.setTitle(TITEL + " " + VERSIE);

        startframe.setSize(FRAMEBREEDTE, FRAMEHOOGTE);

        startframe.setResizable(false);
        startframe.setVisible(true);
        
        startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

        
}

