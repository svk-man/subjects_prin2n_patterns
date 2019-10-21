
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class MyAbstractPolygon extends MyShape {

    private List<Point2D> vertexesInLocalCoordinates = new ArrayList<>();
    
    protected boolean addVertex(int x, int y) {
        
        // TODO: нужно проверять пересечение сторон 
        // + чтобы 2 вершины не лежали на одной прямой,
        // + чтобы 2 вершины не совпадали,
        // но что-то некогда
        
        vertexesInLocalCoordinates.add( new Point(x, y) );        
        
        return true;
    }
    
    protected void removeAllVertexes() {
        vertexesInLocalCoordinates.clear();
    }    
    
    public int vertexCount() {
        return vertexesInLocalCoordinates.size();
    } 
    
    public Point2D vertex( int index ) {
        
        Point2D  vertexInLocalCoordinates = vertexesInLocalCoordinates.get(index);

        Point2D weightCenter = weightCenterInLocalCoordinates();
        
        return new Point( (int)vertexInLocalCoordinates.getX() - (int)weightCenter.getX() +  getX(),
                          (int)vertexInLocalCoordinates.getY() + - (int)weightCenter.getY() + getY());
    }
    
    protected Point2D weightCenterInLocalCoordinates() {
        
        double weightCenterX = 0;
        double weightCenterY = 0 ;
        
        for( Point2D vertex : vertexesInLocalCoordinates ) {
            weightCenterX += vertex.getX();
            weightCenterY += vertex.getY();
        }        
        
        weightCenterX /= vertexCount();
        weightCenterY /= vertexCount();
        
        return new Point((int)weightCenterX, (int)weightCenterY);
    }    
    
    public MyAbstractPolygon(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor( getColor() );
        
        Polygon p = new Polygon();
        for( int i=0; i < vertexCount(); i++ ) {
            
            Point2D vertex = vertex(i);      
            p.addPoint( (int)vertex.getX(), (int)vertex.getY());
        }
        
        g.fillPolygon(p);
    }   

    @Override
    public void rotateClockwise() {

        for( Point2D vertex : vertexesInLocalCoordinates ) {

            double newX = getX() - (vertex.getY() - getY());
            double newY = getY() + (vertex.getX() - getX());
            vertex.setLocation(newX, newY);
        }  
        
        fireStateChanged();
    }
}
