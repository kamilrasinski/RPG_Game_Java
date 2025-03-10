public class TextFormatter {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_RESET = "\u001B[0m";

    public static String getAnsiYellow(String text) {
        return ANSI_YELLOW + text + ANSI_RESET;
    }

    public static String getAnsiRed(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    public static String getAnsiGreen(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    public static String getAnsiBlue(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }

    public static String getAnsiPurple(String text) {
        return ANSI_PURPLE + text + ANSI_RESET;
    }

    public static String getAnsiCyan(String text) {
        return ANSI_CYAN + text + ANSI_RESET;
    }

}

