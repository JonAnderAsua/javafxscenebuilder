package ehu.isad.controller.ui;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HasieraKud {

    @FXML
    private ImageView imageId;

    @FXML
    private Button hasiID;

    private Main main;

    @FXML
    void hasi(ActionEvent event) {
        main.herrialdeaAukeratu();
    }

    public void setMainApp(Main m){
        main = m;
    }

    @FXML
    void initialize() {

    }



}
