package ehu.isad;

import ehu.isad.controller.ui.NagusiaKud;
import ehu.isad.controller.ui.EzarpenakKud;
import ehu.isad.controller.ui.TaulaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent nagusiaUI;
  private Parent ezarpenakUI;
  private Parent taulaUI;

  private Stage stage;

  private EzarpenakKud nagusiaKud;
  private EzarpenakKud ezarpenakKud;
  private TaulaController taulaKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("Ezarpenak lortu");
    stage.setScene(new Scene(taulaUI, 450, 275));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/taulaFroga.fxml"));
    taulaUI = (Parent) loaderKautotu.load();
    taulaKud = loaderKautotu.getController();
    taulaKud.setMainApp(this);

    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
    ezarpenakUI = (Parent) loaderMain.load();
    ezarpenakKud = loaderMain.getController();
    ezarpenakKud.setMainApp(this);
  }


  public static void main(String[] args) {
    launch(args);
  }

  public void ezarpenakErakutsi() {
    stage.setScene(new Scene(ezarpenakUI));
    stage.show();
    ezarpenakKud.getEzarpenak();
  }
}
