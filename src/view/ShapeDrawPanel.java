package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import shapes.MyShape;

public class ShapeDrawPanel extends JPanel {

    private MyShape shape;
    ChangedShapeStateController changeControoler = new ChangedShapeStateController();

    public void setShape(MyShape shape) {
        this.shape = shape;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        this.shape.setX(centerX);
        this.shape.setY(centerY);

        this.shape.addListner(changeControoler);

        repaint();
    }

    public ShapeDrawPanel(int width, int height) {
        super();

        Dimension shapeDrawDimension = new Dimension(width, height);
        setPreferredSize(shapeDrawDimension);
        setMinimumSize(shapeDrawDimension);
        setMaximumSize(shapeDrawDimension);

        setBorder(new LineBorder(Color.black));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (shape != null) {

            shape.draw(g);
        }
    }

    private class ChangedShapeStateController implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            repaint();
        }
    }
}
