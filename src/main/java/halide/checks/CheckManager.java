package halide.checks;

import halide.checks.impl.info.PcUsernameInfo;
import halide.checks.impl.info.TimeSinceStartInfo;
import halide.checks.impl.info.VpnCheckInfo;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CheckManager {
    private final List<Check> check = new ArrayList<>();

    public CheckManager() {
        // check's
        //check.add(new StringsCheck());


        // info
        //check.add(new PcUsernameInfo()); // disabled because some people have their full name as pc username for some reason.
        check.add(new VpnCheckInfo());
        check.add(new TimeSinceStartInfo());
    }




    public @NotNull List<Check> getCheck() {
        return List.copyOf(check);
    }
}