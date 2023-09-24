package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.model.Book;

public class MyFrame extends JFrame {
	private final static String MENU = "menu";
	private final static String ADD = "add";
	private final static String DELETE = "delete";
	private final static String SEARCH = "search";
	private final static String LIST = "list";
	private Menu menu;
	private PanelAddBook panelAddBook;
	private Delete deletePanel;
	private SearchPanel searchPanel;
	private ListPanel listPanel;
	private JPanel cardLayout;

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
		menu = new Menu(listener);
		panelAddBook = new PanelAddBook(listener);
		deletePanel = new Delete(listener);
		searchPanel = new SearchPanel(listener);
		listPanel = new ListPanel(listener);

		cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());
		cardLayout.setBounds(0, 0, this.getWidth(), this.getHeight());
		cardLayout.add(menu, MENU);
		cardLayout.add(panelAddBook, ADD);
		cardLayout.add(deletePanel, DELETE);
		cardLayout.add(searchPanel, SEARCH);
		cardLayout.add(listPanel, LIST);
		add(cardLayout);

	}

	public void setConfirDelete(boolean confirmation) {
		deletePanel.setConfirDelete(confirmation);
	}

	public String getIsbnDelete(){
		return deletePanel.getISBN();
	}
	
	public void fillDeleteComboBox(ArrayList<String> sedes) {
		this.deletePanel.fillComboBox(sedes);
	}

	public String getWoldComboDelete() {
		return deletePanel.getWoldComboDelete();
	}

	public String getNameToSearch() {
		return this.searchPanel.getNameToSearch();
	}

	public String getIsbnToSearch() {
		return this.searchPanel.getIsbnToSearch();
	}

	public void fillSearchComboBox(ArrayList<String> sedes) {
		this.searchPanel.fillComboBox(sedes);
	}

	public String getWorldSearchComboBox() {
		return this.searchPanel.getWoldCombo();
	}

	public void fillSearchTable(ArrayList<Book> books) {
		this.searchPanel.fillTable(books);
	}
	
	public void addSearchRow(Book book) {
		this.searchPanel.addRow(book);
	}

	public void fillListComboBox(ArrayList<String> sedes) {
		this.listPanel.fillComboBox(sedes);
	}

	public String getWorldListComboBox() {
		return this.listPanel.getWorldCombo();
	}

	public void fillListTable(ArrayList<Book> books) {
		this.listPanel.fillTable(books);
	}
	
	public void setConfirAdd(boolean confirmation) {
		panelAddBook.setConfirAdd(confirmation);
	}
	public String getSpaceNameBook() {
		return panelAddBook.getSpaceNameBook();
	}
	public String getSpaceCode() {
		return panelAddBook.getSpaceCode();
	}
	public String getSpaceVolume() {
		return panelAddBook.getSpaceVolume();
	}
	public String getSpaceEditorial() {
		return panelAddBook.getSpaceEditorial();
	}
	public String getSpaceNameAuthor() {
		return panelAddBook.getSpaceNameAuthor();
	}
	public String getSpaceLastName() {
		return panelAddBook.getSpaceLastName();
	}
	public void fillCbSedes(ArrayList<String> sedes) {
		panelAddBook.fillCbSedes(sedes);
	}
	public String getPalabraCombo() {
		return panelAddBook.getPalabraCombo();
	}
	public String getDescriptionTextArea() {
		return panelAddBook.getDescriptionTextArea();
	}

	public void showMenu() {
		CardLayout card = (CardLayout) (cardLayout.getLayout());
		card.show(cardLayout, MENU);
	}

	public void showAdd() {
		CardLayout card = (CardLayout) (cardLayout.getLayout());
		card.show(cardLayout, ADD);
	}

	public void showDelete() {
		CardLayout card = (CardLayout) (cardLayout.getLayout());
		card.show(cardLayout, DELETE);
	}

	public void showSearch() {
		CardLayout card = (CardLayout) (cardLayout.getLayout());
		card.show(cardLayout, SEARCH);
	}

	public void showList() {
		CardLayout card = (CardLayout) (cardLayout.getLayout());
		card.show(cardLayout, LIST);
	}



}
