package view;

import shapes.*;

// Реализация паттерна "Фабричный метод"
public class ShapeOptionsPanelFactory  {
    public ShapeOptionsPanel createShapeOptionsPanel(MyShapeType type, int width, int height, MyCircle myCircle, MyTriangle myTriangle, MyRectangle myRectangle) {
        ShapeOptionsPanel shapeOptionsPanel = null;

        switch (type) {
            case MY_CIRCLE:
                shapeOptionsPanel = new CircleOptionsPanel(width, height, myCircle);
                break;
            case MY_TRIANGLE:
                shapeOptionsPanel = new TriangleOptionsPanel(width, height, myTriangle);
                break;
            case MY_RECTANGLE:
                shapeOptionsPanel = new RectangleOptionsPanel(width, height, myRectangle);
                break;
        }

        return shapeOptionsPanel;
    }
}
