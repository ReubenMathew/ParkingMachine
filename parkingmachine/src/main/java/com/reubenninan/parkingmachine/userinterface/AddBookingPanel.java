package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import services.*;

import javax.swing.*;

public class AddBookingPanel extends JPanel {

	private JPanel contentPane;

	public AddBookingPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("Add Booking Page", SwingConstants.CENTER);
		
		Database db = Database.getInstance();

		JPanel addBookingDetails = new JPanel();
		addBookingDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel spaceNumberLabel = new JLabel("Parking Space Number:");
		JTextField spaceNumberField = new JTextField(18);
		addBookingDetails.add(spaceNumberLabel);
		addBookingDetails.add(spaceNumberField);
		
		JLabel plateLabel = new JLabel("License Plate:");
		JTextField plateField = new JTextField(18);
		addBookingDetails.add(plateLabel);
		addBookingDetails.add(plateField);
		
		JLabel bookingTimeLabel = new JLabel("Booking Time:");
		JTextField bookingTimeField = new JTextField(18);
		addBookingDetails.add(bookingTimeLabel);
		addBookingDetails.add(bookingTimeField);


		JButton addBookingButton = new JButton("Book");
		addBookingButton.addActionListener(e -> {
			int bookingTime = Integer.parseInt(bookingTimeField.getText());
			String licensePlate = plateField.getText();
			int parkingSpace = Integer.parseInt(spaceNumberField.getText());
			db.addBooking(bookingTime, licensePlate, parkingSpace, LoginPanel.user.getEmail());
		});
		addBookingDetails.add(addBookingButton);

		JButton homeButton = new JButton("Go Back");
		homeButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "userDashboard"));

		JPanel homeBtnPanel = new JPanel();
		homeBtnPanel.add(homeButton);

		contentPane.add(label);
		contentPane.add(addBookingDetails);
		contentPane.add(homeBtnPanel, BorderLayout.SOUTH);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

}
