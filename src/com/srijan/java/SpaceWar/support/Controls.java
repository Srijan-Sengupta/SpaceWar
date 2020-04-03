package com.srijan.java.SpaceWar.support;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Controls extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String instructionString = "Hello Worriors!\n\n"
			+ "use your left arrow on the keyboard < to move the ship left\n\n"
			+ "use your right arrow on the keyboard > to move the ship right\n\n"
			+ "use your space bar on the keyboard to shoot fire";

	JTextArea area = new JTextArea(instructionString);

	public Controls() {
		super("Space war controls");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(area);
		area.setFont(new Font("Ubuntu", Font.PLAIN, 40));
		setSize(1500, 600);
		area.setEditable(false);
	}
}
