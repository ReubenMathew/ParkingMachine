package com.reubenninan.parkingmachine.userinterface;

import java.awt.*;
import javax.swing.*;

public class AddOfficerPanel extends JPanel {

	private JPanel contentPane;

	public AddOfficerPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("Add Parking Officer", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JPanel addOfficerDetails = new JPanel();
		addOfficerDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel firstLabel = new JLabel("First Name:");
		JTextField firstField = new JTextField(18);
		addOfficerDetails.add(firstLabel);
		addOfficerDetails.add(firstField);

		JLabel secondLabel = new JLabel("Last Name:");
		JTextField secondField = new JTextField(18);
		addOfficerDetails.add(secondLabel);
		addOfficerDetails.add(secondField);

		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(18);
		addOfficerDetails.add(emailLabel);
		addOfficerDetails.add(emailField);

		JLabel passwordLabel = new JLabel("Password:");
		JTextField passwordField = new JTextField(18);
		addOfficerDetails.add(passwordLabel);
		addOfficerDetails.add(passwordField);

		JButton addOfficerButton = new JButton("Add Officer");

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
