package composite;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Circle implements Shape {

    private Float x, y, r;

    public Circle(ArrayList<Float> floats) {
        this.x = floats.get(0);
        this.y = floats.get(1);
        this.r = floats.get(2);
    }

    @Override
    public void draw(ObservableList<Node> children) {
        javafx.scene.shape.Circle c = new javafx.scene.shape.Circle(r);
        c.setCenterX(x);
        c.setCenterY(y);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        children.add(c);
    }
}
