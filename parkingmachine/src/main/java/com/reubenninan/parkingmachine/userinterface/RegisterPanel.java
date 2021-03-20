package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class RegisterPanel extends JPanel {

	private JPanel contentPane;
	String firstName;
	String lastName;
	String email;
	String password;

	public RegisterPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("Registration Page", SwingConstants.CENTER);

		JPanel registerDetails = new JPanel();
		registerDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel firstLabel = new JLabel("First Name:");
		JTextField firstField = new JTextField(18);
		registerDetails.add(firstLabel);
		registerDetails.add(firstField);

		JLabel secondLabel = new JLabel("Last Name:");
		JTextField secondField = new JTextField(18);
		registerDetails.add(secondLabel);
		registerDetails.add(secondField);

		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(18);
		registerDetails.add(emailLabel);
		registerDetails.add(emailField);

		JLabel passwordLabel = new JLabel("Password:");
		JTextField passwordField = new JTextField(18);
		registerDetails.add(passwordLabel);
		registerDetails.add(passwordField);

		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(e -> {
			firstName = emailField.getText();
			lastName = passwordField.getText();
			System.out.println("First: " + firstName + "\nLast: " + lastName);
			email = emailField.getText();
			password = passwordField.getText();
			System.out.println("Email: " + email + "\nPassword: " + password);
		});
		registerDetails.add(registerButton);

		JButton homeButton = new JButton("Go Back Home");
		homeButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "home"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(homeButton);

		contentPane.add(label);
		contentPane.add(registerDetails);
		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
