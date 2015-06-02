package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class Utils {

	public static final int DOWN = 0, UP = 1, LEFT = 2, RIGHT = 3;

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

	public static int parseInt(String text) {
		try
		{
			return Integer.parseInt(text);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

}
