package com.Srijan.java.SpaceWar;

import javax.swing.ImageIcon;

public class AlienBullet extends SpaceObjects {

	private int yDir;
	private int xDir;
	private String id = "alien bullet";
	private int c = 10;

	public AlienBullet(SpaceWar spaceWar, int xPosition, int yPosition, int ydir, int xDir) {
		super(spaceWar, new ImageIcon(WarInformation.ALIEN_BULLET_IMAGE_PATH), xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.yDir = ydir;
		this.xDir = xDir;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (!destroyed) {
			yPosition += yDir;
			if (yPosition >= WarInformation.WindowHeight) {
				destroyed = true;
				destroy();
			}
		} else {
			if (c == 0) {
				war.remove(this);
			} else {
				c--;
			}
		}
	}

	@Override
	public void moveHaphazard() {
		// TODO Auto-generated method stub
		if (!destroyed) {
			yPosition += yDir;
			xPosition += xDir;
			if (xPosition < 0 || xPosition > WarInformation.WindowWidth - getImageIcon().getIconWidth()) {
				xDir *= -1;
			}
			if (yPosition >= WarInformation.WindowHeight) {
				destroyed = true;
				destroy();
			}
		} else {
			if (c == 0) {
				war.remove(this);
			} else {
				c--;
			}
		}
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		setImageIcon(new ImageIcon(WarInformation.EXPLOSION_IMAGE_PATH));
		destroyed = true;
	}

	@Override
	public String getId() {
		return id;
	}

}
