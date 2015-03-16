/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Frizky
 */
public class Vak {
    
    private final Coordinaat coordinaat;
    private final HashMap<Coordinaat, Vak> nVakken;

    private SpelVoorwerp spelvoorwerp;
    private int vakGrote = 32;
    
    private boolean pad;
    
    public Vak(Coordinaat cord) {
        this.coordinaat = cord;
        nVakken = new HashMap<>();
        pad = false;
    }

    public boolean heeftVoorwerp() {
        return (spelvoorwerp != null);
    }

    public SpelVoorwerp getVoorwerp() {
        return spelvoorwerp;
    }

    public void setVoorwerp(SpelVoorwerp voorwerp) {
        this.spelvoorwerp = voorwerp;
    }

    public Coordinaat getKey() {
        return coordinaat;
    }
    public boolean heeftBuur(Coordinaat key) {
        return nVakken.containsKey(key);
    }

    public Vak getBuur(Coordinaat key) {
        Set<Coordinaat> keySet = nVakken.keySet();

        for (Coordinaat k : keySet) {
            if (k.equals(key)) {
                return nVakken.get(k);
            }
        }
        return null;
    }

    public void setBuur(Vak vak) {
        nVakken.put(vak.getKey(), vak);
    }
    
    public void setPad(boolean pad) {
        this.pad = pad;
    }
    
    public boolean isPad() {
        return pad;
    }

    public void paint(Graphics g) {
        
        g.drawImage(spelvoorwerp.getVoorwerpImage(),
                0 + coordinaat.getX() * vakGrote, 0 + coordinaat.getY() * vakGrote,
                vakGrote, vakGrote, null);
    }
}
