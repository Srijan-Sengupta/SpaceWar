package com.srijan.java.SpaceWar.support;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.Srijan.java.SpaceWar.Platform;
import com.Srijan.java.SpaceWar.SpaceWar;
import com.Srijan.java.SpaceWar.WarInformation;

public class WelcomeWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenuBar menuBar = new JMenuBar();

	JMenu help = new JMenu("Help");

	JMenuItem about = new JMenuItem("About");
	JMenuItem instruction = new JMenuItem("Instruction");
	JMenuItem controls = new JMenuItem("Control");

	JLabel label = new JLabel("       Join the Space War and become a Hero.");

	JButton startButton = new JButton("Start");
	JButton instrictionButton = new JButton("Instruction");
	JButton controlButton = new JButton("Controls");
	JButton exitButton = new JButton("Exit");

	ImageIcon background = new ImageIcon(WarInformation.BACKGROUND_IMAGE_OF_WELCOME);

	public WelcomeWindow() {
		super("Space War Game");
		setIconImage(new ImageIcon(WarInformation.SPACE_SHUTTLE_IMAGE_PATH).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setResizable(false);
		setSize(1000, 700);
		setLocationByPlatform(true);

		setBackground(Color.BLACK);

		setFont((new Font("Ubuntu", Font.PLAIN, 40)));
		menuBar.add(help);
		help.add(about);
		help.addSeparator();
		help.add(controls);
		help.addSeparator();
		help.add(instruction);

		setJMenuBar(menuBar);

		setLayout(new GridLayout(5, 1, 50, 50));

		add(label);
		add(startButton);
		add(instrictionButton);
		add(controlButton);
		add(exitButton);

		label.setFont(new Font("Ubuntu", Font.PLAIN, 40));
		startButton.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		instrictionButton.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		controlButton.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		exitButton.setFont(new Font("Ubuntu", Font.PLAIN, 30));

		startButton.addActionListener(this);
		instrictionButton.addActionListener(this);
		controlButton.addActionListener(this);
		exitButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(startButton)) {
			SpaceWar war = new SpaceWar();
			Platform platform = new Platform(war);

			java.awt.EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					platform.setVisible(true);
					dispose();
				}
			});
		}

		if (e.getSource().equals(controlButton)) {
			Controls controls = new Controls();
			controls.setVisible(true);
		}
		if (e.getSource().equals(instrictionButton)) {
			Instruction instruction = new Instruction();
			instruction.setVisible(true);
		}
		if (e.getSource().equals(exitButton)) {
			System.exit(0);
		}
	}

}
