package halide.ui.components;

import halide.utils.StageManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public final class WindowIcons {

    private WindowIcons() {}

    public static HBox build() {
        Button minimize_window_button = new Button("−");
        minimize_window_button.getStyleClass().add("window-btn");
        minimize_window_button.setOnAction(e -> StageManager.stage.setIconified(true));

        Button close_window_button = new Button("×");
        close_window_button.getStyleClass().add("window-btn");
        close_window_button.setOnAction(e -> StageManager.stage.close());






        HBox bar = new HBox(0, minimize_window_button, close_window_button);
        bar.setAlignment(Pos.TOP_RIGHT);
        return bar;
    }
}