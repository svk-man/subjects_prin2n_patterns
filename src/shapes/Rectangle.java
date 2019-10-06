package shapes;

import java.awt.*;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle(int x, int y, int width, int height, String color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        if (rectangle != null) {
            this.width = rectangle.width;
            this.height = rectangle.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.getColor(getColor()));
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void drawIcon(Graphics g, int width, int height) {
        g.setColor(Color.getColor(getColor()));
        g.fillRect(0, 0, width, height);
        g.dispose();
    }
}
