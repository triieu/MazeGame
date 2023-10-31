/*
Trieu Huynh
Maze Game
Win Screen
*/

import java.awt.Font;

public class WinLoseScreen {

	public static void draw(int width, int height, String text) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(width/2, height/2, text);
		//StdDraw.setPenColor(128, 0, 128);
	}
}