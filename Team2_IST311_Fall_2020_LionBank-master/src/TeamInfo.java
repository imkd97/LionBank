public class TeamInfo
{
  private static final String NL = System.lineSeparator();
  private static StringBuilder sbInfo;

  static {
    sbInfo = new StringBuilder();
  }

  private static void appendLine(String txt) {
    sbInfo.append(txt);
    sbInfo.append(NL);
  }

  public static String info() {
    // TODO TeamInfo.java 01 - Put in your team
    appendLine(".----------------------------------.");
    appendLine("| IST 311, Fall 2020               |");
    appendLine("|----------------------------------|");
    appendLine("| Scott Crowthers (scc5336@psu.edu)|");
    appendLine("| Aaron Coccagna  (azc5793@psu.edu)|");
    appendLine("| Adama Doumbia   (apd5391@psu.edu)|");
    appendLine("| Kush Dave       (kfd5176@psu.edu)|");
    appendLine("'----------------------------------'");
    appendLine("");

    return sbInfo.toString();
  }
}
