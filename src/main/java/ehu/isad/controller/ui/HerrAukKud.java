package ehu.isad.controller.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Ezarpena;
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

    private ObservableList<Herrialde> obsHerrialde ;

    private Main main;

    @FXML
    void aukeratu(ActionEvent event) throws SQLException {
        Herrialde h = comboBoxId.getValue();
        if(ezkud.bozkatuDu(h)){ //Herrialdeak jadanik bozkatu badu
            main.bozkatuDuErakutsi(h);
        }
        else{ //Herrialdea oraindik ez du bozkatu
            h.bozkatu();
            main.bozTaulaErakutsi(h);
        }
    }

    public void setMainApp(Main m){ main = m;}


    public void hasi(){
       parteHartu = ezkud.lortuEzarpenak();
       obsHerrialde.addAll(parteHartu);
       comboBoxId.setItems(obsHerrialde);
    }
}
