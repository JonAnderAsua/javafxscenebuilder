package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class BozTaulaKud {

    @FXML
    private TableView<?> tableId;

    @FXML
    private Label labelId;

    @FXML
    private Button botoiaId;

    private Main main;

    @FXML
    void bozkatu(ActionEvent event) {
        //Action honek Top3 ra bidaliko du
    }

    public void setMainApp(Main m) {
        main = m;
    }

    //listern metodoak jarri behar dira
}