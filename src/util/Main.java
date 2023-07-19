package util;

import java.awt.EventQueue;

import view.StartPage;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new StartPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
