package com.Srijan.java.SpaceWar;

import javax.swing.ImageIcon;

public class GalaxyDestroyer extends SpaceObjects {

	private int health = 100;

	public GalaxyDestroyer(SpaceWar spaceWar, int xPosition, int yPosition) {
		super(spaceWar, new ImageIcon(WarInformation.GALAXY_DESTROYER_IMAGE_PATH), xPosition, yPosition);
		yDir = 1;
		xDir = 1;
	}

	private int counter = 0;

	private int c = 100;
	private String id = "galaxy destroyer";

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (yPosition >= 0) {

			if (!destroyed) {
				yPosition += yDir;

				if (yPosition > -70) {
					yDir = 0;
					xDir = 0;
				}
			} else {
				if (c == 0) {
					war.remove(this);
				} else {
					c--;
				}
			}
		} else {
			yPosition++;
		}
	}

	@Override
	public void moveHaphazard() {
		// TODO Auto-generated method stub
		move();
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		counter++;
		if (!destroyed && counter == 40) {
			counter = 0;
			if (yPosition >= -20) {
				war.addBullets(
						new AlienBullet(war, xPosition + (getImageIcon().getIconWidth()), yPosition + 100, 3, xDir));
				war.addBullets(new AlienBullet(war, xPosition - 50, yPosition + 100, 3, xDir));

				war.addBullets(
						new AlienBullet(war, xPosition + (getImageIcon().getIconWidth()) + 100, yPosition + 100, 3, 1));
				war.addBullets(new AlienBullet(war, xPosition - 50, yPosition + 100 + 100, 3, -1));
				war.addBullets(
						new AlienBullet(war, xPosition + (getImageIcon().getIconWidth()), yPosition + 100, 3, 2));
				war.addBullets(new AlienBullet(war, xPosition - 50, yPosition + 100, 3, -2));
				war.addBullets(
						new AlienBullet(war, xPosition + (getImageIcon().getIconWidth()), yPosition + 100, 3, 3));
				war.addBullets(new AlienBullet(war, xPosition - 50, yPosition + 100, 3, -3));
				war.addBullets(new AlienBullet(war, xPosition + (getImageIcon().getIconWidth()) / 2,
						yPosition + getImageIcon().getIconHeight(), 1, 0));

			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		if (health == 0) {
			setImageIcon(new ImageIcon(WarInformation.EXPLOSION_IMAGE_PATH));
			destroyed = true;
		} else {
			health--;
		}
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
