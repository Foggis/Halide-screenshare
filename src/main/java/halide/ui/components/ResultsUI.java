package halide.ui.components;

import halide.checks.ScanResult;
import halide.utils.animations.AngleBracketRotationAnimation;
import halide.utils.Theme;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.util.Duration;
import java.util.*;

public final class ResultsUI {

    private static final double animation_duration = 180; // ms
    private static final double rotate_Degrees = 90;

    private record Entry(String checkName, String description, ScanResult.Finding finding) {}

    private static final ScanResult.FindingType[] ORDER = {
            ScanResult.FindingType.DETECTED,
            ScanResult.FindingType.SUSPICIOUS,
            ScanResult.FindingType.INFO
    };

    private ResultsUI() {}

    public static Parent build(List<ScanResult> results) {
        Map<ScanResult.FindingType, List<Entry>> grouped = group(results);

        BorderPane root = new BorderPane();
        root.getStyleClass().add("root-pane");
        root.setPadding(new Insets(6, 12, 18, 18));

        Label scanTitle = new Label("Scan results:");
        scanTitle.getStyleClass().add("scan-title");
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox topBar = new HBox(scanTitle, spacer, WindowIcons.build());
        topBar.setAlignment(Pos.CENTER_LEFT);
        root.setTop(topBar);











        VBox list = new VBox(4);

        list.setPadding(new Insets(14, 4, 0, 0));

        for (ScanResult.FindingType type : ORDER)
            list.getChildren().add(buildSection(type, grouped.getOrDefault(type, List.of())));








        ScrollPane scroll = new ScrollPane(list);
        scroll.getStyleClass().add("scroll-pane");
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setCenter(scroll);
        return root;
    }

    private static VBox buildSection(ScanResult.FindingType type, List<Entry> entries) {
        Label arrow = new Label(">");
        arrow.getStyleClass().add("category-arrow");

        Label name = new Label(categoryName(type) + " [" + entries.size() + "]");
        name.getStyleClass().add("category-name");







        HBox header = new HBox(6, arrow, name);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(6, 8, 6, 4));
        header.getStyleClass().add("category-header");
        header.setStyle("-fx-cursor: hand;");






        VBox content = new VBox(6);
        content.setPadding(new Insets(4, 0, 6, 18));
        content.setVisible(false);
        content.setManaged(false);





        if (entries.isEmpty()) {
            Label empty = new Label("No findings.");
            empty.getStyleClass().add("status-text");
            content.getChildren().add(empty);
        } else {
            for (Entry e : entries) content.getChildren().add(buildRow(e, color(type)));
        }




        boolean[] expanded = {false};
        header.setOnMouseClicked(ev -> {
            AngleBracketRotationAnimation.toggleAccordion(arrow, expanded, animation_duration, rotate_Degrees);
            content.setVisible(expanded[0]);
            content.setManaged(expanded[0]);
        });




        return new VBox(0, header, content);
    }




    private static HBox buildRow(Entry entry, String color) {
        Region bar = new Region();
        bar.setPrefWidth(3);
        bar.setMinWidth(3);
        bar.setMaxWidth(3);
        bar.setMinHeight(38);
        bar.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 2;");




        Label checkLabel = new Label(entry.checkName());
        checkLabel.setStyle("-fx-text-fill: " + color + "; -fx-cursor: hand;");




        if (entry.description() != null && !entry.description().isBlank()) {
            Tooltip tip = new Tooltip(entry.description());
            tip.setWrapText(true);
            tip.setMaxWidth(320);
            tip.setShowDelay(Duration.millis(100));
            tip.setHideDelay(Duration.millis(100));
            checkLabel.setOnMouseMoved(e -> {
                tip.setAnchorX(e.getScreenX() + 14);
                tip.setAnchorY(e.getScreenY() + 14);
            });
            Tooltip.install(checkLabel, tip);
        }





        Label msg = new Label(entry.finding().getMessage());
        msg.getStyleClass().add("finding-text");
        msg.setWrapText(true);

        VBox textBlock = new VBox(2, checkLabel, msg);
        HBox.setHgrow(textBlock, Priority.ALWAYS);

        HBox row = new HBox(10, bar, textBlock);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(2, 0, 2, 0));
        return row;
    }








    private static Map<ScanResult.FindingType, List<Entry>> group(List<ScanResult> results) {
        Map<ScanResult.FindingType, List<Entry>> map = new LinkedHashMap<>();
        for (ScanResult r : results)
            for (ScanResult.Finding f : r.getFindings())
                map.computeIfAbsent(f.getType(), k -> new ArrayList<>())
                        .add(new Entry(r.getCheckName(), r.getDescription(), f));
        return map;
    }

    private static String color(ScanResult.FindingType type) {
        return switch (type) {
            case DETECTED   -> Theme.DETECTED;
            case SUSPICIOUS -> Theme.SUSPICIOUS;
            case INFO       -> Theme.INFO;
        };
    }

    private static String categoryName(ScanResult.FindingType type) {
        return switch (type) {
            case DETECTED -> "Detected";
            case SUSPICIOUS -> "Suspicious";
            case INFO -> "Info";
        };
    }
}