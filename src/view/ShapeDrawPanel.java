package view;

import javax.swing.*;
import java.awt.*;

public class ShapeDrawPanel extends JPanel {

    private int width;
    private int height;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public ShapeDrawPanel(int width, int height) {
        super();
        this.width = width;
        this.height = height;

        Dimension shapeDrawDimension = new Dimension(width, height);
        setPreferredSize(shapeDrawDimension);
        setMinimumSize(shapeDrawDimension);
        setMaximumSize(shapeDrawDimension);
    }
}
