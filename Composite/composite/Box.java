package composite;

import java.util.ArrayList;

public class Box extends CompositeShape {

    public Box(ArrayList<Float> points) {
        super(points);
    }

    @Override
    public void buildShape(ArrayList<Float> points) {
        ArrayList<Float> list = new ArrayList<>();
        list.add(points.get(0));
        list.add(points.get(1));
        list.add(points.get(0));
        list.add(points.get(3));
        shapes.add(new Line(list));
        list.set(2, points.get(2));
        list.set(3, points.get(1));
        shapes.add(new Line(list));
        list.set(0, points.get(2));
        list.set(1, points.get(3));
        shapes.add(new Line(list));
        list.set(2, points.get(0));
        list.set(3, points.get(3));
        shapes.add(new Line(list));
    }
}
