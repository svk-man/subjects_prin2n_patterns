import javax.swing.*;
import java.awt.*;

public class ApplicationGUI {

    private int width;
    private int height;

    public ApplicationGUI(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generate() {

        JFrame myWindow = new JFrame("Пробное окно");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(this.width, this.height);
        myWindow.setVisible(true);

        // Панель инструментов
        JToolBar toolBar = new JToolBar();
        JButton buttonCircle = new JButton(Utils.resizeImageIcon(new ImageIcon("images/circle.png"), 48, 48));
        JButton buttonRectangle = new JButton(Utils.resizeImageIcon(new ImageIcon("images/rectangle.png"), 48, 48));
        toolBar.add(buttonCircle);
        toolBar.add(buttonRectangle);
        myWindow.getContentPane().add(toolBar, "North");
    }
}
