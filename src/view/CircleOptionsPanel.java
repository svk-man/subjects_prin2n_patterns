package view;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import shapes.MyCircle;


public class CircleOptionsPanel extends ShapeOptionsPanel {

    SpinnerModel radiusRange;

    public MyCircle getShape() {
        return (MyCircle)super.getShape();
    }

    public CircleOptionsPanel(int width, int height, MyCircle circle) {
        super(width, height, circle);
        
        Box box = Box.createHorizontalBox();
        
        box.add( new JLabel("Радиус    ") );
        
        radiusRange = new SpinnerNumberModel(getShape().getRadius(), 20, 300, 3);
        radiusRange.addChangeListener( new RadiusController() );
        box.add( new JSpinner(radiusRange) );
        
        add(box);
    }
    
    
    private class RadiusController implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            getShape().setRadius( (Integer) radiusRange.getValue() );
        }        
    }
}
