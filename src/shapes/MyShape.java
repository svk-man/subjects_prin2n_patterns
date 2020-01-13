package shapes;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class MyShape implements Cloneable { // Реализация паттерна "Прототип". Шаг 1. Реализуем интерфейс Cloneable

    private int x;
    private int y;
    private Color color;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
        fireStateChanged();
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
        fireStateChanged();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {this.color = color;}

    public MyShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public abstract void  rotateClockwise();

    // -------------------------------------------------------------------
    private ArrayList<ChangeListener> listners = new ArrayList<>();

    public void addListner(ChangeListener listner) {
        listners.add(listner);
    }

    protected void fireStateChanged() {
        for( ChangeListener listner : listners ) {
            listner.stateChanged( new ChangeEvent(this));
        }
    }

    // Реализация паттерна "Прототип". Шаг 2. Создаем абстрактный метод copy
    public abstract MyShape copy();
}
