package com.Srijan.java.SpaceWar;

import javax.swing.ImageIcon;

public class Asteroid extends SpaceObjects {

	private String id = "asteroid";
	private int destructionPeriod = 20;

	public Asteroid(SpaceWar spaceWar, int xPosition, int yPosition) {
		super(spaceWar, new ImageIcon(WarInformation.ASTEROID_IMAGE_PATH), xPosition, yPosition);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (!destroyed) {
			yPosition += yDir;
		} else {
			if (destructionPeriod == 0) {
				war.remove(this);
			} else {
				destructionPeriod--;
			}
		}
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		// Can't shoot
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		setImageIcon(new ImageIcon(WarInformation.EXPLOSION_IMAGE_PATH));
		destroyed = true;
	}

	@Override
	public void moveHaphazard() {
		// TODO Auto-generated method stub
		if (yPosition >= 0) {

			if (!destroyed) {
				xPosition += xDir;
				yPosition += yDir;

				if ((yPosition > WarInformation.WindowHeight || yPosition <= 0)) {
					yDir *= -1;
				} else if (xPosition > WarInformation.WindowWidth || xPosition < 0) {
					xDir *= -1;
				}
			} else {
				if (destructionPeriod == 0) {
					war.remove(this);
				} else {
					destructionPeriod--;
				}
			}
		} else {
			move();
		}
	}

	@Override
	public String getId() {
		return id;
	}
}
