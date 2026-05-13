package halide.checks;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScanResult {

    public enum FindingType {
        DETECTED, // something that is most likely a cheat
        SUSPICIOUS, // not proof, but something that is a bit suspicious
        INFO // Info such as: vpn check, pc username check etc
    }

    public static class Finding {
        private final String message;
        private final FindingType type;

        public Finding(String message, FindingType type) {
            this.message = message;
            this.type = type;
        }

        public @NotNull String getMessage() { return message; }
        public @NotNull FindingType getType() { return type; }
    }

    private final String checkName;
    private final String description;
    private final List<Finding> findings = new ArrayList<>();

    public ScanResult(@NotNull String checkName, @NotNull String description) {
        this.checkName = checkName;
        this.description = description;
    }

    public void addFinding(@NotNull String message, @NotNull FindingType type) {
        findings.add(new Finding(message, type));
    }

    public @NotNull String getCheckName() { return checkName; }
    public @NotNull String getDescription() { return description; }
    public @NotNull List<Finding> getFindings() { return Collections.unmodifiableList(findings); }
}