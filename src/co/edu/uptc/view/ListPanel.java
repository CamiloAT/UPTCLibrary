package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.model.Book;

public class ListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable listTable;
	private JScrollPane scrollPanel;
	private DefaultTableModel tableModel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_1_1;
	private JLabel lblNewLabel;
	private JLabel lblSede;
	private JLabel lblBiblioteca;
	private JButton buttonList;
	private JButton buttonBack;
	private JComboBox<String> headquartersComboBox;
	
	public ListPanel(ActionListener actionListener) {
		setBackground(new Color(1, 152, 205, 255));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 820, 105);
		panel.setBackground(new Color(1, 152, 205));
		add(panel);
		panel.setLayout(null);
		
		lblBiblioteca = new JLabel("Biblioteca UPTC");
		lblBiblioteca.setBounds(545, 36, 221, 35);
		lblBiblioteca.setForeground(new Color(255, 255, 255));
		lblBiblioteca.setFont(new Font("Forte", Font.PLAIN, 30));
		panel.add(lblBiblioteca);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 105, 820, 140);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Listar Libros");
		lblNewLabel.setForeground(new Color(1, 152, 205));
		lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 30));
		lblNewLabel.setBounds(320, 10, 166, 34);
		panel_1.add(lblNewLabel);
		
		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 248, 820, 372);
		add(panel_1_1);
		
		lblSede = new JLabel("Sede");
		lblSede.setForeground(new Color(1, 152, 205));
		lblSede.setFont(new Font("Forte", Font.PLAIN, 30));
		lblSede.setBounds(146, 54, 183, 34);
		panel_1.add(lblSede);
		
		headquartersComboBox = new JComboBox<String>();
		headquartersComboBox.setBounds(146, 99, 235, 28);
		panel_1.add(headquartersComboBox);
		
		buttonBack = new ButtonRound("", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonBack.setIcon(new ImageIcon("resource/libro-abierto.png"));
		buttonBack.setActionCommand("back");
		buttonBack.addActionListener(actionListener);
		buttonBack.setBounds(24, 11, 99, 76);
		panel.add(buttonBack);
		
		buttonList = new ButtonRound("Listar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonList.setText("Listar");
		buttonList.setBounds(457, 95, 238, 36);
		buttonList.setActionCommand("listBooks");
		buttonList.addActionListener(actionListener);
		panel_1.add(buttonList);
		
		buttonBack = new ButtonRound("", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonBack.setIcon(new ImageIcon("resource/libro-abierto.png"));
		buttonBack.setActionCommand("back");
		buttonBack.addActionListener(actionListener);
		buttonBack.setBounds(24, 11, 99, 76);
		panel.add(buttonBack);
		
		String[] tittles = {"Isbn", "Nombre", "Sede", "Volumen", "Autor"};
		listTable = new MyTable(null, tittles,5);
		scrollPanel = new JScrollPane(listTable);
		scrollPanel.getVerticalScrollBar().setUI(new MyScroll());
		scrollPanel.setBounds(10, 10, 800, 352);
		panel_1_1.add(scrollPanel);
	}

	public void fillComboBox(ArrayList<String> sedes) {
		headquartersComboBox.removeAllItems();
		for (int i = 0; i < sedes.size(); i++) {
			headquartersComboBox.addItem(sedes.get(i));
		}
	}

	public String getWorldCombo() {
		String word = (String) headquartersComboBox.getSelectedItem();
		return word;
	}
	
	public void fillTable(ArrayList<Book> books){
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			this.addRow(book);
		}
	}
	
	public void addRow(Book book) {
		tableModel = (DefaultTableModel) listTable.getModel();
		tableModel.addRow(new Object[] {""+book.getISBN(), book.getTittle(), ""+book.getSede(), ""+book.getVolume(), ""+book.getAuthor()});
	}
}
