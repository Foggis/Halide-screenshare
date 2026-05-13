package halide.utils.animations;

import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public final class AngleBracketRotationAnimation {

    private AngleBracketRotationAnimation() {}

    public static void toggleAccordion(Label arrow, boolean[] expanded, double durationMs, double degrees) {
        boolean open = !expanded[0];
        expanded[0] = open;
        RotateTransition rt = new RotateTransition(Duration.millis(durationMs), arrow);
        rt.setToAngle(open ? degrees : 0);
        rt.play();
    }
}