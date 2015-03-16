/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

/**
 *
 * @author Frizky
 */
public class Coordinaat {
    
    public final int y;  
    public final int x;  
    
    public Coordinaat(int i, int j)
    {
        this.y = i;
        this.x = j;
    }
    
    /**
     * Coordinaat is used as a key in a Hashmap. Override equals and hashcode is needed.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Coordinaat p = (Coordinaat) obj;
        
        return ((p.y == this.y) && (p.x == this.x));
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}