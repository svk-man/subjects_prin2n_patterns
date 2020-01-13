package shapes;

import java.awt.*;

// Реализация паттерна "Фабричный метод"
public class MyShapeFactory {
    public MyShape createMyShape(MyShapeType type, int x, int y, Color color, int radius, int width, int height) {
        MyShape myShape = null;

        switch (type) {
            case MY_CIRCLE:
                myShape = new MyCircle(x, y, radius, color);
                break;
            case MY_TRIANGLE:
                myShape = new MyTriangle(x, y, color);
                break;
            case MY_RECTANGLE:
                myShape = new MyRectangle(x, y, width, height, color);
                break;
        }

        return myShape;
    }
}
