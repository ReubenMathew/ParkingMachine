package com.reubenninan.parkingmachine.userinterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private JFrame frame;
	private int width = 600;
	private int height = 350;

	static protected JPanel main;
	static protected CardLayout cardLayout;

	public MainFrame() {
		frame = new JFrame("Parking Machine");
		frame.setSize(width, height);
		frame.setLayout(new GridLayout());

		main = new JPanel();

		JPanel home = new HomePanel().getContentPane();
		JPanel register = new RegisterPanel().getContentPane();
		JPanel login = new LoginPanel().getContentPane();
	
		cardLayout = new CardLayout();
		main.setLayout(cardLayout);

		main.add(home, "home");
		main.add(register, "register");
		main.add(login, "login");

		frame.add(main, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void start() {
		frame.setVisible(true);
	}

}
