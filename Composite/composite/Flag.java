package composite;

import java.util.ArrayList;

public class Flag extends CompositeShape {

    public Flag(ArrayList<Float> points) {
        super(points);
    }

    @Override
    public void buildShape(ArrayList<Float> points) {
        shapes.add(new Box(points));
        for(int i=0; i<4; i++)
            points.remove(0);
        shapes.add(new Circle(points));
    }
}
