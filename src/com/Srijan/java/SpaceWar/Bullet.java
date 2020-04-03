package com.Srijan.java.SpaceWar;

import javax.swing.ImageIcon;

public class Bullet extends SpaceObjects {

	private int yDir;
	private String id = "bullet";
	private int destructionPeriod = 1;

	public Bullet(SpaceWar spaceWar, int xPosition, int yPosition, int yDir) {
		super(spaceWar, new ImageIcon(WarInformation.BULLET_IMAGE_PATH), xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.yDir = yDir;
		spaceWar.getPlayer().playBulletSound();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (!destroyed) {
			yPosition += yDir;
			if (yPosition == 0) {
				destroyed = true;
				destroy();
			} else if (yPosition > WarInformation.WindowHeight + 200) {
				destroyed = true;
				destroy();
			}
		} else {
			if (destructionPeriod == 0) {
				war.remove(this);
			} else {
				destructionPeriod--;
			}
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
		//Can't Shoot as I am a bullet.
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//setImageIcon(new ImageIcon(WarInformation.EXPLOSION_IMAGE_PATH));
		destroyed = true;
	}

	@Override
	public String getId() {
		return id;
	}

}
