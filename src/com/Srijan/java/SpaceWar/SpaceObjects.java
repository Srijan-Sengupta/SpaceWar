package com.Srijan.java.SpaceWar;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class SpaceObjects {

	protected SpaceWar war;
	private ImageIcon imageIcon;
	protected int xPosition;
	protected int yPosition;
	public boolean destroyed = false;
	protected int xDir = 1;
	protected int yDir = 1;

	public SpaceObjects(SpaceWar spaceWar, ImageIcon imageIcon, int xPosition, int yPosition) {
		this.war = spaceWar;
		this.imageIcon = imageIcon;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	public abstract void move();

	public abstract void moveHaphazard();

	public abstract void shoot();

	public abstract void destroy();

	public abstract String getId();

	public Rectangle getRectangle() {
		return new Rectangle(xPosition, yPosition, imageIcon.getIconWidth(), imageIcon.getIconHeight());
	}

}
