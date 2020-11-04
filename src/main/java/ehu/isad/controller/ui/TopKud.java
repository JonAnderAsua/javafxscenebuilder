package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class TopKud {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageId;

    @FXML
    private TableView<?> tableId;

    @FXML
    private Button bukatuId;
    private Main main;

    @FXML
    void bukatu(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {

    }

    public void setMainApp(Main m) {
        this.main = m;
    }
}
