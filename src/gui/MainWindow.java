package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelSouth;
	private JButton btnStart;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnClear;
	private JPanel westPanel1;
	private JPanel eastPanel1;



	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/note.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		setResizable(false);
		setTitle("Because the night");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		btnStop.setEnabled(false);
		contentPane.add(getWestPanel1(), BorderLayout.WEST);
		contentPane.add(getEastPanel1(), BorderLayout.EAST);
		Font f = new Font("Serif",Font.BOLD + Font.ITALIC, 14);
		textArea.setFont(f);
		textArea.setBackground(Color.lightGray);
		contentPane.setBackground(Color.lightGray);
		westPanel1.setBackground(Color.lightGray);
		eastPanel1.setBackground(Color.lightGray);
		panelSouth.setBackground(Color.lightGray);
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		//contentPane.add(getWestPanel(), BorderLayout.WEST);
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.add(getBtnStart());
			panelSouth.add(getBtnStop());
			panelSouth.add(getBtnClear());
		}
		return panelSouth;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.setPreferredSize(new Dimension(100, 23));
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.getT().initializeSingingInThreads(textArea);
					GUIController.getT().getPattiSmith().start();
					GUIController.getT().getBruceSpringsteen().start();
					GUIController.getT().getChoir().start();
					GUIController.getT().getGuitarSolo().start();
					btnStart.setEnabled(false);
					btnStop.setEnabled(true);
					
				}
			});
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.setPreferredSize(new Dimension(100, 23));
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIController.getT().getPattiSmith().setStopIt(true);
					GUIController.getT().getBruceSpringsteen().setStopIt(true);
					GUIController.getT().getChoir().setStopIt(true);
					GUIController.getT().getGuitarSolo().setStopIt(true);
					btnStart.setEnabled(true);
					btnStop.setEnabled(false);
				}
			});
		}
		return btnStop;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear");
			btnClear.setPreferredSize(new Dimension(100, 23));
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
				}
			});
		}
		return btnClear;
	}

	private JPanel getWestPanel1() {
		if (westPanel1 == null) {
			westPanel1 = new JPanel();
			westPanel1.setPreferredSize(new Dimension(200, 10));
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(this.getClass().getResource("/BS.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				Dimension d = new Dimension(200,500);
				picLabel.setPreferredSize(d);
				getWestPanel1().add(picLabel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return westPanel1;
	}
	private JPanel getEastPanel1() {
		if (eastPanel1 == null) {
			eastPanel1 = new JPanel();
			eastPanel1.setPreferredSize(new Dimension(200, 10));
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(this.getClass().getResource("/PS.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				Dimension d = new Dimension(200,500);
				picLabel.setPreferredSize(d);
				getEastPanel1().add(picLabel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return eastPanel1;
	}
	
}
