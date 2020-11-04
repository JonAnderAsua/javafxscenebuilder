package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.model.Herrialde;
import ehu.isad.model.StudentsModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

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

    @FXML
    void bozkatu(ActionEvent event){
        main.topErakutsi();
    }

    public void setMainApp(Main m) {
        main = m;
    }

    public void erakutsi() {
        tableId.setEditable(true);
        izenaId.setCellValueFactory(new PropertyValueFactory<>("izena"));
        artistaId.setCellValueFactory(new PropertyValueFactory<>("taldea"));
        abestiaId.setCellValueFactory(new PropertyValueFactory<>("abestia"));
        puntuakId.setCellFactory(new PropertyValueFactory<>(0));

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
    }
    

/*
        iznaId.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                
 */

    Callback<TableColumn<StudentsModel, String>, TableCell<StudentsModel, String>> defaultTextFieldCellFactory
            = TextFieldTableCell.<StudentsModel>forTableColumn();

        abestiaId.setCellFactory(col -> {
        TableCell<StudentsModel, String> cell = defaultTextFieldCellFactory.call(col);

        cell.setOnMouseClicked(event -> {
            if (! cell.isEmpty()) {
                if (cell.getTableView().getSelectionModel().getSelectedItem().getFirstName().equals("Jon")) {
                    cell.setEditable(false);
                }else {
                    cell.setEditable(true);
                }
            }
        });

        return cell ;
    });


        abestiaId.setOnEditCommit(
    t -> {
        t.getTableView().getItems().get(t.getTablePosition().getRow())
                .setLastName(t.getNewValue());


    }
        );

       image.setCellValueFactory(new PropertyValueFactory<StudentsModel, Image>("image"));

       image.setCellFactory(p -> new TableCell<>() {
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

    //add your data to the table here.
        tbData.setItems(studentsModels);
}


    public void setMainApp(Main main) {
        this.main = main;
    }

    public void sartu(ActionEvent actionEvent) {

//        try(InputStream in = new URL("https://www.eldiario.es/fotos/mejores-memes-debate-electoral_EDIIMA20191102_0433_26.jpg").
//            openStream()){
//            Files.copy(in, Paths.get("build/resources/main/memes.jpg"));
//            Files.copy(in, Paths.get("src/main/resources/memes.jpg"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        studentsModels.add(new StudentsModel(studentid++,"meme","last", "security.png"));

    }

    public void gorde(ActionEvent actionEvent) {
        System.out.println("gorde");
    }

    public void ezabatu(ActionEvent actionEvent) {
        int selectedIndex = tbData.getSelectionModel().getSelectedIndex();
        if (selectedIndex>=0)
            studentsModels.remove(selectedIndex);
    }

    //listern metodoak jarri behar dira
}