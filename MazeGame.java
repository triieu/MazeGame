/*
Trieu Huynh
Maze Game
Main
*/

public class MazeGame {
	private static boolean gameOver;
	private static int level;
	private static boolean keyObtained;

	public static void main(String[] args) {
		start();

		while (gameOver == false) {
			update();
			render();
		}
	}

	public static void start() {
		gameOver = false;
		level = 0;
		World.start();
		Scene.start(level);
	}

	public static void update() {
		Player.update();
		Enemy.update();
		Enemy2.update();

		if (Player.getX() == Exit.getX() && Player.getY() == Exit.getY() ) {
			level++;
			if (level == World.getLength() ) {
				gameOver = true;
			}
			else {
				Scene.start(level);
				keyObtained = false;
			}
		}

		if (Player.getX() == Enemy.getX() && Player.getY() == Enemy.getY() ) {
			gameOver = true;
			//System.out.println("Game Over. You have died.");
		}
		if (Player.getX() == Enemy2.getX() && Player.getY() == Enemy2.getY() ) {
			gameOver = true;
			//System.out.println("Game Over. You have died.");
		}
		if (Player.getX() == Key.getX() && Player.getY() == Key.getY() ) {
			keyObtained = true;
		}
		if (Player.getX() == Exit.getX() && Player.getY() == Exit.getY() && gameOver == false) {
			keyObtained = false;
		}

	}

	public static void render() {
		Scene.draw();
		Enemy.draw();
		Enemy2.draw();
		Player.draw();
		if (keyObtained == false) {
			Key.draw();
		}
		if (keyObtained == true) {
			Exit.draw();
		}
		if (gameOver == true && Player.getX() == Exit.getX() && Player.getY() == Exit.getY()) {
			WinLoseScreen.draw(Scene.getWidth(), Scene.getHeight(), "Game Over. You Won!");
		} else if (gameOver == true) {
			WinLoseScreen.draw(Scene.getWidth(), Scene.getHeight(), "You have died to the enemy.");
		}
		StdDraw.show(100);
	}
}