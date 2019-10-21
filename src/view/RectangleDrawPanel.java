package view;

import shapes.MyRectangle;

import java.awt.*;

public class RectangleDrawPanel extends ShapeDrawPanel {

    private MyRectangle rectangle;

    public void setRectangle(MyRectangle rectangle) {
        this.rectangle = rectangle;
    }

    public RectangleDrawPanel(int width, int height) {
        super(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rectangle != null) {
            Dimension dimension = getPreferredSize();
            g.fillRect((int)(dimension.getWidth() / 2 + rectangle.getX() - rectangle.getWidth() / 2), (int)(dimension.getHeight() / 2 + rectangle.getY() - rectangle.getHeight() / 2), rectangle.getWidth(), rectangle.getHeight());
        }
    }
}
