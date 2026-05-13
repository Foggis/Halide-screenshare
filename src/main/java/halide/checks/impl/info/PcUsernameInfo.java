package halide.checks.impl.info;

import halide.checks.Check;
import halide.checks.ScanResult;

public class PcUsernameInfo implements Check {

    @Override public String getName() { return "pc username:"; }
    @Override public String getDescription() { return "shows system username"; }

    @Override
    public ScanResult scan() {
        ScanResult result = new ScanResult(getName(), getDescription());
        result.addFinding(System.getProperty("user.name"), ScanResult.FindingType.INFO);
        return result;
    }
}