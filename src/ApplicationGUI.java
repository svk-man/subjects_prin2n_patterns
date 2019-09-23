import javax.swing.*;

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

    }
}
