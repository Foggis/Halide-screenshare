package halide.ui.components;

import halide.Main;
import halide.checks.Check;
import halide.checks.CheckManager;
import halide.checks.ScanResult;
import halide.utils.StageManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;
import java.util.stream.Collectors;

public final class ScanningUI {

    private ScanningUI() {}

    public static Parent build() {
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root-pane");
        root.setPadding(new Insets(6, 12, 18, 18));






        root.setTop(WindowIcons.build());




        VBox content = new VBox(14);
        content.setAlignment(Pos.CENTER);





        Label title = new Label(Main.AppName.toUpperCase());
        title.getStyleClass().add("title");

        Label status = new Label("scanning.");
        status.getStyleClass().add("status-text");




        ProgressBar pb = new ProgressBar();
        pb.setPrefWidth(320);




        content.getChildren().addAll(title, status, pb);
        root.setCenter(content);




        // scanning + dot(s)
        String[] frames = {"",".", "..", "..."};
        int[] idx = {0};
        Timeline dots = new Timeline(new KeyFrame(Duration.millis(500), e ->
                status.setText("scanning" + frames[idx[0]++ % frames.length])
        ));








        dots.setCycleCount(Timeline.INDEFINITE);
        dots.play();

        Thread scanThread = new Thread(() -> {
            CheckManager manager = new CheckManager();
            List<ScanResult> results = manager.getCheck().stream()
                    .map(Check::scan)
                    .collect(Collectors.toList());
            Platform.runLater(() -> {
                dots.stop();
                StageManager.updateScene(ResultsUI.build(results), 500, 400);
            });
        });




        scanThread.setDaemon(true);
        scanThread.start();

        return root;
    }
}