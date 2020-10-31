package composite;

import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.ArrayList;

public class Line implements Shape {
    private Float x1, y1, x2, y2;

    public Line(ArrayList<Float> floats) {
        this.x1 = floats.get(0);
        this.y1 = floats.get(1);
        this.x2 = floats.get(2);
        this.y2 = floats.get(3);
    }

    @Override
    public void draw(ObservableList<Node> children) {
            children.add(new javafx.scene.shape.Line(x1, y1, x2, y2));
    }
}
