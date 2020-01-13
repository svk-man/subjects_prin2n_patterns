package builders;


import shapes.*;

import java.awt.*;

// Реализация паттерна "Строитель"
/**
 * Конкретные строители реализуют шаги, объявленные в общем интерфейсе.
 */
public class MyShapeBuilder implements Builder {
    private int x;
    private int y;
    private Color color;
    private int radius;
    private int width;
    private int height;

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public MyShape getResult(MyShapeType type) {
        MyShape myShape = null;

        if (type == MyShapeType.MY_CIRCLE) {
            myShape = new MyCircle(x, y, radius, color);
        } else if (type == MyShapeType.MY_RECTANGLE) {
            myShape = new MyRectangle(x, y, width, height, color);
        } else if (type == MyShapeType.MY_TRIANGLE) {
            myShape = new MyTriangle(x, y, color);
        }

        return myShape;
    }
}
