package shapes;

import java.awt.*;

public class Circle extends Shape {

    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(int x, int y, int radius, String color) {
        super(x, y, color);
        this.radius = radius;
    }

//    @Override
//    public Shape clone() {
//        return new Circle(this);
//    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.getColor(getColor()));
        g.fillOval(getX() - (radius / 2), getY() - (radius / 2), radius, radius);
    }
}
