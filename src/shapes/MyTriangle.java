package shapes;

import java.awt.Color;

public class MyTriangle extends MyAbstractPolygon {
    
    public MyTriangle(int x, int y, Color color) {
        super(x, y, color);
        
        addVertex(0, 0);
        addVertex(-100, 50);
        addVertex(50, 100);        
    }   
}
