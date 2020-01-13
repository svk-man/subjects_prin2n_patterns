package shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCompoundShape extends MyShape {
    protected List<MyShape> children = new ArrayList<>();

    public MyCompoundShape(MyShape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(MyShape component) {
        children.add(component);
    }

    public void add(MyShape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(MyShape child) {
        children.remove(child);
    }

    public void remove(MyShape... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.size() == 0) {
            return 0;
        }
        int x = children.get(0).getX();
        for (MyShape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (children.size() == 0) {
            return 0;
        }
        int y = children.get(0).getY();
        for (MyShape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public void setColor(Color color) {
        if (children.size() != 0) {
            for (MyShape child : children) {
                child.setColor(color);
            }
        }
    }

    @Override
    public void setX(int x) {
        if (children.size() != 0) {
            for (MyShape child : children) {
                child.setX(x + child.getX());
            }
        }
    }

    @Override
    public void setY(int y) {
        if (children.size() != 0) {
            for (MyShape child : children) {
                child.setY(y + child.getY());
            }
        }
    }

    public void setRadius(int radius) {
        if (children.size() != 0) {
            for (MyShape child : children) {
                if (child instanceof MyCircle) {
                    ((MyCircle) child).setRadius(radius);
                }
            }
        }
    }

//    @Override
//    public int getWidth() {
//        int maxWidth = 0;
//        int x = getX();
//        for (MyShape child : children) {
//            int childsRelativeX = child.getX() - x;
//            int childWidth = childsRelativeX + child.getWidth();
//            if (childWidth > maxWidth) {
//                maxWidth = childWidth;
//            }
//        }
//        return maxWidth;
//    }

//    @Override
//    public int getHeight() {
//        int maxHeight = 0;
//        int y = getY();
//        for (MyShape child : children) {
//            int childsRelativeY = child.getY() - y;
//            int childHeight = childsRelativeY + child.getHeight();
//            if (childHeight > maxHeight) {
//                maxHeight = childHeight;
//            }
//        }
//        return maxHeight;
//    }

//    @Override
//    public void move(int x, int y) {
//        for (MyShape child : children) {
//            child.move(x, y);
//        }
//    }

//    @Override
//    public boolean isInsideBounds(int x, int y) {
//        for (MyShape child : children) {
//            if (child.isInsideBounds(x, y)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    @Override
//    public void unSelect() {
//        super.unSelect();
//        for (MyShape child : children) {
//            child.unSelect();
//        }
//    }

//    public boolean selectChildAt(int x, int y) {
//        for (MyShape child : children) {
//            if (child.isInsideBounds(x, y)) {
//                child.select();
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public void draw(Graphics graphics) {
        for (MyShape child : children) {
            child.draw(graphics);
        }
    }

    @Override
    public void rotateClockwise() {

    }

    @Override
    public MyShape copy() {
        MyCompoundShape tmpCompoundShape = new MyCompoundShape();
        for (MyShape child : children) {
            tmpCompoundShape.add(child);
        }

        return tmpCompoundShape;
    }
}
