package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class HomePanel extends JPanel {

	private JPanel contentPane;
	private JLabel label;
	private JButton loginButton;
	private JButton registerButton;

	public HomePanel() {
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1));

		label = new JLabel("Home Screen", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		loginButton = new JButton("Login");
		loginButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "login"));

		registerButton = new JButton("Register");
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
