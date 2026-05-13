package halide.checks;

import org.jetbrains.annotations.NotNull;

public interface Check {
    @NotNull String getName();
    @NotNull String getDescription();
    @NotNull ScanResult scan();
}