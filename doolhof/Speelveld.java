/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Frizky
 */
public class Speelveld extends JPanel implements ActionListener {

    private Timer timer;
    private int vakGrote = 32;
    private Speler speler;
    private boolean levelGewonnen = false;
    private boolean spelGewonnen = false;
    private char[][] levelIndeling;
    private int huidigLevel;
    private boolean beginLevel = true;
    
    private KnoppenPaneel knoppenpaneel;
    private GameFrame gameFrame;
    
    public Speelveld() {
        speler = new Speler(null);

        addKeyListener(new SpelerActie());
        setFocusable(true);

        timer = new Timer(25, this);
        timer.start();

        Level lvl = new Level();
        levelIndeling = lvl.getLevel(huidigLevel);
        huidigLevel = 1;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (getCoordinaten(speler.getVakX(), speler.getVakY()) == 'v') {
            levelGewonnen = true;

            if (huidigLevel > 2) {
                spelGewonnen = true;
            }
        }

        if (speler.getBazooka() != null) {
            knoppenpaneel.setMunitie(speler.getBazooka().getMunitie());
        }

        repaint();
    }
    
    public void restartLevel()
    {
        Level level = new Level();
        levelIndeling = level.getLevel(huidigLevel);
        beginLevel = true;
        speler.setSpelerStappen(0);
        speler.setSleutel(false);
        knoppenpaneel.setMoves(speler.getStappen());
        knoppenpaneel.setMunitie(speler.getBazooka().getMunitie());
        levelGewonnen = false;
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        tekenSpeelveld(g);

        if (levelGewonnen) {
            levelGewonnen(g);
        }

        if (spelGewonnen) {
            roepEindSchermAan(g);
        }

    }

