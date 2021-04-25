package com.reubenninan.parkingmachine.userinterface;

import java.awt.*;
import javax.swing.*;

import services.Database;

public class AddOfficerPanel extends JPanel {

	private JPanel contentPane;

	public AddOfficerPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("Add Parking Officer", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JPanel addOfficerDetails = new JPanel();
		addOfficerDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(18);
		addOfficerDetails.add(emailLabel);
		addOfficerDetails.add(emailField);

		JLabel passwordLabel = new JLabel("Password:");
		JTextField passwordField = new JTextField(18);
		addOfficerDetails.add(passwordLabel);
		addOfficerDetails.add(passwordField);

		JButton addOfficerButton = new JButton("Add Officer");
		
		Database db = Database.getInstance();
	
		addOfficerButton.addActionListener(e -> {
			String email = emailField.getText();
			String password = passwordField.getText();
			db.addNewOfficer(email, password);
			MainFrame.cardLayout.show(MainFrame.main, "adminDashboard");
		});

		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "manageOfficer"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(addOfficerButton);
		homeBtnPanel.add(backButton);

		contentPane.add(addOfficerDetails);
		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
