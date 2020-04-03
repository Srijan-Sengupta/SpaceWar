package com.srijan.java.SpaceWar.support;

import com.Srijan.java.SpaceWar.WarInformation;

public class Main {

	public static void main(String[] args) {
		System.out.println(WarInformation.GAME_SOUND);
		System.out.println(WarInformation.BULLET_SOUND);
		System.out.println(WarInformation.EXPLOSION_SOUND);
		System.out.println(WarInformation.ALIEN_BULLET_IMAGE_PATH);
		System.out.println(WarInformation.BACKGROUND_IMAGE_PATH_1);
		System.out.println(WarInformation.SPACE_SHUTTLE_IMAGE_PATH);
		System.out.println(WarInformation.BACKGROUND_IMAGE_OF_WELCOME);
		System.out.println("All checked!");

		WelcomeWindow welcomeWindow = new WelcomeWindow();

		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				welcomeWindow.setVisible(true);
			}
		});
		/*
		 * SpaceWar spaceWar = new SpaceWar(); Platform platform = new
		 * Platform(spaceWar);
		 * 
		 * java.awt.EventQueue.invokeLater(new Runnable() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * platform.setVisible(true); if (!platform.isVisible()) {
		 * platform.getSpaceWar().getPlayer().stopMusic(); } } });
		 * //platform.getSpaceWar().getPlayer().stopMusic();
		 */
	}

}
