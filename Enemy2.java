/*
Trieu Huynh
Maze Game
Enemy Two
*/

public class Enemy2 {
	public static final int TILE_SIZE = 32;
	private static int x;
	private static int y;
	private static String image;
	private static long time;

	// start enemy data
	public static void start(int x,  int y) {
		Enemy2.x = x;
		Enemy2.y = y;
		image = "Assets/daph-potion.png";
		time = System.currentTimeMillis();
	}

	public static void draw() {
		int tileX = x * TILE_SIZE + TILE_SIZE/2;
		int tileY = y * TILE_SIZE + TILE_SIZE/2;
		StdDraw.picture(tileX, tileY, image, 32, 32);
	}

	public static void move() {
		int enemyChoice = (int) (Math.random() * 4);

		if (enemyChoice == 0 && Scene.canMove(x, y-1)) {
			y--;
		}
		else if (enemyChoice == 1 && Scene.canMove(x, y+1)) {
			y++;
		}
		else if (enemyChoice == 2 && Scene.canMove(x-1, y)) {
			x--;
		}
		else if (enemyChoice == 3 && Scene.canMove(x+1, y)) {
			x++;
		}
		time = System.currentTimeMillis();
	}

	public static void update() {
		long now = System.currentTimeMillis();
		if (now - time > 1000) {
			Enemy2.move();
		}
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}
}