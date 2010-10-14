package points.domain.impl;

import java.awt.Color;

import points.domain.Point;

/**
 * A simple point implementation.
 */
public class DefaultPoint implements Point, Cloneable {

	private int id;

	private double x, y;

	private Color color;

	public DefaultPoint(final double x, final double y, final Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setX(final double x) {
		this.x = x;
	}

	public void setY(final double y) {
		this.y = y;
	}

	public void setColor(final Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public int compareTo(final Point that) {
		if (this.getX() < that.getX())
			return -1;
		if (this.getX() > that.getX())
			return +1;
		if (this.getY() < that.getY())
			return -1;
		if (this.getY() > that.getY())
			return +1;
		int col = this.getColor().getRGB() - that.getColor().getRGB();
		if (col != 0)
			return col;
		return this.getId() - that.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(final Object that) {
		return that instanceof Point && getId() == ((Point) that).getId();
	}

	@Override
	public String toString() {
		return "{id=" + getId() + ",x=" + getX() + ",y=" + getY() + ",col="
				+ getColor() + "}";
	}

	@Override
	public Point clone() {
		try {
			// OK to share Color instances because they are immutable
			return (Point) super.clone();
		} catch (CloneNotSupportedException ex) {
			throw new RuntimeException("should not have happend", ex);
		}
	}
}
