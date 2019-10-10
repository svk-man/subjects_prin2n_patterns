package view;

import shapes.Circle;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class ShapeIcon implements Icon {

    private String type;
    private Circle circle;
    private shapes.Rectangle rectangle;

    public ShapeIcon(String type, Shape shape) {
        this.type = type;
        switch (this.type) {
            case "Circle":
                this.circle = (Circle) shape;
                break;
            case "Rectangle":
                this.rectangle = (shapes.Rectangle) shape;
                break;
        }
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        switch (this.type) {
            case "Circle":
                circle.draw(g);
                break;
            case "Rectangle":
                rectangle.draw(g);
                break;
        }
    }

    @Override
    public int getIconWidth() {
        return 50;
    }

    @Override
    public int getIconHeight() {
        return 50;
    }
}
