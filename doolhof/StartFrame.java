/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Patrick
 */
public class StartFrame extends JFrame {
    
    private JButton startButton = new JButton("Starten");
    private JButton sluitButton = new JButton("Sluiten");
    
    public StartFrame()
    {
        repaint();
        startButton.setPreferredSize(new Dimension(150, 30));
        sluitButton.setPreferredSize(new Dimension(150, 30));

        setContentPane(new JPanel() {
            
            ImageIcon beginScherm   = new ImageIcon("src//images/intro.jpg");
            public void paintComponent(Graphics g) {
                g.drawImage(beginScherm.getImage(), 0, 0, null);
            }
        });

        add(startButton);
        add(sluitButton);
        
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startSpel();
            }
        });

        sluitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sluitSpel();
            }
        });
        
    }
    
    public void startSpel() {
        dispose();
        GameFrame gameframe = new GameFrame();
        gameframe.berekenGrootte();
    }

    public void sluitSpel() {
        dispose();
    }

}
