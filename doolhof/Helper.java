/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Frizky
 */
public class Helper extends SpelVoorwerp {
    
    private char[][] level;
    private Queue<Node> queue;
    private List<Node> visited;
    
    public Helper() {
        queue = new LinkedList<>();
        visited = new ArrayList<>();
        
        ImageIcon helper = new ImageIcon("src//images/helper.gif");
        super.setImage(helper.getImage());
        
    }

    public void vindKortstePad(Vak vak, Speler speler) {

        this.level = speler.getLevel();
        
        Node fNode = null;

        Node sNode = new Node();
        sNode.vak = vak;
        sNode.parent = null;
        queue.add(sNode);

        boolean vriendGevonden = false;

        Node currentNode;
        Vak currentTile;
        
        Node childNode;
        Vak childTile;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (queue.size() > 0 && !vriendGevonden) {

            currentNode = queue.remove();
            currentTile = currentNode.vak;
            
            visited.add(currentNode);

            if (currentTile.getVoorwerp() instanceof Vriend) {
                fNode = currentNode;
                vriendGevonden = true;
                System.out.println("Vriend gevonden");
            }
            else {
                
                for (int i = 0; i < 4; i++) {

                    int x = currentTile.getKey().getX() + dx[i];
                    int y = currentTile.getKey().getY() + dy[i];
                    
                    childTile = currentNode.vak.getBuur(new Coordinaat(y, x));

                    if (childTile != null
                            && !(childTile.getVoorwerp() instanceof BinnenMuur)
                            && !(childTile.getVoorwerp() instanceof BuitenMuur)) {
                        childNode = new Node();
                        childNode.vak = childTile;
                        childNode.parent = currentNode;
                        

                        boolean open = true;
                        for (Node visitNode : visited) {
                            if (childNode.vak.getKey().equals(
                                    visitNode.vak.getKey())) {
                                open = false;
                            }
                        }
                        if (open) {
                            queue.add(childNode);
                        }
                    }
                }
            }
        }
        if (vriendGevonden) {
            currentNode = fNode;
            
            boolean terugNaarBegin = false;
            while (!terugNaarBegin) {
 
                if(currentNode.parent == null) {
                    terugNaarBegin = true;
                } else {
                    currentNode.vak.setPad(true);
                    if (!(currentNode.vak.getVoorwerp() instanceof Vriend)
                            && !(currentNode.vak.getVoorwerp() instanceof Deur)) {
                        int x = currentNode.vak.getKey().getX();
                        int y = currentNode.vak.getKey().getY();
                        plaatsKruimel(y, x);
                    }
                    currentNode = currentNode.parent;
                }
            }
        }
    }
    
    public void plaatsKruimel(int x, int y) {
        char[] xArray = level[x];
        xArray[y] = 'k';
    }

    class Node {
        public Vak vak;
        public Node parent;
    }
}
