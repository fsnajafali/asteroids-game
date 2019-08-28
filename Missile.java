
import java.awt.Color;

import blobz.Blob;
import blobz.BlobProximity;

public class Missile extends Blob implements BlobProximity {

	private final int speed = 5;
	private final int size = 5;

	public Missile(int x, int y, double theta) {
		super(x, y, Color.yellow);
		this.setSize(size);
		this.setLoc(x, y);

		int dx = (int) Math.round(speed * Math.cos(theta));
		int dy = (int) Math.round(speed * Math.sin(theta));

		this.setDelta(dx, dy);
	}
}