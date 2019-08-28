package asteroidgame;

import blobz.BlobUtils;
import blobz.PolyBlob;
import java.awt.Point;
import java.util.Random;

public class Asteroid extends PolyBlob {
	private static final Random random = new Random();
	Point p[];

	public Asteroid(int idx, int jdx, double rot) {
		super(-100, -100, rot);
		super.setDelta(idx, jdx);

		int sides = random.nextInt(5) + 5;
		double[] angle = new double[sides];
		p = new Point[sides];

		for (int i = 0; i < sides; i++) {
			double regSize = (2 * Math.PI) / sides;
			angle[i] = (i * regSize) + (Math.random() * regSize);
		}

		for (int j = 0; j < sides; j++) {
			int distance = random.nextInt(5) + 5;
			p[j] = BlobUtils.rotatePoint(distance, angle[j]);
		}
		super.setPolygon(p);
	}
}