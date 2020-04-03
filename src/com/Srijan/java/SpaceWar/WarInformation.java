package com.Srijan.java.SpaceWar;

import java.net.URL;

public interface WarInformation {

	int WindowWidth = 1850;
	int WindowHeight = 1000;
	int spaceShuttleXPos = 500;
	int spaceShuttleYPos = 800;
	int TimePeriod = 7;

	URL BULLET_IMAGE_PATH = ClassLoader.getSystemResource("res/Bullet.png");
	URL EXPLOSION_IMAGE_PATH = ClassLoader.getSystemResource("res/explosion.png");
	URL BACKGROUND_IMAGE_PATH_1 = ClassLoader.getSystemResource("res/BackgroundImageForgame.png");

	URL SERVENT_SHIP_IMAGE_PATH = ClassLoader.getSystemResource("res/Servant.png");
	URL ASTEROID_IMAGE_PATH = ClassLoader.getSystemResource("res/Rock.png");
	URL SPACE_SHUTTLE_IMAGE_PATH = ClassLoader.getSystemResource("res/SpaceShip1.png");
	URL TIE_FIGHTER_IMAGE_PATH = ClassLoader.getSystemResource("res/Servant1.png");
	URL STAR_DESTROYER_IMAGE_PATH = ClassLoader.getSystemResource("res/SpaceShip2.png");
	URL GALAXY_DESTROYER_IMAGE_PATH = ClassLoader.getSystemResource("res/StarDestroyer.png");
	URL ALIEN_BULLET_IMAGE_PATH = ClassLoader.getSystemResource("res/bullet.png");

	URL GAME_SOUND = ClassLoader.getSystemResource("res/TAKE07.WAV");
	URL EXPLOSION_SOUND = ClassLoader.getSystemResource("res/TAKE08.WAV");
	URL BULLET_SOUND = ClassLoader.getSystemResource("res/TAKE09.WAV");

	URL BACKGROUND_IMAGE_OF_WELCOME = ClassLoader.getSystemResource("res/WelcomeWindow.png");
}
