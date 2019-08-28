package asteroidgame;

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

public class AsteroidGame implements BlobGUI {

	private final SandBox sb;
	private final Random NUM = new Random();
	private final int a;
	double Rotation[] = new double[] { -0.1, 0.1 };;

	public static void main(String[] args) {
		new AsteroidGame(Integer.parseInt(args[0]));
	}

	public AsteroidGame(int num) {
		a = num;
		sb = new SandBox();
		sb.setSandBoxMode(SandBoxMode.FLOW);
		sb.setFrameRate(15);
		sb.init(this);
	}

	public int getWidth(int thisWidth) {
		int width = thisWidth / 2;
		return width;
	}

	public int getHeight(int thisHeight) {
		int height = thisHeight / 2;
		return height;
	}

	@Override
	public void generate() {
		Rocket rocket = new Rocket((getWidth(sb.getPanelBounds().width)), (getHeight(sb.getPanelBounds().height)), sb);
		sb.addBlob(rocket);

		for (int i = 0; i < a; i++) {
			int xV = NUM.nextInt((3 - (-3)) + 1) + (-3);
			int yV = NUM.nextInt((3 - (-3)) + 1) + (-3);

			while (xV == 0)
				xV = NUM.nextInt((3 - (-3)) + 1) + (-3);
			while (yV == 0)
				yV = NUM.nextInt((3 - (-3)) + 1) + (-3);

			int index = NUM.nextInt(2); // check 1 also
			double r = Rotation[index];
			Asteroid a = new Asteroid(xV, yV, r);
			sb.addBlob(a);
		}
		/*
		 * for (int i = 0; i < 10; i++) {
		 * 
		 * int xCoord = 0; while (xCoord == 0) { xCoord = -3 + random.nextInt(7); } int
		 * yCoord = 0; while (yCoord == 0) { yCoord = -3 + random.nextInt(7); }
		 * 
		 * double rotation = .1; int b = random.nextInt(2); if (b == 0) { rotation =
		 * -rotation; }
		 * 
		 * Asteroid asteroid = new Asteroid(xCoord, yCoord, rotation);
		 * sb.addBlob(asteroid);
		 */
	}

}