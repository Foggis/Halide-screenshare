package halide.ui.components;

public final class CSS {

    private CSS() {}

    public static final String CSS = """
        .root-pane {
            -fx-background-color: #0f0f0f;
            -fx-border-color: #201f1f;
            -fx-border-width: 1;
            -fx-background-radius: 14;
            -fx-border-radius: 14;
        }
        .title {
            -fx-font-family: 'Segoe UI';
            -fx-font-size: 20px;
            -fx-text-fill: white;
        }
        .status-text {
            -fx-font-size: 11px;
            -fx-text-fill: #cae0ee;
        }
        .progress-bar > .track {
            -fx-background-color: #201f1f;
        }
        .progress-bar > .bar {
            -fx-background-color: white;
        }
        .scan-title {
            -fx-font-family: 'Segoe UI';
            -fx-font-size: 12px;
            -fx-text-fill: #6e6e6e;
            -fx-letter-spacing: 0.5px;
        }
        .finding-module {
            -fx-font-family: 'Segoe UI';
            -fx-font-size: 10px;
            -fx-text-fill: #6e6e6e;
        }
        .finding-text {
            -fx-font-family: 'Segoe UI';
            -fx-font-size: 11px;
            -fx-text-fill: #e0e0e0;
        }
        .window-btn {
            -fx-background-color: transparent;
            -fx-text-fill: #4a4a4a;
            -fx-padding: 0 7;
            -fx-font-size: 18px;
            -fx-cursor: hand;
        }
        .window-btn:hover {
            -fx-text-fill: #cccccc;
        }
        .scroll-pane {
            -fx-background: transparent;
            -fx-background-color: transparent;
        }
        .scroll-pane > .viewport {
            -fx-background-color: transparent;
        }
        .scroll-bar:vertical {
            -fx-background-color: transparent;
            -fx-pref-width: 6px;
        }
        .scroll-bar:vertical .track {
            -fx-background-color: transparent;
            -fx-border-color: transparent;
        }
        .scroll-bar:vertical .thumb {
            -fx-background-color: rgba(255,255,255,0.25);
            -fx-background-radius: 10;
        }
        .scroll-bar:vertical .thumb:hover {
            -fx-background-color: rgba(255,255,255,0.5);
        }
        .scroll-bar:vertical .increment-button,
        .scroll-bar:vertical .decrement-button {
            -fx-pref-height: 0;
            -fx-min-height: 0;
            -fx-max-height: 0;
            -fx-padding: 0;
            -fx-opacity: 0;
        }
        .scroll-bar:vertical .increment-arrow,
        .scroll-bar:vertical .decrement-arrow {
            -fx-pref-height: 0;
            -fx-min-height: 0;
            -fx-max-height: 0;
            -fx-padding: 0;
            -fx-opacity: 0;
        }
    """;
}