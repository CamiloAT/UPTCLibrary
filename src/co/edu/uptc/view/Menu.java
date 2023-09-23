package co.edu.uptc.view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Menu extends JPanel {
	private JButton buttonDelete;
	
	public Menu(ActionListener actionListener) {
		setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(820,620));
		setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 820, 98);
		headerPanel.setBackground(new Color(1, 152, 205));
		add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel tittleMenu = new JLabel("MENU");
		tittleMenu.setForeground(new Color(1, 152, 205));
		tittleMenu.setFont(new Font("Forte", Font.PLAIN, 60));
		tittleMenu.setBounds(327, 129, 200, 73);
		add(tittleMenu);
		
		buttonDelete = new ButtonRound("Eliminar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonDelete.setActionCommand("deleteMenu");
		buttonDelete.addActionListener(actionListener);
		buttonDelete.setBounds(147, 302, 200, 57);
		add(buttonDelete);
		
		ButtonRound buttonAdd = new ButtonRound("Añadir", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonAdd.setActionCommand("addMenu");
		buttonAdd.addActionListener(actionListener);
		buttonAdd.setBounds(147, 234, 200, 57);
		add(buttonAdd);
		
		ButtonRound buttonList = new ButtonRound("Listar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonList.setActionCommand("listMenu");
		buttonList.addActionListener(actionListener);
		buttonList.setBounds(147, 438, 200, 57);
		add(buttonList);
		
		ButtonRound buttonSearch = new ButtonRound("Buscar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonSearch.setActionCommand("searchMenu");
		buttonSearch.addActionListener(actionListener);
		buttonSearch.setBounds(147, 370, 200, 57);
		add(buttonSearch);
		
		JLabel iconLibrary = new JLabel("");
		iconLibrary.setBounds(452, 234, 267, 279);
		this.setImageLabel(iconLibrary, "resource/pilaLibros.jpeg");
		add(iconLibrary);
	}
	
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}