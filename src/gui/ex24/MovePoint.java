package gui.ex24;

import java.awt.Point;
import java.awt.geom.Point2D;

public class MovePoint {

	public Point point;

	private double px;
	private double py;
	private double vx;
	private double vy;
	public final double gravity;
	public final double maxSpeed;
	public final double maxSpeedSqure;

	public MovePoint(Point point, Point2D velocirty, double maxSpeed, double gravity) {
		this.point = point;
		px = point.x;
		py = point.y;
		this.vx = velocirty.getX();
		this.vy = velocirty.getY();
		this.maxSpeed = maxSpeed;
		this.maxSpeedSqure = maxSpeed * maxSpeed;
		this.gravity = gravity;
	}

	public Point move(Point partner) {
		vx += (partner.x - point.x) * gravity;
		vy += (partner.y - point.y) * gravity;

		double soeedSqure = vx * vx + vy * vy;
		if (soeedSqure > maxSpeedSqure) {
			vx *= (maxSpeedSqure / soeedSqure);
			vy *= (maxSpeedSqure / soeedSqure);
		}

		/*
		 * if(Math.abs(vx) > maxSpeed) { vx = vx > 0 ? maxSpeed : - maxSpeed; }
		 * if(Math.abs(vy) > maxSpeed) { vy = vy > 0 ? maxSpeed : -maxSpeed; }
		 */

		px += vx;
		py += vy;
		point.x = (int) px;
		point.y = (int) py;

		return point;
	}
}
