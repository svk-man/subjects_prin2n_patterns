package view;

import shapes.Circle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class CircleOptionsPanel extends ShapeOptionsPanel {

    private Circle circle;

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public CircleOptionsPanel(int width, int height) {
        super(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (circle != null) {
            String[] tableHeaders = {"Свойство", "Значение"};
            String[][] tableValues = {{"Радиус", String.valueOf(circle.getRadius())}};

            JTable table = getTable();
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn(tableHeaders);
            tableModel.addRow(tableValues);
            table.setModel(tableModel);
            setTable(table);
        }
    }
}
