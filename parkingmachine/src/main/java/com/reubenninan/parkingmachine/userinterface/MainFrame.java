package com.reubenninan.parkingmachine.userinterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private JFrame frame;
	private int width = 720;
	private int height = 480;

	static protected JPanel main;
	static protected CardLayout cardLayout;

	public MainFrame() {
		frame = new JFrame("Parking Machine");
		frame.setSize(width, height);
		frame.setLayout(new GridLayout());

		main = new JPanel();

		JPanel home = new HomePanel().getContentPane();
		JPanel register = new RegisterPanel().getContentPane();
		JPanel login = new LoginPanel().getContentPane();
		JPanel manageOfficer = new ManageOfficerPanel().getContentPane();
		JPanel addOfficer = new AddOfficerPanel().getContentPane();
		JPanel removeOfficer = new RemoveOfficerPanel().getContentPane();
		JPanel userDashboard = new UserDashboardPanel().getContentPane();
		JPanel adminDashboard = new AdminDashboardPanel().getContentPane();
		JPanel officerDashboard = new OfficerDashboardPanel().getContentPane();
		JPanel addBooking = new AddBookingPanel().getContentPane();
		JPanel cancelBooking = new CancelBookingPanel().getContentPane();

		cardLayout = new CardLayout();
		main.setLayout(cardLayout);

		main.add(home, "home");
		main.add(register, "register");
		main.add(login, "login");
		main.add(manageOfficer, "manageOfficer");
		main.add(addOfficer, "addOfficer");
		main.add(removeOfficer, "removeOfficer");
		main.add(userDashboard, "userDashboard");
		main.add(adminDashboard, "adminDashboard");
		main.add(officerDashboard, "officerDashboard");
		main.add(addBooking, "addBooking");
		main.add(cancelBooking, "cancelBooking");

		frame.add(main, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void start() {
		frame.setVisible(true);
	}

}
