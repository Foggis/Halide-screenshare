package halide;

import halide.ui.App;

public class Main {



    public static final long startTime = System.currentTimeMillis();



    static {
        System.out.println(
        "  ___ ___        .__  .__    .___  \n"+
        " /   |   \\_____  |  | |__| __| _/____             ______ ______\n"+
        "/    ~    \\__  \\ |  | |  |/ __ |/ __ \\   ______  /  ___//  ___/\n"+
        "\\    Y    // __ \\|  |_|  / /_/ \\  ___/  /_____/  \\___ \\ \\___ \\ \n"+
        " \\___|_  /(____  /____/__\\____ |\\___  >         /____  >____  >\n"+
        "       \\/      \\/             \\/    \\/               \\/     \\n"+
                ("By:" + Main.Authors)





        );
    }



    public static String AppName = "Halide";
    public static String Authors = "Fogma"; // Feel free to add your name to author list if you have contributed :)
    public static String Release = "0.1";








    public static long getElapsedMillis() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        App.main(args);
    }
}