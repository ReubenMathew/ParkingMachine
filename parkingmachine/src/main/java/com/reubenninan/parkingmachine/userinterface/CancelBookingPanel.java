package com.reubenninan.parkingmachine.userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import services.*;

import javax.swing.*;

public class CancelBookingPanel extends JPanel {

	private JPanel contentPane;

	public CancelBookingPanel() {

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(3, 0));

		JLabel label = new JLabel("Cancel Booking Page", SwingConstants.CENTER);

		Database db = Database.getInstance();

		JPanel addBookingDetails = new JPanel();
		addBookingDetails.setLayout(new GridLayout(0, 2, 2, 2));

		JLabel bookingNumberLabel = new JLabel("Booking Number:");
		JTextField bookingNumberField = new JTextField(18);
		addBookingDetails.add(bookingNumberLabel);
		addBookingDetails.add(bookingNumberField);

		JButton addBookingButton = new JButton("Cancel Booking");
		addBookingButton.addActionListener(e -> {
			db.removeBooking(Integer.parseInt(bookingNumberField.getText()));
		});
		addBookingDetails.add(addBookingButton);

		JButton homeButton = new JButton("Go Back Home");
		homeButton.addActionListener(e -> MainFrame.cardLayout.show(MainFrame.main, "home"));

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
