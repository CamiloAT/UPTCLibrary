package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ExceptionPanel extends JDialog {
	private JLabel header;
	private JLabel footer;
	private JLabel message;
	private JLabel iconError;
	
	public ExceptionPanel(String exeText) {
		this.setTitle("CAUTION");
		this.setLayout(null);
		this.setSize(450,170);
		this.setLocationRelativeTo(this);
		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponents(exeText);
		this.setVisible(true);
	}
	
	private void initComponents(String exeText) {		
		header = new JLabel();
		header.setBounds(0, 0, this.getWidth(), (int)(this.getHeight()*0.20));
		setImageLabel(header, "resource/ExepHeader.png");
		add(header);
		
		iconError = new JLabel();
		iconError.setBounds(30, this.getHeight()/4, 50, 50);
		setImageLabel(iconError, "resource/caution.png");
		add(iconError);
		
		message = new JLabel(exeText);
		message.setFont(new Font("Forte", Font.PLAIN, 17));
		message.setBounds(this.getWidth()/2-120, this.getHeight()/2-40, 300, 50);
		add(message);
		
		footer = new JLabel();
		footer.setBounds(0, (int)(this.getHeight()*0.60), this.getWidth(), (int)(this.getHeight()*0.20));
		setImageLabel(footer, "resource/ExepFooter.png");
		add(footer);	
	}

	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
	
	public void paint(Graphics graphic) {
		super.paint(graphic);
		Graphics2D g2d = (Graphics2D) graphic;
		float[] dash = {10.0f};
		BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f);
		g2d.setStroke(dashed);
		g2d.setColor(new Color(13,128,106,100));
		g2d.drawLine(50, this.getHeight()-170, this.getWidth()-50, this.getHeight()-170);
	}
	
	
	
}
