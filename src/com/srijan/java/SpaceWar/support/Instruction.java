package com.srijan.java.SpaceWar.support;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Instruction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String instructionString = "Hello Worriors!\n\n"
			+ "Welcome to this Space War. Join this game and win it.\n\n"
			+ "This game has been created by Srijan Sengupta a student of class X on 2020.\n\n"
			+ "In this game we have six levels, cross the hurdles and win it.\n\n"
			+ "You have to cross Asteroid field,destroy alien ships and many more.";

	JTextArea area = new JTextArea(instructionString);

	public Instruction() {
		super("Space war instruction");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(area);
		area.setFont(new Font("Ubuntu", Font.PLAIN, 40));
		setSize(1500, 600);
		area.setEditable(false);
	}
}
