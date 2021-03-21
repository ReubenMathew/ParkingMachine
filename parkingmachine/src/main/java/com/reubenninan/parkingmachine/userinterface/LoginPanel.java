package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginPanel extends JPanel {

	private JPanel contentPane;
	private String email;
	private String password;

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

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> {
			email = emailField.getText();
			password = passwordField.getText();
			System.out.println("Email: " + email + "\nPassword: " + password);
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
