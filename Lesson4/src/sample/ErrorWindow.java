package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorWindow extends Application{
    public static void newWindow(String message) {
        Stage errorStage = new Stage();
        Stage win = new Stage();
        win.initModality(Modality.APPLICATION_MODAL);


        Pane pane = new Pane();
        Button ok = new Button("Ok!");
        ok.setOnAction(actionEvent -> win.close());
        pane.getChildren().add(ok);
        Scene scene = new Scene(pane, 300, 100);
        win.setScene(scene);

        win.setTitle(message);
        win.showAndWait();

    }

    @Override
    public void start(Stage errorStage) throws Exception {

    }
}
