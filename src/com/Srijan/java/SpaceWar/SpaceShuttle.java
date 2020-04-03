package com.Srijan.java.SpaceWar;

import javax.swing.ImageIcon;

public class SpaceShuttle extends SpaceObjects {

	private int health = 5;
	private int power = 1;
	private int noOfBullet = 1;
	private String id = "space shuttle";

	public SpaceShuttle(SpaceWar spaceWar, int xPosition, int yPosition) {
		super(spaceWar, new ImageIcon(WarInformation.SPACE_SHUTTLE_IMAGE_PATH), xPosition, yPosition);
		// TODO Auto-generated constructor stub
		xDir = 0;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		xPosition += xDir;
		if (xPosition <= 0) {
			xPosition = 0;
		} else if (xPosition > WarInformation.WindowWidth - getImageIcon().getIconWidth()) {
			xPosition = WarInformation.WindowWidth - getImageIcon().getIconWidth();

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
		war.addBullets(new Bullet(war, xPosition + (getImageIcon().getIconWidth()) / 2, yPosition - 100, -power));

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		health--;
		if (health == 0) {
			setImageIcon(new ImageIcon(WarInformation.EXPLOSION_IMAGE_PATH));
			destroyed = true;
		}
	}

	public int getXdir() {
		return xDir;
	}

	public void setXdir(int xDir) {
		this.xDir = xDir;
	}

	@Override
	public String getId() {
		return id;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getNoOfBullet() {
		return noOfBullet;
	}

	public void setNoofBullet(int noofBullet) {
		this.noOfBullet = noofBullet;
	}

}
