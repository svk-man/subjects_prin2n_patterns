import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private ApplicationGUI gui;

    private List<Shape> shapes;

    public void start() {
        this.shapes = generateShapes();

        gui = new ApplicationGUI(300, 200);
        gui.generate();
    }

    private List<Shape> generateShapes() {
        List<Shape> shapes = new ArrayList<>();

        // Окружность
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        // Прямоугольник
        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.width = 200;
        rectangle.height = 100;
        rectangle.color = "green";
        shapes.add(rectangle);

        return shapes;
    }

}
