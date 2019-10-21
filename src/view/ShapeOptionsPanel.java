package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import shapes.MyShape;

public class ShapeOptionsPanel extends JPanel {

    private MyShape shape;
    
    public MyShape getShape() {
        return shape;
    }
    
    public ShapeOptionsPanel(int width, int height, MyShape shape) {
        super();

        this.shape = shape;
        
        Dimension panelDimension = new Dimension(width, height);
        setPreferredSize(panelDimension);
        setMinimumSize(panelDimension);
        setMaximumSize(panelDimension);
        
        setBorder(new LineBorder(Color.MAGENTA)); 
    }
}