    public void tekenSpeelveld(Graphics g) {
        
        int rows = levelIndeling.length;
        int cols = levelIndeling[0].length;
        Vak[][] vakArray = new Vak[rows][cols];

        Coordinaat k;
        Vak vak;
        SpelVoorwerp spelvoorwerp;

        if (!levelGewonnen) {

            ImageIcon veldBG = new ImageIcon("src//images/speelveldBG.jpg");
            g.drawImage(veldBG.getImage(), 0, 0, null);

            for (int j = 0; j < levelIndeling.length; j++) {
                for (int i = 0; i < levelIndeling[j].length; i++) {

                    k   = new Coordinaat(j, i);
                    vak = new Vak(k);
                    
                    switch (levelIndeling[j][i]) {
                        case 'm':
                            spelvoorwerp = new BinnenMuur();
                            vak.setVoorwerp(spelvoorwerp);
                            vak.paint(g);
                            break;                        
                        case 'b':
                            spelvoorwerp = new BuitenMuur();
                            vak.setVoorwerp(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'k':
                            spelvoorwerp = new Kruimel();
                            vak.setVoorwerp(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'v':
                            spelvoorwerp = new Vriend();
                            vak.setVoorwerp(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'c':
                            spelvoorwerp = new Valsspeler();
                            vak.setVoorwerp(spelvoorwerp);
                            
                            speler.setValsspeler(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'r':
                            spelvoorwerp = new Bazooka();
                            vak.setVoorwerp(spelvoorwerp);
                            
                            speler.setBazooka(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'h':
                            speler.setVak(vak);
                            
                            spelvoorwerp = new Helper();
                            vak.setVoorwerp(spelvoorwerp);
                            speler.setHelper(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'y':
                            spelvoorwerp = new Sleutel();
                            vak.setVoorwerp(spelvoorwerp);
                            vak.paint(g);
                            break;
                        case 'd':
                            spelvoorwerp = new Deur();
                            vak.setVoorwerp(spelvoorwerp);
                            speler.setDeur(spelvoorwerp);
                            vak.paint(g);
                            break;
                    }
                    
                    vakArray[j][i] = vak;

                    if (beginLevel == true) {
                        speler.setLevel(levelIndeling);
                        speler.bepaalBeginCoordinaten();
                        beginLevel = false;
                    }
                    
                    g.drawImage(speler.getSpelerImage().getImage(),
                            speler.getVakY() * vakGrote,
                            speler.getVakX() * vakGrote, null);
                    
                   
                }
            }
            zetBuren(vakArray);
        }
    }
    
    public void levelGewonnen(Graphics g) {
        
        beginLevel = true;

        if (huidigLevel < 3) {
            huidigLevel++;
            
            levelGewonnen = false;
        }
        
        Level lvl = new Level();
        levelIndeling = lvl.getLevel(huidigLevel);

        gameFrame.berekenGrootte();

        knoppenpaneel.setMoves(0);
        int stappen = speler.getTotaleStappenTeller() + speler.getStappen();
        speler.setTotaleStappenTeller(stappen);
        speler.setSpelerStappen(0);
        
        speler.setSleutel(false);
    }
    
    public void roepEindSchermAan(Graphics g) {

        ImageIcon veldBG = new ImageIcon("src//images/victory.jpg");
        g.drawImage(veldBG.getImage(), 0, 0, null);

        JPanel eindPanel = new JPanel();
        eindPanel.setSize(800, 600);
        eindPanel.setOpaque(false);
        
        JButton nieuweGameBtn = new JButton("Opnieuw spelen");
        JLabel label = new JLabel("Je hebt het spel gewonnen met "
                + speler.getTotaleStappenTeller() + " stappen!");
        label.setForeground(Color.white);
        
        GridLayout eindLayout = new GridLayout(3, 1, 125, 125);
        eindPanel.setLayout(eindLayout);
        
        JPanel spacer = new JPanel();
        spacer.setOpaque(false);
        
        eindPanel.add(spacer);
        eindPanel.add(label);
        eindPanel.add(nieuweGameBtn);
        add(eindPanel);
        
        nieuweGameBtn.setFocusable(false);
        nieuweGameBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.dispose();

                DoolhofSpel spel = new DoolhofSpel();
            }
        });

        knoppenpaneel.setVisible(false);
    }

    public void zetBuren(Vak[][] vakMap) {

        int rij = vakMap.length;
        int kolom = vakMap[0].length;

        Vak vak;

        for (int i = 0; i < rij; i++) {
            for (int j = 0; j < kolom; j++) {

                vak = vakMap[i][j];

                if (i > 0) {
                    vak.setBuur(vakMap[i - 1][j]); //boven
                }
                if (i < (rij - 1)) {
                    vak.setBuur(vakMap[i + 1][j]); //beneden
                }
                if (j > 0) {
                    vak.setBuur(vakMap[i][j - 1]); //links
                }
                if (j < (kolom - 1)) {
                    vak.setBuur(vakMap[i][j + 1]); //rechts
                }
            }
        }
    }
    
    public char[][] getLevelIndeling() {
        return levelIndeling;
    }
    
    public char getCoordinaten(int x, int y) {
        char index = levelIndeling[x][y];
        return index;
    }
    
    public int getHuidigLevel() {
        return huidigLevel;
    }

    public void setKnoppenpaneel(KnoppenPaneel knoppenpaneel) {
        this.knoppenpaneel = knoppenpaneel;
    }

    public void setSpeler() {
        knoppenpaneel.setSpeler(speler);
    }

    public void setBeginLevel(boolean antwoord) {
        beginLevel = antwoord;
    }

    public void setFrame(GameFrame frame) {
        this.gameFrame = frame;
    }

    public class SpelerActie extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int toetscode = e.getKeyCode();

            if(!spelGewonnen)
            {
                if (toetscode == KeyEvent.VK_UP) {  
                    speler.beweeg("boven");
                }
                if (toetscode == KeyEvent.VK_DOWN) {
                    speler.beweeg("onder");
                }
                if (toetscode == KeyEvent.VK_LEFT) {
                    speler.beweeg("links");
                }
                if (toetscode == KeyEvent.VK_RIGHT) {
                    speler.beweeg("rechts");
                }

                knoppenpaneel.setMoves(speler.getStappen());
            }
            if (toetscode == KeyEvent.VK_SPACE) {
                speler.vuurBazookaAf();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}
    }
}