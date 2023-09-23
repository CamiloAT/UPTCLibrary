package co.edu.uptc.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class PanelAddBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel tittle;
	private JPanel panelInfoAuthor;
	private ButtonRound btnAdd;
	private JLabel lblSede;
	private JLabel nameBook;
	private JLabel Volume;
	private JLabel isbn;
	private JLabel editorial;
	private JLabel nameAuthor;
	private JLabel lastNameAuthor;
	private JTextField spaceNameBook;
	private JTextField spaceCode;
	private JTextField spaceVolume;
	private JTextField spaceEditorial;
	private JTextField spaceNameAuthor;
	private JTextField spaceLastName;
	private JLabel lblBiblioteca;
	private JComboBox<String> cbSedes;
	private JTextArea descriptionTextArea;

	public PanelAddBook(ActionListener listener) {
		this.initComponents(listener);
		setBounds(100, 100, 820, 620);
		this.setSize(815, 586);
		setVisible(true);
		setLayout(null);

	}

	private void initComponents(ActionListener listener) {
		this.setBounds(409, 5, 813, 590);
		this.setBackground(new Color(1, 152, 205));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(1, 152, 205, 255));
		panelHeader.setBounds(0, 0, 816, 105);
		this.add(panelHeader);
		panelHeader.setLayout(null);

		lblBiblioteca = new JLabel("Biblioteca UPTC");
		lblBiblioteca.setForeground(new Color(255, 255, 255));
		lblBiblioteca.setFont(new Font("Forte", Font.PLAIN, 30));
		lblBiblioteca.setBounds(514, 34, 245, 42);
		panelHeader.add(lblBiblioteca);
		
		ButtonRound buttonBack = new ButtonRound("Eliminar", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		buttonBack.setText("");
		buttonBack.setActionCommand("back");
		buttonBack.setBounds(44, 19, 99, 76);
		panelHeader.add(buttonBack);

		Panel panelInfoBook = new Panel();
		panelInfoBook.setBackground(new Color(255, 255, 255));
		panelInfoBook.setBounds(0, 111, 816, 250);
		this.add(panelInfoBook);
		panelInfoBook.setLayout(null);

		tittle = new JLabel("Añadir Libro");
		tittle.setBounds(325, 10, 158, 42);
		tittle.setForeground(new Color(1, 152, 205, 255));
		panelInfoBook.add(tittle);
		tittle.setFont(new Font("Forte", Font.PLAIN, 30));

		nameBook = new JLabel("Nombre Del Libro");
		nameBook.setForeground(new Color(1, 152, 205));
		nameBook.setFont(new Font("Forte", Font.PLAIN, 24));
		nameBook.setBounds(58, 50, 235, 28);
		panelInfoBook.add(nameBook);

		Volume = new JLabel("Volumen");
		Volume.setForeground(new Color(1, 152, 205));
		Volume.setFont(new Font("Forte", Font.PLAIN, 24));
		Volume.setBounds(617, 50, 172, 28);
		panelInfoBook.add(Volume);

		isbn = new JLabel("Código ISBN");
		isbn.setForeground(new Color(1, 152, 205));
		isbn.setFont(new Font("Forte", Font.PLAIN, 24));
		isbn.setBounds(335, 50, 172, 28);
		panelInfoBook.add(isbn);

		editorial = new JLabel("Editorial");
		editorial.setForeground(new Color(1, 152, 205));
		editorial.setFont(new Font("Forte", Font.PLAIN, 24));
		editorial.setBounds(223, 124, 172, 28);
		panelInfoBook.add(editorial);

		spaceNameBook = new JTextField();
		spaceNameBook.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		spaceNameBook.setBounds(30, 86, 235, 28);
		panelInfoBook.add(spaceNameBook);
		spaceNameBook.setColumns(10);

		spaceCode = new JTextField();
		spaceCode.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		spaceCode.setBounds(296, 86, 235, 28);
		panelInfoBook.add(spaceCode);
		spaceCode.setColumns(10);

		spaceVolume = new JTextField();
		spaceVolume.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		spaceVolume.setColumns(10);
		spaceVolume.setBounds(554, 88, 235, 28);
		panelInfoBook.add(spaceVolume);

		spaceEditorial = new JTextField();
		spaceEditorial.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		spaceEditorial.setColumns(10);
		spaceEditorial.setBounds(166, 162, 235, 28);
		panelInfoBook.add(spaceEditorial);

		lblSede = new JLabel("Sede");
		lblSede.setBounds(535, 124, 172, 28);
		panelInfoBook.add(lblSede);
		lblSede.setForeground(new Color(1, 152, 205, 255));
		lblSede.setFont(new Font("Forte", Font.PLAIN, 24));

		cbSedes = new JComboBox<String>();
		cbSedes.setBounds(434, 162, 285, 28);
		panelInfoBook.add(cbSedes);
		cbSedes.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		cbSedes.setBackground(Color.white);

		panelInfoAuthor = new JPanel();
		panelInfoAuthor.setBackground(new Color(255, 255, 255));
		panelInfoAuthor.setBounds(0, 367, 816, 213);
		this.add(panelInfoAuthor);
		panelInfoAuthor.setLayout(null);

		nameAuthor = new JLabel("Nombre Del Autor");
		nameAuthor.setBounds(33, 19, 235, 34);
		nameAuthor.setForeground(new Color(1, 152, 205));
		nameAuthor.setFont(new Font("Forte", Font.PLAIN, 24));
		panelInfoAuthor.add(nameAuthor);

		lastNameAuthor = new JLabel("Apellido");
		lastNameAuthor.setForeground(new Color(1, 152, 205));
		lastNameAuthor.setFont(new Font("Forte", Font.PLAIN, 24));
		lastNameAuthor.setBounds(33, 89, 172, 28);
		panelInfoAuthor.add(lastNameAuthor);

		spaceNameAuthor = new JTextField();
		spaceNameAuthor.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		spaceNameAuthor.setColumns(10);
		spaceNameAuthor.setBounds(33, 51, 235, 28);
		panelInfoAuthor.add(spaceNameAuthor);

		spaceLastName = new JTextField();
		spaceLastName.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		spaceLastName.setColumns(10);
		spaceLastName.setBounds(33, 125, 235, 28);
		panelInfoAuthor.add(spaceLastName);

		JLabel description = new JLabel("Biografía");
		description.setBounds(308, 22, 172, 28);
		panelInfoAuthor.add(description);
		description.setForeground(new Color(1, 152, 205));
		description.setFont(new Font("Forte", Font.PLAIN, 24));

		btnAdd = new ButtonRound("Añadir", new Color(1, 152, 205), (String) null, new Dimension(238, 36));
		btnAdd.setBounds(550, 163, 238, 36);
		panelInfoAuthor.add(btnAdd);
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand("addBook");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 51, 483, 97);
		panelInfoAuthor.add(scrollPane);

		descriptionTextArea = new JTextArea();
		scrollPane.setViewportView(descriptionTextArea);
		descriptionTextArea.setBorder(new LineBorder(new Color(1, 152, 205), 1, true));
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
	}

	public String getSpaceNameBook() {
		return spaceNameBook.getText();
	}

	public String getSpaceCode() {
		return spaceCode.getText();
	}

	public String getSpaceVolume() {
		return spaceVolume.getText();
	}

	public String getSpaceEditorial() {
		return spaceEditorial.getText();
	}

	public String getSpaceNameAuthor() {
		return spaceNameAuthor.getText();
	}

	public String getSpaceLastName() {
		return spaceLastName.getText();
	}

	public void fillCbSedes(ArrayList<String> sedes) {
		cbSedes.removeAllItems();
		for (int i = 0; i < sedes.size(); i++) {
			cbSedes.addItem(sedes.get(i));
		}
	}

	public String getPalabraCombo() {
		String word = (String) cbSedes.getSelectedItem();
		return word;
	}

	public String getDescriptionTextArea() {
		return descriptionTextArea.getText();
	}
}
