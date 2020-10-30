package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Herrialde;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class HerrAukKud {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Herrialde> comboBoxId;

    @FXML
    private Button botoiaId;

    private EzarpenakDBKud ezkud = EzarpenakDBKud.getInstantzia();

    private List<Herrialde> parteHartu;

    private ObservableList<Herrialde> obsHerrialde =

    @FXML
    void aukeratu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        parteHartu = ezkud.lortuEzarpenak();

    }
}
