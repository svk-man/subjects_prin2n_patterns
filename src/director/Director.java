package director;

import builders.Builder;

import java.awt.*;

// Реализация паттерна "Строитель"
/**
 * Директор знает в какой последовательности заставлять работать строителя. Он
 * работает с ним через общий интерфейс Строителя. Из-за этого, он может не
 * знать какой конкретно продукт сейчас строится.
 */
public class Director {

    public void constructMyCircleShape(Builder builder) {
        builder.setX(27);
        builder.setY(27);
        builder.setColor(Color.BLACK);
        builder.setRadius(25);
        builder.setWidth(0);
        builder.setHeight(0);
    }

    public void constructMyTriangleShape(Builder builder) {
        builder.setX(27);
        builder.setY(27);
        builder.setColor(Color.BLACK);
        builder.setRadius(0);
        builder.setWidth(25);
        builder.setHeight(25);
    }

    public void constructMyRectangleShape(Builder builder) {
        builder.setX(27);
        builder.setY(27);
        builder.setColor(Color.BLACK);
        builder.setRadius(0);
        builder.setWidth(0);
        builder.setHeight(0);
    }
}
