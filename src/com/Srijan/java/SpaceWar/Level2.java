package com.Srijan.java.SpaceWar;

import java.util.ArrayList;

public class Level2 implements Level {
	
	private SpaceWar spaceWar;
	private ArrayList<SpaceObjects> objects = new ArrayList<>();

	public Level2(SpaceWar spaceWar, ArrayList<SpaceObjects> objects) {

		this.spaceWar = spaceWar;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				objects.add(new Asteroid(spaceWar, j * 170 + 30, i * random.nextInt(200) - 2000));
			}
		}
		this.objects = objects;
		spaceWar.setObjects(this.objects);
		update();
	}

	@Override
	public void doLevel() {
		// TODO Auto-generated method stub
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).moveHaphazard();
		}
		if (objects.size() == 1) {
			spaceWar.levelUp(new Level3(spaceWar, objects));
			spaceWar.setObjects(objects);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		objects = spaceWar.getObjects();

	}

	@Override
	public String getLevelInformation() {
		// TODO Auto-generated method stub
		return "                    Level 2 : Dangerous Asteroid field Ahead!";
	}

}
