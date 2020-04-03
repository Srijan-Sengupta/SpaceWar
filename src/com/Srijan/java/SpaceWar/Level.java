package com.Srijan.java.SpaceWar;

import java.security.SecureRandom;

public interface Level {

	SecureRandom random = new SecureRandom();

	void update();

	void doLevel();

	String getLevelInformation();
}
