package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.model.Herrialde;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class BozDuKud {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bueltatuId;

    @FXML
    private ImageView irudiaId;

    @FXML
    private Label labelId;

    private Main main;
    private Herrialde herri;

    @FXML
    void bueltatu(ActionEvent event) { //Jadanik bozkatu duenez top 3-ra joango da
        main.topErakutsi(herri);
    }

    public void setMainApp(Main m){main = m;}

    public void hasieratu(Herrialde h){
        labelId.setText(h.getName()+" jada banatu ditu bere puntuak");
    }
}
