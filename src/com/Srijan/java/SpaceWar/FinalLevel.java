package com.Srijan.java.SpaceWar;

import java.util.ArrayList;

public class FinalLevel implements Level {

	private SpaceWar spaceWar;
	private ArrayList<SpaceObjects> objects = new ArrayList<>();

	public FinalLevel(SpaceWar spaceWar, ArrayList<SpaceObjects> objects) {
		// TODO Auto-generated constructor stub
		this.objects = objects;
		this.spaceWar = spaceWar;
		this.objects.add(new GalaxyDestroyer(spaceWar, WarInformation.WindowWidth / 2 - 250, -500));
		spaceWar.setObjects(this.objects);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		objects = spaceWar.getObjects();
	}

	@Override
	public void doLevel() {
		// TODO Auto-generated method stub
		for (int i = 0; i < objects.size(); i++) {

			if (!objects.get(i).getId().equals("space shuttle")) {
				objects.get(i).shoot();
			}

			objects.get(i).moveHaphazard();

		}
		if (objects.size() == 1) {
			spaceWar.gameOver();
		}
	}

	@Override
	public String getLevelInformation() {
		// TODO Auto-generated method stub
		return "    Final Level : The Emperor himself comes to destroy you!";
	}
}
