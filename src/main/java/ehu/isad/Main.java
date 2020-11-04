package ehu.isad;

import ehu.isad.controller.ui.*;
import ehu.isad.model.Herrialde;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(hasieraUI, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {


    //Hasierako pantaila kargatu
    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderKautotu.load();
    hasieraKud = loaderKautotu.getController();
    hasieraKud.setMainApp(this);


    //Herrialdea aukeratzeko bozkatu
    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
    herriAukeratuUI = (Parent) loaderMain.load();
    herriKud = loaderMain.getController();
    herriKud.setMainApp(this);


    //Aukeratutako herrialdea bozkatu badu
    FXMLLoader loaderBozBai = new FXMLLoader(getClass().getResource("/bozkatuDu.fxml"));
    bozkatuDuUI = (Parent) loaderMain.load();
    bozDuKud = loaderMain.getController();
    bozDuKud.setMainApp(this);


    //Aukeratutako herrialdea bozkatzeko
    FXMLLoader loaderBozTaula = new FXMLLoader(getClass().getResource("/bozTaula.fxml"));
    bozTaulaUI = (Parent) loaderMain.load();
    bozTaulaKud = loaderMain.getController();
    bozTaulaKud.setMainApp(this);

    //Top 3
    FXMLLoader loaderTop = new FXMLLoader((getClass().getResource("top.fxml")));
    topUI = (Parent) loaderMain.load();
    topKud = loaderMain.getController();
    topKud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }
/*
  public void ezarpenakErakutsi() {
    stage.setScene(new Scene(ezarpenakUI));
    stage.show();
    ezarpenakKud.getEzarpenak();
  }

 */

  public void herrialdeaAukeratu(){
    stage.setScene(new Scene(herriAukeratuUI));
    stage.show();
    herriKud.hasi();
  }

  public void bozkatuDuErakutsi(Herrialde h) {
    stage.setScene(new Scene(bozkatuDuUI,450,275));
    stage.show();
    bozDuKud.hasieratu(h);
  }

  public void bozTaulaErakutsi(Herrialde h) {
    stage.setScene(new Scene(bozTaulaUI,450,275));
    stage.show();
    bozTaulaKud.erakutsi();
  }

  public void topErakutsi(){
    stage.setScene(new Scene(topUI,450,275));
    stage.show();
    topKud.erakutsi();
  }
}
