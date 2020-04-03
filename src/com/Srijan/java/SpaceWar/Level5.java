package com.Srijan.java.SpaceWar;

import java.util.ArrayList;

public class Level5 implements Level {

	private SpaceWar spaceWar;
	private ArrayList<SpaceObjects> objects = new ArrayList<>();

	public Level5(SpaceWar spaceWar, ArrayList<SpaceObjects> objects) {
		// TODO Auto-generated constructor stub
		this.objects = objects;
		this.spaceWar = spaceWar;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 1; j++) {
				this.objects.add(new StarDestroyer(spaceWar, j * 500, (i * 400) - (i * 2000)));
			}
		}
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
			spaceWar.levelUp(new FinalLevel(spaceWar, objects));
		}
	}

	@Override
	public String getLevelInformation() {
		// TODO Auto-generated method stub
		return "  Level 5 : The Emperor is sending his ministers to destroy You!";
	}

}
