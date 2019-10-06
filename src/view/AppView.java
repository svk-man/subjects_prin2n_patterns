package view;

import model.AppModel;
import shapes.Circle;
import shapes.Shape;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AppView extends JFrame {

    private final int WIDTH = 720;
    private final int HEIGHT = 400;

    private JToolBar shapesToolBar = new JToolBar();
    private JPanel shapeDrawPanel = new JPanel();
    private JPanel shapeOptionsPanel = new JPanel();

    private AppModel appModel = new AppModel();

    public AppView(int width, int height) {
        super();

        appModel.start();

        // Предварительные настройки
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);

        this.setTitle("Shapes Application");

        Box mainBox = Box.createVerticalBox();

        // Панель фигур
        createShapesPanel();
        shapesToolBar.setAlignmentX(JToolBar.LEFT_ALIGNMENT);
        mainBox.add(shapesToolBar);

        // Информационная панель фигуры
        Box innerBox = Box.createHorizontalBox();
        createShapeDrawPanel();
        createShapeOptionsPanel();
        innerBox.add(shapeDrawPanel);
        innerBox.add(shapeOptionsPanel);
        mainBox.add(innerBox);

        setContentPane(mainBox);
        pack();
        setResizable(false);
    }

    private void createShapesPanel() {
        int borderSize = 2;
        shapesToolBar.add(Box.createHorizontalStrut(10));

        ArrayList<Shape> shapesList = appModel.getShapes();
        for(Shape shapeItem : shapesList) {
            JButton buttonShape = new JButton(new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    shapeItem.drawIcon(g, getIconWidth() + borderSize, getIconHeight() + borderSize);
                }

                @Override
                public int getIconWidth() {
                    return 50;
                }

                @Override
                public int getIconHeight() {
                    return 50;
                }
            });

            buttonShape.setBorder(BorderFactory.createLineBorder(Color.BLUE, borderSize));
            //buttonShape.setHorizontalAlignment(JButton.CENTER);
            //buttonShape.setVerticalAlignment(JButton.CENTER);
            buttonShape.setFocusPainted(true);
            buttonShape.setContentAreaFilled(false);
            buttonShape.setMargin(new Insets(0, 0, 0, 0));

            buttonShape.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.print(e);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    buttonShape.setForeground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    buttonShape.setForeground(Color.getColor(shapeItem.getColor()));
                }
            });

            shapesToolBar.add(buttonShape);
            shapesToolBar.addSeparator();
        }
    }

    private void createShapeDrawPanel() {
        shapeDrawPanel = new CircleDrawPanel(WIDTH / 2, HEIGHT);
        ((CircleDrawPanel) shapeDrawPanel).setCircle(new Circle(shapeDrawPanel.getWidth() / 2, shapeDrawPanel.getHeight() / 2, 50, "red"));
        shapeDrawPanel.setBorder(new LineBorder(Color.black));
    }

    private void createShapeOptionsPanel() {
        shapeOptionsPanel = new CircleOptionsPanel(WIDTH / 2, HEIGHT);
        ((CircleDrawPanel) shapeDrawPanel).setCircle(new Circle(shapeDrawPanel.getWidth() / 2, shapeDrawPanel.getHeight() / 2, 50, "red"));
    }

    /*private int width;
    private int height;

    public AppView(int width, int height) {
        this.width = width;
        this.height = height;
    }*/

    /*public void generate() {

        JFrame myWindow = new JFrame("Пробное окно");


        // Панель инструментов


        // Отрисовка овала
        JPanel panelCanvas = new JPanel();
        panelCanvas.add(new OvalComponent());
        myWindow.add(panelCanvas, "West");
    }

    class OvalComponent extends JComponent  {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // int top = (getHeight() - ovalHeight) / 2;

            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(Color.GREEN);
            //g2d.drawOval(10,10,100,100);//I like fill :P
            g2d.fillOval(10,10,100,100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }
    }*/
}
