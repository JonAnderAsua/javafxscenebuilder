package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.model.Herrialde;
import ehu.isad.utils.Irudia;
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

    @FXML
    void bueltatu(ActionEvent event) {
        //Top 3ra bidali
   }

    public void setMainApp(Main m){main = m;}

    public void hasieratu(Herrialde h){
        irudiaId.setImage(Irudia.getInstantzia().irudiaKargatu(h.getName()));
        labelId.setText(h.getName()+" jada banatu ditu bere puntuak");
    }
}
