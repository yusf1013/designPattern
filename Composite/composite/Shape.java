package composite;

import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.ArrayList;

public interface Shape {

    void draw(ObservableList<Node> children);

}
