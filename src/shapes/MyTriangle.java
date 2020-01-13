package shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

public class MyTriangle extends MyAbstractPolygon {
    
    public MyTriangle(int x, int y, Color color) {
        super(x, y, color);
        
        addVertex(0, 0);
        addVertex(-100, 50);
        addVertex(50, 100);        
    }

    // Реализация паттерна "Прототип". Шаг 3. Реализуем в каждом классе метод copy
    @Override
    public MyShape copy() {
        return new MyTriangle(this.getX(), this.getY(), this.getColor());
    }
}
