package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Delete extends JPanel {
	private JTextField isbnTextFIeld;
	private JLabel confDeleted;
	private JButton buttonDelete;
	
	public Delete(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(null);
		this.setPreferredSize(new Dimension(820,620));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 820, 98);
		headerPanel.setBackground(new Color(1,152,205,255));
		add(headerPanel);
		headerPanel.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Biblioteca UPTC");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(545, 36, 221, 35);
		headerPanel.add(lblNewLabel_1);
		
		ButtonRound buttonBack = new ButtonRound("Eliminar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonBack.setIcon(new ImageIcon("resource/libro-abierto.png"));
		buttonBack.setText("");
		buttonBack.setActionCommand("back");
		buttonBack.addActionListener(actionListener);
		buttonBack.setBounds(24, 11, 99, 76);
		headerPanel.add(buttonBack);
		
		JLabel tittleDelete = new JLabel("Eliminar libro");
		tittleDelete.setForeground(new Color(1, 152, 205));
		tittleDelete.setFont(new Font("Forte", Font.PLAIN, 30));
		tittleDelete.setBounds(326, 139, 225, 63);
		add(tittleDelete);
		
		JLabel information = new JLabel("Ingrese ISBN:");
		information.setForeground(new Color(1, 152, 205));
		information.setFont(new Font("Forte", Font.PLAIN, 20));
		information.setBounds(229, 244, 153, 28);
		add(information);
		
		isbnTextFIeld = new JTextField();
		isbnTextFIeld.setBounds(229, 283, 172, 20);
		add(isbnTextFIeld);
		isbnTextFIeld.setColumns(10);
		
		confDeleted = new JLabel("");
		confDeleted.setFont(new Font("Forte", Font.PLAIN, 17));
		confDeleted.setBounds(301, 338, 242, 20);
		add(confDeleted);
		
		buttonDelete = new ButtonRound("Eliminar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonDelete.setBounds(448, 277, 137, 32);
		buttonDelete.setActionCommand("delete");
		buttonDelete.addActionListener(actionListener);
		add(buttonDelete);
		
		JLabel iconLibrary = new JLabel("");
		iconLibrary.setBounds(451, 352, 312, 304);
		this.setImageLabel(iconLibrary, "resource/fondoLibros.jpeg");
		add(iconLibrary);

	}
	
	public String getISBN(){
		return isbnTextFIeld.getText();
	}
	
	public void setConfirDelete(boolean confirmation) {
		if (confirmation) {
			confDeleted.setText("Se ha eliminado correctamente.");
		} else {
			confDeleted.setText("Algo fallo. Vuelve a intentarlo.");
		}
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
