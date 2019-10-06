package view;

import javax.swing.*;
import java.awt.*;

public class ShapeOptionsPanel extends JPanel {
    private int width;
    private int height;
    private JTable table = new JTable();

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public ShapeOptionsPanel(int width, int height) {
        super();
        this.width = width;
        this.height = height;

        Dimension shapeDrawDimension = new Dimension(width, height);
        this.setPreferredSize(shapeDrawDimension);
        this.setMinimumSize(shapeDrawDimension);
        this.setMaximumSize(shapeDrawDimension);
    }
}
