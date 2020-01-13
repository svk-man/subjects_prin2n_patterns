package builders;


import java.awt.*;

// Реализация паттерна "Строитель"
/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации
 * продукта.
 */
public interface Builder {
    void setX(int x);
    void setY(int y);
    void setColor(Color color);
    void setRadius(int radius);
    void setWidth(int width);
    void setHeight(int height);
}
