package composite;

import java.util.ArrayList;

public class Triangle extends CompositeShape {

    public Triangle(ArrayList<Float> points) {
        super(points);
    }

    @Override
    public void buildShape(ArrayList<Float> points) {

        float x=points.get(0), y = points.get(1);

        shapes.add(new Line(points));
        points.remove(0);
        points.remove(0);
        shapes.add(new Line(points));
        points.remove(0);
        points.remove(0);
        points.add(x);
        points.add(y);
        shapes.add(new Line(points));
    }
}