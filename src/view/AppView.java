package view;

import shapes.MyCircle;
import shapes.MyRectangle;
import shapes.MyShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import shapes.MyTriangle;

public class AppView extends JFrame {

    private final int TOOL_BUTTON_SIZE = 25; 
    private final int DRAW_PANEL_WIDTH = 350;
    private final int OPTIONS_PANEL_WIDTH = 200;
    private final int PANEL_HEIGHT = 400;
    
    private ShapeDrawPanel shapeDrawPanel;
    private ShapeOptionsPanel shapeOptionsPanel;

    public AppView() {
        super();

        // Настройки окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Примитивы");

        // Создаем топ-контейнер
        Box mainBox = Box.createVerticalBox();

        // Создаем панель инструментов с доступными примитивами
        mainBox.add(createShapesToolBar());

        // Создаем панели для отображения примитива и настроек примитива
        Box innerBox = Box.createHorizontalBox();
        innerBox.setAlignmentX(LEFT_ALIGNMENT);
        shapeDrawPanel = new ShapeDrawPanel( DRAW_PANEL_WIDTH, PANEL_HEIGHT );
        innerBox.add(shapeDrawPanel);
        shapeOptionsPanel = new ShapeOptionsPanel( OPTIONS_PANEL_WIDTH, PANEL_HEIGHT, null );
        innerBox.add(shapeOptionsPanel);

        mainBox.add(innerBox);

        // Подстраиваем размеры и фиксируем их
        setContentPane(mainBox);
        pack();
        setResizable(false);
    }

    private JToolBar createShapesToolBar() {

        JToolBar shapesToolBar = new JToolBar();
        shapesToolBar.setAlignmentX(LEFT_ALIGNMENT);

        final int BORDER_SIZE = 2;        
        
        int centerX = TOOL_BUTTON_SIZE + BORDER_SIZE;
        int centerY = TOOL_BUTTON_SIZE + BORDER_SIZE;
        shapesToolBar.setFloatable(false);
        shapesToolBar.add(Box.createHorizontalStrut(10));

        // Список доступных примитивов
        ArrayList<MyShape> shapesList = new ArrayList<>();
        shapesList.add(new MyCircle(centerX, centerY, TOOL_BUTTON_SIZE, Color.BLACK));
        shapesList.add(new MyRectangle(centerX, centerY, TOOL_BUTTON_SIZE, TOOL_BUTTON_SIZE, Color.BLACK));
        shapesList.add(new MyTriangle(centerX, centerY, Color.BLACK));

        CreateShapeContoller createController = new CreateShapeContoller();
        
        for (MyShape shapeItem : shapesList) {

            JButton buttonShape = new JButton(new ShapeIcon(shapeItem));

            buttonShape.setFocusPainted(true);
            buttonShape.setContentAreaFilled(false);
            buttonShape.setMargin(new Insets(0, 0, 0, 0));

            buttonShape.addMouseListener( createController );

            shapesToolBar.add(buttonShape);
        }

        return shapesToolBar;
    }

    private void setShapeOptionsPanel(ShapeOptionsPanel optionsPanel) {

        Container parent = shapeOptionsPanel.getParent();
        parent.remove(shapeOptionsPanel);
        parent.add(optionsPanel);
        shapeOptionsPanel = optionsPanel;
        pack();
    }
    
    private static MyShape extractShape(JButton btn) {
        ShapeIcon shapeIcon = (ShapeIcon) btn.getIcon();
        return shapeIcon.getShape();        
    } 

    private class CreateShapeContoller extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            // Извлекаем примитив из кнопки инструментов
            MyShape shape = extractShape ( (JButton) e.getComponent() );

            if (shape instanceof MyCircle) { // окружность

                // Создаем отображаемый примитив и помещаем в панель для отображения
                MyCircle newCircle = new MyCircle(0, 0, 100, Color.GREEN);
                shapeDrawPanel.setShape(newCircle);
  
                // Создаем панель для изменения параметров примитива
                CircleOptionsPanel optionsPanel = new CircleOptionsPanel( OPTIONS_PANEL_WIDTH, PANEL_HEIGHT, newCircle );
                setShapeOptionsPanel(optionsPanel);
            
            } else if(shape instanceof MyRectangle) { // прямоугольник
                
                // Создаем отображаемый примитив и помещаем в панель для отображения
                MyRectangle newRectangle = new MyRectangle(0, 0, 100, 100, Color.BLUE);
                shapeDrawPanel.setShape(newRectangle);
  
                // Создаем панель для изменения параметров примитива
                RectangleOptionsPanel optionsPanel = new RectangleOptionsPanel( OPTIONS_PANEL_WIDTH, PANEL_HEIGHT, newRectangle );
                setShapeOptionsPanel(optionsPanel);
            } else if(shape instanceof MyTriangle) { // треугольник
                
                // Создаем отображаемый примитив и помещаем в панель для отображения
                MyTriangle newTriangle = new MyTriangle(0, 0, Color.YELLOW);
                shapeDrawPanel.setShape(newTriangle);
  
                // Создаем панель для изменения параметров примитива
                TriangleOptionsPanel optionsPanel = new TriangleOptionsPanel( OPTIONS_PANEL_WIDTH, PANEL_HEIGHT, newTriangle );
                setShapeOptionsPanel(optionsPanel);
            }
        }
    }    
}
