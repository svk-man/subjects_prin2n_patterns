package model;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class AppModel {

    private ArrayList<Shape> shapes;

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public AppModel() {

    }

    public void start() {
        generateShapes();
    }

    private void generateShapes() {
        shapes = new ArrayList<Shape>();
        shapes.add(new Circle(0, 0, 100, "black"));
        shapes.add(new Rectangle(0, 0, 100, 50, "black"));
    }
}
