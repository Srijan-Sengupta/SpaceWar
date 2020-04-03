package com.Srijan.java.SpaceWar;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;

public class SoundEffectPlayer {

	private boolean playMusic = false;
	private Thread musicThread;

	public void playBackgroundMusic() {
		setPlayMusic(true);
		// System.out.print(WarInformation.GAME_SOUND);
		musicThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Clip clip;
					clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(WarInformation.GAME_SOUND);
					clip.open(inputStream);
					clip.start();
					Thread.sleep(1000 * 60 * 4);
					clip.stop();
					clip.close();
					playBackgroundMusic();
				} catch (LineUnavailableException | IOException | InterruptedException
						| UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		});
		musicThread.start();
	}

	public void playExplosionSound() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Clip clip;
					clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(WarInformation.EXPLOSION_SOUND);
					clip.open(inputStream);
					clip.start();
					Thread.sleep(5000);
					clip.stop();
					clip.close();
				} catch (LineUnavailableException | IOException | InterruptedException
						| UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}).start();
	}

	public void playBulletSound() {
		//System.out.print(WarInformation.GAME_SOUND);
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Clip clip;
					clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(WarInformation.BULLET_SOUND);
					clip.open(inputStream);
					clip.start();
					Thread.sleep(5000);
					clip.stop();
					clip.close();
				} catch (LineUnavailableException | IOException | InterruptedException
						| UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					//	e.printStackTrace();
				}
			}
		});
	}

	public void stopMusic() {
		// musicThread.stop();
		// musicThread.interrupt();
	}

	public boolean isPlayMusic() {
		return playMusic;
	}

	public void setPlayMusic(boolean playMusic) {
		this.playMusic = playMusic;
	}
}
