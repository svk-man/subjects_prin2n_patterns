package view;

import shapes.Circle;

import javax.swing.*;
import java.awt.*;

public class CircleDrawPanel extends ShapeDrawPanel {

    private Circle circle;

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public CircleDrawPanel(int width, int height) {
        super(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (circle != null) {
            //g.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
        }
    }
}
