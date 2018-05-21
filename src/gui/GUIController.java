package gui;

import java.awt.EventQueue;

import music.Synchronizer;
import test.Test;

public class GUIController {
	private static Test t;
	private static Synchronizer s;
	public static Synchronizer getS() {
		return s;
	}
	public static Test getT() {
		return t;
	}

	public static void setT(Test t) {
		GUIController.t = t;
	}
	public void setS(Synchronizer s) {
		GUIController.s = s;
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
