package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Frame() {
		this.setTitle("Account Creator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStart = new JButton("Start");
		JLabel lblEmail = new JLabel("Email: ");
		JTextField tfEmail = new JTextField();
		
	}
	
}
