package shapes;

import java.awt.*;

public class MyRectangle extends MyAbstractPolygon {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;        
        rebuildVertexesInLocalCoordinates();
        
        fireStateChanged();
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;        
        rebuildVertexesInLocalCoordinates();
        
        fireStateChanged();
    }

    
    public MyRectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
        
        rebuildVertexesInLocalCoordinates();        
    }
    
    private void rebuildVertexesInLocalCoordinates() {
        removeAllVertexes();
        
        addVertex(0, 0);
        addVertex(0, height);
        addVertex(width, height);
        addVertex(width, 0);
    }

//    @Override
//    public void draw(Graphics g) {
//        g.setColor( getColor() );
//        g.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
//    }

    @Override
    public void rotateClockwise() {
        super.rotateClockwise();
        
        int buffer = width;
        width = height;
        height = buffer;
    }

    // Реализация паттерна "Прототип". Шаг 3. Реализуем в каждом классе метод copy
    public MyShape copy() {
        return new MyRectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight(), this.getColor());
    }
}
