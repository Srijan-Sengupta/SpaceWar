package com.Srijan.java.SpaceWar;

import javax.swing.ImageIcon;

public class ServentShip extends SpaceObjects {

	public ServentShip(SpaceWar spaceWar, int xPosition, int yPosition) {
		super(spaceWar, new ImageIcon(WarInformation.SERVENT_SHIP_IMAGE_PATH), xPosition, yPosition);
		yDir = 1;
		xDir = 1;
	}

	private int counter = 0;

	private int c = 100;
	private String id = "servent";

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (yPosition >= 0) {

			if (!destroyed) {
				xPosition += xDir;
				yPosition += yDir;

				if (yPosition > 100) {
					yDir = 0;
					if (xPosition <= 0 || xPosition >= WarInformation.WindowWidth - getImageIcon().getIconWidth()) {
						xDir *= -1;
					}
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
			if (yPosition >= 101) {
				war.addBullets(new AlienBullet(war, xPosition + (getImageIcon().getIconWidth()) / 2, yPosition + 200, 3,
						xDir));
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		setImageIcon(new ImageIcon(WarInformation.EXPLOSION_IMAGE_PATH));
		destroyed = true;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
