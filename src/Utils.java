import javax.swing.*;
import java.awt.*;

public class Utils {

    public static ImageIcon resizeImageIcon(ImageIcon imageIcon, int width, int height) {
        return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
    }
}
