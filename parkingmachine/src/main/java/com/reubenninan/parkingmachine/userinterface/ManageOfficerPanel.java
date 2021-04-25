package com.reubenninan.parkingmachine.userinterface;

import java.awt.*;
import javax.swing.*;

public class ManageOfficerPanel extends JPanel {

	private JPanel contentPane;

	public ManageOfficerPanel() {
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1));

		JLabel label = new JLabel("Manage Parking Officers", SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);

		JButton addOfficerButton = new JButton("Add Officer");
		addOfficerButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "addOfficer"));

		JButton removeOfficerButton = new JButton("Remove Officer");
		removeOfficerButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "removeOfficer"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(addOfficerButton);
		homeBtnPanel.add(removeOfficerButton);
		
		JButton homeButton = new JButton("Go Back");
		homeButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "adminDashboard"));
		homeBtnPanel.add(homeButton);
		
		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
