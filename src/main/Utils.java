package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class Utils {

  public static final int DOWN = 0, UP = 1, LEFT = 2, RIGHT = 3;

  /** Gets the content of a text file in a string */
  public static String readFile(String path) {
    StringBuilder builder = new StringBuilder();

    try {
      BufferedReader br = new BufferedReader(new FileReader(path));
      String line;
      while ((line = br.readLine()) != null)
        builder.append(line + "\n");

      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return builder.toString();
  }

  /** Converts a String into Int. */
  public static int parseInt(String text) {
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      return 0;
    }
  }

  /** Inner static method to wait in a thread for the specified time. */
  public static void wait(int milisec) {
    long ct = System.currentTimeMillis();
    long release = ct + milisec;
    for (; release > System.currentTimeMillis(););
  }

  public static int floor(float num) {
    return (int) Math.floor(num);
  }

  public static String[] convertMapData(String text) {
    String[] data = text.split("\\s+");
    String[] mapData = new String[] {"", "", "", ""};
    int index = 0;
    boolean foundData = false;

    for (String element : data) {
      if (element.startsWith("width="))
        mapData[0] = element.substring("width=".length()) + " 25 25";

      if (element.startsWith("data=")) {
        index++;
        foundData = true;
        continue;
      }

      if (element.equals("[layer]"))
        foundData = false;

      if (foundData) {
        mapData[index] += element.replaceAll(",", " ");
      }
    }

    return mapData;
  }
}
