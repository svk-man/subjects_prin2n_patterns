package view;

import shapes.MyCircle;
import shapes.MyShape;

import java.awt.*;

public class CircleDrawPanel extends ShapeDrawPanel {

    private MyCircle circle;

    public void setCircle(MyCircle circle) {
        this.circle = circle;
    }

    public CircleDrawPanel(int width, int height) {
        super(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (circle != null) {
            int radius = circle.getRadius();
            Dimension dimension = getPreferredSize();
            g.fillOval((int)(dimension.getWidth() / 2 + circle.getX() - (radius / 2)), (int)(dimension.getHeight()/ 2 + circle.getY() - (radius / 2)), radius, radius);
        }
    }
}
