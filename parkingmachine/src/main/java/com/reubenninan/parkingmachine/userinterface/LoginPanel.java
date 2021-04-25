package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import services.Database;
import util.User;

public class LoginPanel extends JPanel {

	private JPanel contentPane;
	private String email;
	private String password;

	private final String ADMIN_EMAIL = "admin@admin.com";
	private final String ADMIN_PASSWORD = "123abc";

	public static User user;

	public LoginPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 1));

		JLabel label = new JLabel("Login Page", SwingConstants.CENTER);

		JPanel loginDetails = new JPanel();
		loginDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel emailLabel = new JLabel("Login Email:");
		JTextField emailField = new JTextField(18);
		loginDetails.add(emailLabel);
		loginDetails.add(emailField);

		JLabel passwordLabel = new JLabel("Login Password:");
		JTextField passwordField = new JTextField(18);
		loginDetails.add(passwordLabel);
		loginDetails.add(passwordField);

		Database db = Database.getInstance();

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> {
			email = emailField.getText();
			password = passwordField.getText();

			// if admin then route to admin dashboard
			if (email.equals(ADMIN_EMAIL) && (password.equals(ADMIN_PASSWORD))) {
				MainFrame.cardLayout.show(MainFrame.main, "adminDashboard");
			} else
			// if officer then validate and route to officer dashboard
			if (db.validateOfficer(email, password)) {
				MainFrame.cardLayout.show(MainFrame.main, "officerDashboard");
			} else
			// if user then validate and route to user dashboard
			if (db.validateUser(email, password)) {
				user = db.getUser(email);
				MainFrame.cardLayout.show(MainFrame.main, "userDashboard");
			} else {
				// Login Error
			}
		});
		loginDetails.add(loginButton);

		JButton homeButton = new JButton("Go Back Home");
		homeButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "home"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(homeButton);

		contentPane.add(label);
		contentPane.add(loginDetails);
		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
