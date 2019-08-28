import blobz.PolyBlob;
import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.BlobUtils;
import blobz.SandBox;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {

	private double angle = 0.0;
	private final double delta = 0.15;
	private final double speed = 5.0;
	private SandBox sb;

	Rocket(int x, int y, SandBox sandbox) {

		// Run constructor from the Parent Class.
		super(0, 0, 0);
		super.setLoc(x, y);
		sb = sandbox;
		// Create rocket shape using setPolygon.
		Point[] p = {

				new Point(0, 0), new Point(4, -2), new Point(6, -8), new Point(8, 0), new Point(6, 8), new Point(4, 2),

		};
		setPolygon(p);
		setColor(Color.green);
	}

	public void Launch(SandBox sb) {
		int radius = this.getSize() / 2;

		Point currentLocation = this.getLoc();

		Point placeOfLaunch = BlobUtils.rotatePoint(radius + 5, angle);

		int xCoord = currentLocation.x + placeOfLaunch.x;
		int yCoord = currentLocation.y + placeOfLaunch.y;

		Missile Missile = new Missile(xCoord, yCoord, angle);

		sb.addBlob(Missile);
	}

	public void keyAction(KeyEvent e) {

		switch (e.getKeyCode()) {
		// If left arrow is pressed, update the angle
		case 37:
			if (angle - delta < 2 * Math.PI) {
				angle = angle - delta + 2 * Math.PI;
				super.setAngle(angle);
			} else {
				angle = angle - delta;
				super.setAngle(angle);
			}
			break;
		// If up arrow is pressed, update Location of x and y
		case 38:
			Point p = super.getLoc();
			p.x = p.x + (int) Math.round(speed * Math.cos(angle));
			p.y = p.y + (int) Math.round(speed * Math.sin(angle));
			super.setLoc(p.x, p.y);
			break;
		// If right arrow is pressed, update angle
		case 39:
			if (angle + delta > 2 * Math.PI) {
				angle = angle + delta - 2 * Math.PI;
				super.setAngle(angle);
			} else {
				angle = angle + delta;
			}
			super.setAngle(angle);
			break;
		// If Spacebar is pressed, launch a Missile and play a sound
		case 32:
			Launch(sb);
			BlobUtils.playSound();
			break;

		}
	}
}