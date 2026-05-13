package halide.checks.impl.info;

import halide.checks.Check;
import halide.checks.ScanResult;
import java.net.URI;
import java.util.Scanner;

public class VpnCheckInfo implements Check {
    @Override public String getName() { return "vpn check:"; }
    @Override public String getDescription() { return "checks if IP belongs to a public VPN or Proxy"; }

    @Override
    public ScanResult scan() {
        ScanResult result = new ScanResult(getName(), getDescription());
        try {
            String ip   = new Scanner(URI.create("https://api.ipify.org").toURL().openStream()).next();
            String json = new Scanner(URI.create("http://ip-api.com/json/" + ip + "?fields=query,proxy,hosting,org").toURL().openStream()).useDelimiter("\\A").next();


            boolean vpn = json.contains("\"proxy\":true") || json.contains("\"hosting\":true");
            result.addFinding("vpn enabled: " + vpn, ScanResult.FindingType.INFO);
        } catch (Exception e) { result.addFinding("check failed: " + e.getMessage(), ScanResult.FindingType.INFO); }
        return result;
    }
}