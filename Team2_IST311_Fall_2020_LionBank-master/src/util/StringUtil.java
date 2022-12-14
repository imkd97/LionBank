package util;

import sun.invoke.empty.Empty;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StringUtil
{
  public static boolean isNullOrEmpty(String str) {
    // Will return true if given string is null or empty
    // TODO StringUtil.java 01 - implement isNullOrEmpty(String)
    // Aaron Coccagna (azc5793@psu.edu)

    if (str == null || str.isEmpty()) {
      return true;
    } else { return false; }

  }

  public static boolean isNullOrWhitespace(String str) {
    // Will return true if given string is null or whitespace (e.g., "   ");
    // TODO StringUtil.java 02 - implement isNullOrWhitespace(String)
    // Aaron Coccagna (azc5793@psu.edu)
    if (str == null || str.trim().isEmpty()) {
      return true;
    } else { return false; }

  }



}
