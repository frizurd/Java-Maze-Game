/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Frizky
 */
public class KnoppenPaneel extends JPanel {
    
    private JButton restartButton = new JButton("Restart");
    private JLabel stappenLabel = new JLabel("Aantal stappen: 0");
    private JLabel munitieLabel = new JLabel("Bazooka munitie: 0");
    
    private Speler speler;
    private Speelveld speelveld;
   
    
    public KnoppenPaneel() {
        setBackground(Color.BLACK);
        
        Dimension d = new Dimension(50, 35);
        setPreferredSize(d);
        
        stappenLabel.setForeground(Color.white);
        munitieLabel.setForeground(Color.white);
        
        restartButton.setFocusable(false);
        restartButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speelveld.restartLevel();
            }
        });
        
        add(stappenLabel);
        add(restartButton);
        add(munitieLabel);
        
    }

    public void setSpeelveld(Speelveld speelveld) {
        this.speelveld = speelveld;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }
    
    public void setMoves(int moves) {
        stappenLabel.setText("Aantal stappen: " + moves );
    }
    
    public void setMunitie(int munitie) {
        munitieLabel.setText("Bazooka munitie: " + munitie);
    }
    
    
}
