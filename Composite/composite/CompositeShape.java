package composite;

import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.ArrayList;

public abstract class CompositeShape implements Shape {
    ArrayList<Shape> shapes = new ArrayList<>();

    public CompositeShape(ArrayList<Float> points)
    {
        buildShape(points);
    }

    public void draw(ObservableList<Node> children)
    {
        for (Shape shape: shapes)
        {
            shape.draw(children);
        }
    }

    public abstract void buildShape(ArrayList<Float> points);
}
