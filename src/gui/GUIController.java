package gui;

import java.awt.EventQueue;

import test.Test;

public class GUIController {
	private static Test t;

	public static Test getT() {
		return t;
	}

	public void setT(Test t) {
		GUIController.t = t;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					t = new Test();
					
					//t.testSingInThreads();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
