package view;

import shapes.*;

import javax.swing.*;
import java.awt.*;

public class ShapeIcon implements Icon {

    private MyShape shape;

    public ShapeIcon(MyShape shape) {
        this.shape = shape;
    }

    public MyShape getShape() {
        return shape;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        
       int width = getIconWidth() - x;
       int height = getIconHeight() - y;

        if(!(shape instanceof MyCompoundShape)) {
            shape.setX(width / 2 + x);
            shape.setY(height / 2 + y);
        }

        if(shape instanceof MyCircle) {

            MyCircle circle = (MyCircle) shape;
            circle.setRadius( Math.min( width, height ) );
            shape.draw(g);

        } else if(shape instanceof MyRectangle) {

            MyRectangle rect = (MyRectangle) shape;
            rect.setHeight( height );
            rect.setWidth( width );
            shape.draw(g);
        } else if(shape instanceof MyTriangle) {
            g.drawString("T", getIconWidth()/2-2, getIconHeight()/2+8);
        } else if(shape instanceof MyCompoundShape) {
            g.drawString("C", getIconWidth()/2-2, getIconHeight()/2+8);
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
