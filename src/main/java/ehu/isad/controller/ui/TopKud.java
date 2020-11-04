package ehu.isad.controller.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Herrialde;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TopKud {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageId;

    @FXML
    private TableView<Herrialde> tableId;

    @FXML
    private TableColumn<Herrialde, Image> banderaId;

    @FXML
    private TableColumn<Herrialde, String> herrialdeaId;

    @FXML
    private TableColumn<Herrialde, Integer> puntuakId;

    @FXML
    private Button bukatuId;
    private Main main;
    private EzarpenakDBKud ezar = EzarpenakDBKud.getInstantzia();
    private List<Herrialde> herriList = new ArrayList<>();
    private ObservableList<Herrialde> hLista;

    @FXML
    void bukatu(ActionEvent event) {
        System.exit(0);
    }


    public void setMainApp(Main m) {
        this.main = m;
    }

    public void erakutsi() throws SQLException {
        herriList = ezar.topLortu();
        herrialdeaId.setCellValueFactory(new PropertyValueFactory<>("izena"));
        puntuakId.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
        banderaId.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("irudia"));
    }
}
