package halide.checks.impl.info;

import halide.Main;
import halide.checks.Check;
import halide.checks.ScanResult;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TimeSinceStartInfo implements Check {

    @Override public String getName() { return "system uptime:"; }
    @Override public String getDescription() { return "shows time since system started"; }

    @Override
    public ScanResult scan() {
        ScanResult result = new ScanResult(getName(), getDescription());

        try {
            String uptimeData = Files.readString(Paths.get("/proc/uptime"));
            double uptimeSecondsRaw = Double.parseDouble(uptimeData.split(" ")[0]);

            long totalSeconds = (long) uptimeSecondsRaw;

            long days = totalSeconds / 86400;
            long hours = (totalSeconds % 86400) / 3600;
            long minutes = (totalSeconds % 3600) / 60;
            long seconds = totalSeconds % 60;

            String uptime = String.format(
                    "%d days, %02d hours, %02d minutes, %02d seconds",
                    days, hours, minutes, seconds
            );

            result.addFinding(uptime, ScanResult.FindingType.INFO);

        } catch (Exception e) {
            result.addFinding("["+ Main.AppName+"]"+ "failed to get system uptime", ScanResult.FindingType.INFO);
        }

        return result;
    }
}