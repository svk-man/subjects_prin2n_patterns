/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import shapes.MyRectangle;


public class RectangleOptionsPanel extends ShapeOptionsPanel {

    SpinnerModel widthRange;
    SpinnerModel heightRange;

    public MyRectangle getShape() {
        return (MyRectangle)super.getShape();
    }

    public RectangleOptionsPanel(int width, int height, MyRectangle rect) {
        super(width, height, rect);
        
        Box topBox = Box.createVerticalBox();
        
        Box widthBox = Box.createHorizontalBox();
        
        widthBox.add( new JLabel("Ширина    ") );
        
        widthRange = new SpinnerNumberModel(getShape().getWidth(), 20, 300, 3);
        widthRange.addChangeListener( new WidthController() );
        widthBox.add( new JSpinner(widthRange) );

        topBox.add( widthBox  );
        
        
        Box heightBox = Box.createHorizontalBox();
        
        heightBox.add( new JLabel("Высота    ") );
        
        heightRange = new SpinnerNumberModel(getShape().getHeight(), 20, 300, 3);
        heightRange.addChangeListener( new HeightController() );
        heightBox.add( new JSpinner(heightRange) );

        topBox.add( heightBox );
        
        add(topBox);
    }
    
    
    private class WidthController implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            getShape().setWidth( (Integer) widthRange.getValue() );
        }        
    }
    
    private class HeightController implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            getShape().setHeight( (Integer) heightRange.getValue() );
        }        
    }    
}
