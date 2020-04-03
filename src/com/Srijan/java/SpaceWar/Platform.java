package com.Srijan.java.SpaceWar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Platform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SpaceWar spaceWar;

	public Platform(SpaceWar spaceWar) {
		setAutoRequestFocus(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		;
		this.setSpaceWar(spaceWar);
		add(spaceWar);
		setResizable(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				spaceWar.keyPressed(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				spaceWar.keyReleased(e.getKeyCode());
			}
		});

		setSize(WarInformation.WindowWidth, WarInformation.WindowHeight);
		setTitle("Space war by Srijan Sengupta");
		setIconImage(new ImageIcon(WarInformation.SPACE_SHUTTLE_IMAGE_PATH).getImage());
	}

	public SpaceWar getSpaceWar() {
		return spaceWar;
	}

	public void setSpaceWar(SpaceWar spaceWar) {
		this.spaceWar = spaceWar;
	}

}
