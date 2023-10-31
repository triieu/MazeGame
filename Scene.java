/*
Trieu Huynh
Maze Game
Scene
*/

public class Scene {
	private static final int TILE_SIZE = 32;
	private static int rows;
	private static int cols;
	private static boolean[][] walls;
	private static int width;
	private static int height;
	private static String floorImage;
	private static String wallImage;

	public static void start(int level) {
		floorImage = "Assets/tile-passage.png";
		wallImage = "Assets/purple-wall.png";

		String[][] map = World.getLevel(level);
		rows = map.length;
		cols = map[0].length;

		width = cols * TILE_SIZE;
		height = rows * TILE_SIZE;

		walls = new boolean[rows][cols];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				String tile = map[y][x];
				setTile(x, y, tile);
			}
		}

		// set up canvas data (size & scale)
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0.0, width);
		StdDraw.setYscale(height, 0.0);
	}

	public static void setTile(int x, int y, String tile) {
		if (tile.equals("#")) {						// # is a wall
			walls[y][x] = true;
		}
		else if (tile.equals("@")) {				// @ is the player
			Player.start(x, y);
		}
		else if (tile.equals("!")) {
			Exit.start(x,y);
		}
		else if (tile.equals("&")) {
			Enemy.start(x,y);
		}
		else if (tile.equals("*")) {
			Enemy2.start(x,y);
		}
		else if (tile.equals("^")) {
			Key.start(x,y);
		}
	}

	public static void draw() {
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				int tileX = x * TILE_SIZE + TILE_SIZE/2;
				int tileY = y * TILE_SIZE + TILE_SIZE/2;

				if (walls[y][x] == true)  {
					StdDraw.picture(tileX, tileY, wallImage);
				}
				else {
					StdDraw.picture(tileX, tileY, floorImage);
				}
			}
		}
	}

	public static boolean canMove(int x, int y){
		return !walls[y][x];
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}
}