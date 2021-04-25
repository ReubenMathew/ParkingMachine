package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class HomePanel extends JPanel {

	private JPanel contentPane;

	public HomePanel() {

		JLabel label;

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1));

		label = new JLabel("Home Screen", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "login"));

		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "register"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(loginButton);
		homeBtnPanel.add(registerButton);

		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
