package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import services.*;

import javax.swing.*;

public class UserDashboardPanel extends JPanel {

	private JPanel contentPane;
	String firstName;
	String lastName;
	String email;
	String password;

	public UserDashboardPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("User Dashboard", SwingConstants.CENTER);

		JPanel registerDetails = new JPanel();
		registerDetails.setLayout(new GridLayout(0, 2, 2, 2));


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
