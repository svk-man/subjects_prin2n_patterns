package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import shapes.MyCompoundShape;
import shapes.MyTriangle;

public class CompoundOptionsPanel extends ShapeOptionsPanel {


    public MyCompoundShape getShape() {
        return (MyCompoundShape) super.getShape();
    }

    public CompoundOptionsPanel(int width, int height, MyCompoundShape compoundShape) {
        super(width, height, compoundShape);

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