package com.reubenninan.parkingmachine.userinterface;

import java.awt.*;
import javax.swing.*;

import services.Database;

public class RemoveOfficerPanel extends JPanel {

	private JPanel contentPane;

	public RemoveOfficerPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("Remove Parking Officer", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JPanel addOfficerDetails = new JPanel();
		addOfficerDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(18);
		addOfficerDetails.add(emailLabel);
		addOfficerDetails.add(emailField);

		Database db = Database.getInstance();
		
		JButton removeOfficerButton = new JButton("Remove Officer");
		removeOfficerButton.addActionListener(e -> {
			String email = emailField.getText();
			db.removeOfficer(email);
			MainFrame.cardLayout.show(MainFrame.main, "adminDashboard");
		});

		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "manageOfficer"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(removeOfficerButton);
		homeBtnPanel.add(backButton);

		contentPane.add(addOfficerDetails);
		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
