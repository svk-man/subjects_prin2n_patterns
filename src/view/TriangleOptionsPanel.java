package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import shapes.MyTriangle;

public class TriangleOptionsPanel extends ShapeOptionsPanel {


    public MyTriangle getShape() {
        return (MyTriangle)super.getShape();
    }

    public TriangleOptionsPanel(int width, int height, MyTriangle triangle) {
        super(width, height, triangle);
        
        JButton btn = new JButton("Повернуть");
        btn.addActionListener( new RotateController() );
        
        add(btn);
    }    
    
    private class RotateController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           getShape().rotateClockwise();
        }
    }
}