package co.edu.uptc.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import co.edu.uptc.model.Book;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField isbnTextField;
	private JTable searchTable;
	private JScrollPane scrollPanel;
	private DefaultTableModel tableModel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblCodigoJsbn;
	private JLabel lblSede;
	private JLabel lblBiblioteca;
	private JButton buttonSearch;
	private JButton buttonBack;
	private JComboBox<String> headquartersComboBox;

	public SearchPanel(ActionListener actionListener) {
		setBackground(new Color(1, 152, 205, 255));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 820, 105);
		panel.setBackground(new Color(1, 152, 205, 255));
		add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 105, 820, 208);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Buscar libro");
		lblNewLabel.setForeground(new Color(1, 152, 205));
		lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 30));
		lblNewLabel.setBounds(320, 10, 166, 34);
		panel_1.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre Del Libro");
		lblNombre.setForeground(new Color(1, 152, 205));
		lblNombre.setFont(new Font("Forte", Font.PLAIN, 30));
		lblNombre.setBounds(20, 64, 225, 34);
		panel_1.add(lblNombre);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(20, 108, 235, 28);
		panel_1.add(nameTextField);
		nameTextField.setColumns(10);
		
		lblCodigoJsbn = new JLabel("Codigo ISBN");
		lblCodigoJsbn.setForeground(new Color(1, 152, 205));
		lblCodigoJsbn.setFont(new Font("Forte", Font.PLAIN, 30));
		lblCodigoJsbn.setBounds(290, 64, 183, 34);
		panel_1.add(lblCodigoJsbn);
		
		isbnTextField = new JTextField();
		isbnTextField.setColumns(10);
		isbnTextField.setBounds(290, 108, 235, 28);
		panel_1.add(isbnTextField);
		
		lblSede = new JLabel("Sede");
		lblSede.setForeground(new Color(1, 152, 205));
		lblSede.setFont(new Font("Forte", Font.PLAIN, 30));
		lblSede.setBounds(555, 64, 183, 34);
		panel_1.add(lblSede);
		
		headquartersComboBox = new JComboBox<String>();
		headquartersComboBox.setBounds(555, 108, 235, 28);
		panel_1.add(headquartersComboBox);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 318, 820, 302);
		add(panel_2);
		panel_2.setLayout(null);
		panel.setLayout(null);
		
		lblBiblioteca = new JLabel("Biblioteca UPTC");
		lblBiblioteca.setBounds(545, 36, 221, 35);
		lblBiblioteca.setForeground(new Color(255, 255, 255));
		lblBiblioteca.setFont(new Font("Forte", Font.PLAIN, 30));
		panel.add(lblBiblioteca);

		buttonBack = new ButtonRound("", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonBack.setIcon(new ImageIcon("resource/libro-abierto.png"));
		buttonBack.setActionCommand("back");
		buttonBack.addActionListener(actionListener);
		buttonBack.setBounds(24, 11, 99, 76);
		panel.add(buttonBack);
		
		buttonSearch = new ButtonRound("Añadir", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonSearch.setText("Buscar");
		buttonSearch.setBounds(290, 155, 238, 36);
		buttonSearch.setActionCommand("searchBook");
		buttonSearch.addActionListener(actionListener);
		panel_1.add(buttonSearch);
		
		String[] tittles = {"Isbn", "Nombre", "Sede", "Volumen", "Autor"};
		searchTable = new MyTable(null, tittles,5);
		scrollPanel = new JScrollPane(searchTable);
		scrollPanel.getVerticalScrollBar().setUI(new MyScroll());
		scrollPanel.setBounds(10, 10, 800, 282);
		panel_2.add(scrollPanel);
	}
	
	public String getNameToSearch() {
		return nameTextField.getText();
	}
	
	public String getIsbnToSearch() {
		return isbnTextField.getText();
	}
	
	public void fillComboBox(ArrayList<String> sedes) {
		headquartersComboBox.removeAllItems();
		for (int i = 0; i < sedes.size(); i++) {
			headquartersComboBox.addItem(sedes.get(i));
		}
	}

	public String getWoldCombo() {
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
		tableModel = (DefaultTableModel) searchTable.getModel();
		tableModel.addRow(new Object[] {""+book.getISBN(), book.getTittle(), ""+book.getSede(), ""+book.getVolume(), ""+book.getAuthor()});
	}
}
