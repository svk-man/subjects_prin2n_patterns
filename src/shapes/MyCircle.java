package shapes;

import java.awt.*;

public class MyCircle extends MyShape {

    private int radius;

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) { 
        this.radius = radius; 
        fireStateChanged();
    }

   
    public MyCircle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor( getColor() );
        g.fillOval(getX() - ( getRadius() / 2), getY() - ( getRadius() / 2), getRadius(), getRadius() );
    }

    @Override
    public void rotateClockwise() {
    }

    public void scale(int size) {
        this.radius = radius + size;
        fireStateChanged();
    }

    // Реализация паттерна "Прототип". Шаг 3. Реализуем в каждом классе метод copy
    public MyShape copy() {
        return new MyCircle(this.getX(), this.getY(), this.getRadius(), this.getColor());
    }
}
