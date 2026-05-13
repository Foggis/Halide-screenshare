//package halide.checks.impl.checks;
//
//import halide.checks.Check;
//import halide.checks.ScanResult;
//import halide.utils.ProcessUtils;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class StringsCheck implements Check {
//
//    private static final List<String> STRINGS = Arrays.asList(
//            // module strings
//            "selfdestruct", "killaura", "autocrystal", "triggerbot", "aimassist", "attributeswap", "playeresp", "storageesp", "antibot", "anchormacro", "backtrack", "lagrange", "fakelag", "hovertotem", "shieldstun", "autoclicker", "pearl macro", "windchargemacro", "bow release", "autoxp", "fastplace", "potrefill",
//
//            // other
//            "jnativehook",
//            // client names
//            "Argon", "catlean", "Asteria", "Prestige client",
//
//            // drqxiz client or smth, i copied this from: https://github.com/MeowTonynoh/MeowModAnalyzer/blob/main/MeowModAnalyzer.ps1
//            "ＡｕｔｏＡｎｃｈｏｒ", "Ａｕｔｏ Ａｎｃｈｏｒ",
//            "ＤｏｕｂｌｅＡｎｃｈｏｒ", "Ｄｏｕｂｌｅ Ａｎｃｈｏｒ",
//            "ＳａｆｅＡｎｃｈｏｒ", "Ｓａｆｅ Ａｎｃｈｏｒ",
//            "Ａｎｃｈｏｒ Ｍａｃｒｏ",    "ＡｕｔｏＣｒｙｓｔａｌ", "Ａｕｔｏ Ｃｒｙｓｔａｌ",
//            "ＡｕｔｏＨｉｔＣｒｙｓｔａｌ",    "ＡｕｔｏＴｏｔｅｍ", "Ａｕｔｏ Ｔｏｔｅｍ",
//            "ＨｏｖｅｒＴｏｔｅｍ", "Ｈｏｖｅｒ Ｔｏｔｅｍ",
//            "ＩｎｖｅｎｔｏｒｙＴｏｔｅｍ", "Ａｕｔｏ Ｉｎｖｅｎｔｏｒｙ Ｔｏｔｅｍ",
//            "Ａｕｔｏ Ｔｏｔｅｍ Ｈｉｔ",    "ＡｕｔｏＤｏｕｂｌｅＨａｎｄ", "Ａｕｔｏ Ｄｏｕｂｌｅ Ｈａｎｄ",
//
//            "ＳｈｉｅｌｄＤｉｓａｂｌｅｒ", "Ｓｈｉｅｌｄ Ｄｉｓａｂｌｅｒ"
//    );
//
//    @Override public String getName() { return "Generic cheat strings"; }
//    @Override public String getDescription() { return "Looks for generic strings that cheats tend to have"; }
//
//}