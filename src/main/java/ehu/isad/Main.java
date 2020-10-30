package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent hasieraUI;
  private Parent herriAukeratuUI;
  private Parent taulaUI;

  private Stage stage;

  private HasieraKud hasieraKud;
  private HerrAukKud herriKud;
  private HasieraKud hasKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Eurobisioa");
    stage.setScene(new Scene(hasieraUI, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderKautotu.load();
    hasKud = loaderKautotu.getController();
    hasKud.setMainApp(this);

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
    herriAukeratuUI = (Parent) loaderMain.load();
    herriKud = loaderMain.getController();
    herriKud.setMainApp(this);
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
}
