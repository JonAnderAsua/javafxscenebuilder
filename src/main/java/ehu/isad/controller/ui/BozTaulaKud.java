package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.EzarpenakDBKud;
import ehu.isad.model.Herrialde;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.sql.SQLException;
import java.util.List;

public class BozTaulaKud {

    @FXML
    private TableView<Herrialde> tableId;

    @FXML
    private TableColumn<Herrialde, Image> banderaId;

    @FXML
    private TableColumn<Herrialde, String> izenaId;

    @FXML
    private TableColumn<Herrialde, String> artistaId;

    @FXML
    private TableColumn<Herrialde, String> abestiaId;

    @FXML
    private TableColumn<Herrialde, Integer> puntuakId;

    @FXML
    private Label labelId;

    @FXML
    private Button botoiaId;

    private Main main;

    private Herrialde herri;

    private List<Herrialde> herrialdeList = EzarpenakDBKud.getInstantzia().lortuEzarpenak();

    @FXML
    void bozkatu(ActionEvent event) throws SQLException {
        main.topErakutsi();
    }

    public void setMainApp(Main m) {
        main = m;
    }

    public void erakutsi() {

        //add your data to the table here.
        tableId.getItems().setAll(herrialdeList);

        tableId.setEditable(true);
        izenaId.setCellValueFactory(new PropertyValueFactory<>("izena"));
        artistaId.setCellValueFactory(new PropertyValueFactory<>("taldea"));
        abestiaId.setCellValueFactory(new PropertyValueFactory<>("abestia"));

        banderaId.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("irudia"));

        banderaId.setCellFactory(p -> new TableCell<>() {
                    public void updateItem(Image image, boolean empty) {
                        if (image != null && !empty){
                            final ImageView imageview = new ImageView();
                            imageview.setFitHeight(50);
                            imageview.setFitWidth(50);
                            imageview.setImage(image);
                            setGraphic(imageview);
                            setAlignment(Pos.CENTER);
                            //tbData.refresh();
                        }else{
                            setGraphic(null);
                            setText(null);
                        }
                    };
        });
        puntuakId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));



        Callback<TableColumn<Herrialde, String>, TableCell<Herrialde, String>> defaultTextFieldCellFactory = TextFieldTableCell.<Herrialde>forTableColumn();

        abestiaId.setCellFactory(col -> {
        TableCell<Herrialde, String> cell = defaultTextFieldCellFactory.call(col);

        cell.setOnMouseClicked(event -> { //Bozkatzen duen herrialdea bere burua ez bozkatzeko
            if (! cell.isEmpty()) {
                if (cell.getTableView().getSelectionModel().getSelectedItem().getName().equals(herri.getName())) {
                    cell.setEditable(false);
                }else {
                    cell.setEditable(true);
                }
            }
        });

        return cell ;
    });

/*
        abestiaId.setOnEditCommit(t -> {
            t.getTableView().getItems().get(t.getTablePosition().getRow()).gehituPuntuak(t.getNewValue());
        });

 */

       banderaId.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("image"));

       banderaId.setCellFactory(p -> new TableCell<>() {
        public void updateItem(Image image, boolean empty) {
            if (image != null && !empty){
                final ImageView imageview = new ImageView();
                imageview.setFitHeight(50);
                imageview.setFitWidth(50);
                imageview.setImage(image);
                setGraphic(imageview);
                setAlignment(Pos.CENTER);
                // tbData.refresh();
            }else{
                setGraphic(null);
                setText(null);
            }
        };
    });

}


}