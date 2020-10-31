package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    AnchorPane anchor;
    @FXML
    Button file, csv, json, xml;

    File txtFile;
    FileConverter converter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        csv.setDisable(true);
        json.setDisable(true);
        xml.setDisable(true);

        file.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("F:\\IIT\\Projects\\Java\\Strategy\\src\\res"));
            txtFile = fileChooser.showOpenDialog((Stage)file.getScene().getWindow());
            if(txtFile==null)
            {
                csv.setDisable(true);
                json.setDisable(true);
                xml.setDisable(true);
            }
            else
            {
                csv.setDisable(false);
                json.setDisable(false);
                xml.setDisable(false);
            }
        });

        csv.setOnAction(e->{
            converter =  new CSV();
            converter.convert(txtFile);
        });

        xml.setOnAction(e->{
            converter =  new XML();
            converter.convert(txtFile);
        });

        json.setOnAction(e->{
            converter =  new JSON();
            converter.convert(txtFile);

        });
    }
}
