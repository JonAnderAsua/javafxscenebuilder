package ehu.isad;

import ehu.isad.controller.ui.*;
import ehu.isad.model.Herrialde;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

  private Parent hasieraUI;
  private Parent herriAukeratuUI;
  private Parent bozkatuDuUI;
  private Parent bozTaulaUI;
  private Parent topUI;

  private Stage stage;

  private HasieraKud hasieraKud;
  private HerrAukKud herriKud;
  private BozDuKud bozDuKud;
  private BozTaulaKud bozTaulaKud;
  private TopKud topKud;

  private Scene hasieraScene = new Scene(hasieraUI,450,275);
  private Scene herriAukScene = new Scene(herriAukeratuUI,450,275);
  private Scene bozkatuDuScene = new Scene(bozkatuDuUI,450,275);
  private Scene bozTaulaScene = new Scene(bozTaulaUI,450,275);
  private Scene topScene = new Scene(topUI,450,275);


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(hasieraScene);
    stage.show();
  }

  private void pantailakKargatu() throws IOException {


    //Hasierako pantaila kargatu
    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderKautotu.load();
    hasieraKud = loaderKautotu.getController();
    hasieraKud.setMainApp(this);


    //Herrialdea aukeratzeko bozkatu
    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/herrAukeratu.fxml"));
    herriAukeratuUI = (Parent) loaderMain.load();
    herriKud = loaderMain.getController();
    herriKud.setMainApp(this);


    //Aukeratutako herrialdea bozkatu badu
    FXMLLoader loaderBozBai = new FXMLLoader(getClass().getResource("/bozkatuDu.fxml"));
    bozkatuDuUI = (Parent) loaderBozBai.load();
    bozDuKud = loaderBozBai.getController();
    bozDuKud.setMainApp(this);


    //Aukeratutako herrialdea bozkatzeko
    FXMLLoader loaderBozTaula = new FXMLLoader(getClass().getResource("/bozTaula.fxml"));
    bozTaulaUI = (Parent) loaderBozTaula.load();
    bozTaulaKud = loaderBozTaula.getController();
    bozTaulaKud.setMainApp(this);

    //Top 3
    FXMLLoader loaderTop = new FXMLLoader((getClass().getResource("top.fxml")));
    topUI = (Parent) loaderTop.load();
    topKud = loaderTop.getController();
    topKud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }


  public void herrialdeaAukeratu(){
    stage.setScene(herriAukScene);
    stage.show();
    herriKud.hasi();
  }

  public void bozkatuDuErakutsi(Herrialde h) {
    stage.setScene(bozkatuDuScene);
    stage.show();
    bozDuKud.hasieratu(h);
  }

  public void bozTaulaErakutsi(Herrialde h) {
    stage.setScene(bozTaulaScene);
    stage.show();
    bozTaulaKud.erakutsi();
  }

  public void topErakutsi() throws SQLException {
    stage.setScene(topScene);
    stage.show();
    topKud.erakutsi();
  }
}
