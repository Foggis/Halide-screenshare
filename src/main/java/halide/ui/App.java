package halide.ui;

import halide.ui.components.ScanningUI;
import halide.utils.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage s) {
        StageManager.stage = s;
        s.initStyle(StageStyle.TRANSPARENT);
        StageManager.updateScene(ScanningUI.build(), 500, 300); //this is the size of the window btw
        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}