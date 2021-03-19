package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class RegisterPanel extends JPanel {

	private JPanel contentPane;
	private JLabel label;
	private JButton homeButton;

	public RegisterPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1));

		label = new JLabel("Register", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		homeButton = new JButton("Home");
		homeButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "home"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(homeButton);

		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
