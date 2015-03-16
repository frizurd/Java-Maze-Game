/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

/**
 *
 * @author Frizky
 */
public class Level {

    private char[][] level1 = {
        {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
        {'b', 's', 'm', 'm', 'm', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'p', 'b'},
        {'b', 'p', 'm', 'm', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'm', 'p', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'p', 'm', 'h', 'p', 'm', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'b'},
        {'b', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'b'},
        {'b', 'r', 'm', 'p', 'm', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'p', 'p', 'p', 'c', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'v', 'b'},
        {'b', 'p', 'p', 'p', 'p', 'p', 'm', 'm', 'm', 'm', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'b'},
        {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}
    };
    
    private char[][] level2 = {
        {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
        {'b', 's', 'm', 'm', 'm', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'p', 'b'},
        {'b', 'p', 'm', 'm', 'p', 'p', 'p', 'm', 'h', 'm', 'p', 'c', 'm', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'm', 'p', 'p', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'm', 'm', 'b'},
        {'b', 'p', 'r', 'p', 'm', 'm', 'p', 'm', 'd', 'm', 'p', 'p', 'm', 'p', 'p', 'p', 'v', 'b'},
        {'b', 'p', 'p', 'p', 'm', 'y', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'b'},
        {'b', 'm', 'm', 'p', 'm', 'm', 'p', 'm', 'm', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'b'},
        {'b', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'p', 'b'},
        {'b', 'p', 'p', 'p', 'p', 'p', 'm', 'm', 'm', 'm', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'b'},
        {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}
    };

    private char[][] level3 = {
        {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
        {'b', 's', 'm', 'm', 'm', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'm', 'm', 'b'},
        {'b', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'm', 'b'},
        {'b', 'p', 'm', 'm', 'p', 'p', 'p', 'm', 'p', 'm', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'v', 'b'},
        {'b', 'p', 'm', 'p', 'p', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'm', 'd', 'm', 'm', 'm', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'b'},
        {'b', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'p', 'p', 'p', 'm', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'm', 'm', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'm', 'm', 'p', 'm', 'y', 'p', 'b'},
        {'b', 'p', 'm', 'p', 'm', 'p', 'p', 'p', 'h', 'm', 'p', 'p', 'p', 'm', 'p', 'm', 'r', 'p', 'm', 'm', 'p', 'b'},
        {'b', 'm', 'm', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'p', 'm', 'p', 'm', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'b'},
        {'b', 'c', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'm', 'p', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'm', 'b'},
        {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}
    };
    
    public char[][] getLevel(int level) {
        switch (level) {
            case 1:
                return level1;
            case 2:
                return level2;
            case 3:
                return level3;
            default:
                return level1;
        }
        
    }

}
