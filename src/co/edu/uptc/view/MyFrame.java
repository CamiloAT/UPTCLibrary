package co.edu.uptc.view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame(ActionListener listener) {
		super("UPTC Library");
		this.setSize(820, 620);
		this.initPanels(listener);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	private void initPanels(ActionListener listener) {

	}

}
