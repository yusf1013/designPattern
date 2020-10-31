package sample;

import composite.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {
    @FXML
    VBox sideVBox;
    @FXML
    TextArea details;
    @FXML
    Button add;
    @FXML
    ComboBox<String> combo;
    @FXML
    AnchorPane graph;

    Map<String, String> map = new TreeMap<>();
    int counter = 0;
    ArrayList<Shape> shapes = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(e->{
            Label label = new Label(++counter + ".\t" + combo.getValue());
            label.setPadding(new Insets(5, 0, 5, 10));
            label.setStyle("");
            label.setFont(new Font(14));
            sideVBox.getChildren().add(label);
            drawShapes(parseText(), combo.getValue());
            drawGraph();
        });
        initializeMap();
        initializeCombo();
    }

    public void drawShapes(ArrayList<Float> floats, String value)
    {
        if(value.equals("Line"))
        {
            shapes.add(new Line(floats));
        }
        if(value.equals("Circle"))
        {
            shapes.add(new Circle(floats));
        }
        if(value.equals("Triangle"))
        {
            shapes.add(new Triangle(floats));
        }
        if(value.equals("Box"))
        {
            shapes.add(new Box(floats));
        }
        if(value.equals("Flag"))
        {
            shapes.add(new Flag(floats));
        }
    }

    public ArrayList<Float> parseText()
    {
        ArrayList<Float> floats = new ArrayList<>();
        String regex="[0-9]*\\.?[0-9]+";
        String input= details.getText();

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);

        while(matcher.find())
        {
            floats.add(Float.parseFloat(matcher.group()));
        }

        for(int i=0; i<floats.size(); i++)
        {
            if(i%2==0)
                floats.set(i, (float) (floats.get(i)*25.8));
            else
                floats.set(i, (float) (542 + floats.get(i)*-25.8095238));
        }

        return floats;
    }



    public void drawGraph()
    {
        graph.getChildren().clear();
        for(Shape shape: shapes)
        {
            shape.draw(graph.getChildren());
        }
    }

    public void initializeCombo()
    {
        String [] shapes = {"Line", "Circle", "Box", "Triangle", "Flag"};
        combo.setItems(FXCollections.observableArrayList(shapes));
        combo.getSelectionModel().selectFirst();
        setPromptText();
        combo.setOnAction(e->{
            setPromptText();
        });
    }

    public void initializeMap()
    {
        map.put("Line", "(x= , y= )     (x= , y= )");
        map.put("Circle", "(x= , y= )     (r= )");
        map.put("Box", "(x= , y= )     (x= , y= )");
        map.put("Triangle", "(x= , y= )     (x= , y= ,)\n(x= , y= )");
        map.put("Flag", "(x= , y= )     (x= , y= )\n(x= , y= )     (r= )");
    }

    public void setPromptText()
    {
        String selected = combo.getValue();
        details.setText(map.get(selected));
    }
}
