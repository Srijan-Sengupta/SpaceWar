package com.Srijan.java.SpaceWar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpaceWar extends JPanel implements WarInformation, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Level level;
	private SpaceShuttle spaceShuttle;
	private ArrayList<SpaceObjects> objects = new ArrayList<>();
	private int points = 0;
	private ArrayList<SpaceObjects> bullets = new ArrayList<>();
	private Timer timer;

	private Graphics2D g2d;

	private boolean gameOver;
	private SoundEffectPlayer player;

	private boolean gameWon = false;

	public SpaceWar() {
		spaceShuttle = new SpaceShuttle(this, WarInformation.spaceShuttleXPos, WarInformation.spaceShuttleYPos);
		objects.add(spaceShuttle);
		level = new Level1(this, objects);
		timer = new Timer(WarInformation.TimePeriod, this);
		timer.start();
		player = new SoundEffectPlayer();
		player.playBackgroundMusic();
	}

	public void remove(SpaceObjects object) {
		objects.remove(object);
		if (bullets.contains(object))
			bullets.remove(object);
		level.update();
		if (object instanceof GalaxyDestroyer) {
			gameWon = true;
			}
	}

	public void addBullets(SpaceObjects bullet) {
		objects.add(bullet);
		bullets.add(bullet);
		level.update();
	}

	public void keyPressed(int keyCode) {
		if (keyCode == KeyEvent.VK_LEFT) {
			spaceShuttle.setXdir(-1);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			spaceShuttle.setXdir(1);
		} else if (keyCode == KeyEvent.VK_SPACE) {
			spaceShuttle.shoot();
		}
	}

	public void keyReleased(int keyCode) {
		if (keyCode == KeyEvent.VK_LEFT) {
			spaceShuttle.setXdir(0);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			spaceShuttle.setXdir(0);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		this.g2d = g2d;
		ImageIcon icon = new ImageIcon(WarInformation.BACKGROUND_IMAGE_PATH_1);
		g2d.drawImage(icon.getImage(), 0, 0, WarInformation.WindowWidth, WarInformation.WindowHeight, null);
		
		if (gameWon) {
			gameWon();
		}
		else if (gameOver) {
			gameOver();
		} else {
			for (int i = 0; i < objects.size(); i++) {
				SpaceObjects o = objects.get(i);

				g2d.drawImage(o.getImageIcon().getImage(), o.xPosition, o.yPosition, o.getImageIcon().getIconWidth(),
						o.getImageIcon().getIconHeight(), null);
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public void checkCollision() {

		for (int i = 0; i < objects.size(); i++) {
			for (int j = 0; j < objects.size(); j++) {
				if (!(i == j)) {
					if (objects.get(i).getRectangle().intersects(objects.get(j).getRectangle())) {
						SpaceObjects o = objects.get(i);
						SpaceObjects o1 = objects.get(j);
						if (!(o.destroyed || o1.destroyed)) {
							if (!(o.getId().equals(o1.getId())) && (!o.getId().equals("space shuttle"))
									&& (!o1.getId().equals("space shuttle"))) {
								o.destroy();
								o1.destroy();
								points++;
								level.update();
								player.playExplosionSound();
							} else if (o.getId().equals("space shuttle") || o1.getId().equals("space shuttle")) {
								o.destroy();
								o1.destroy();
								level.update();
								player.playExplosionSound();
							}

						}
					}
				}
			}
		}
	}

	public ArrayList<SpaceObjects> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<SpaceObjects> objects) {
		this.objects = objects;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		checkCollision();
		level.doLevel();
		spaceShuttle.move();
		repaint();
		checkGameOver();
	}

	private void checkGameOver() {
		// TODO Auto-generated method stub
		if (spaceShuttle.destroyed) {
			gameOver = true;
		}
	}

	public void gameOver() {
		// TODO Auto-generated method stub
		timer.stop();
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(getFont().getFontName(), Font.BOLD, 50));
		g2d.drawString("Game over!", WindowWidth / 2 - 100, WindowHeight / 2);
		g2d.drawString("Score = " + points, WindowWidth / 2 - 100, WindowHeight / 2 + 100);
		player.stopMusic();
	}

	public void levelUp(Level level) {
		this.level = level;
		Graphics2D graphics2d = (Graphics2D) getGraphics();
		g2d = graphics2d;
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(getFont().getFontName(), Font.BOLD, 50));
		g2d.drawString(level.getLevelInformation(), 0, WindowHeight / 2);
		g2d.drawString("Score = " + points, WindowWidth / 2 - 100, WindowHeight / 2 + 50);
		g2d.drawString("Health = " + spaceShuttle.getHealth(), WindowWidth / 2 - 100, WindowHeight / 2 + 100);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SoundEffectPlayer getPlayer() {
		return player;
	}

	public void setPlayer(SoundEffectPlayer player) {
		this.player = player;
	}

	public void gameWon() {
		timer.stop();
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(getFont().getFontName(), Font.BOLD, 50));
		g2d.drawString("Congratulations! on Winning the war!", WindowWidth/4, WindowHeight/2);
		g2d.drawString("Your Score = " + points, WindowWidth/2-100, WindowHeight/2+100);
	}
}
