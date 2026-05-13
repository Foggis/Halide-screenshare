package halide.utils;

import halide.ui.components.CSS;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class StageManager {

    private StageManager() {}

    public static Stage stage;
    private static double x = 0, y = 0;

    public static void updateScene(Parent root, int w, int h) {
        root.setOnMousePressed(e -> { x = e.getSceneX(); y = e.getSceneY(); });
        root.setOnMouseDragged(e -> { stage.setX(e.getScreenX() - x); stage.setY(e.getScreenY() - y); });
        Scene scene = new Scene(root, w, h);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("data:text/css," + CSS.CSS.replace("\n", "%0A"));
        stage.setScene(scene);
    }
}