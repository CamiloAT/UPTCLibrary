package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.uptc.model.Author;
import co.edu.uptc.model.Book;
import co.edu.uptc.model.TreeAVL;
import co.edu.uptc.view.MyFrame;

public class Presenter implements ActionListener{

	private MyFrame frame;
	private TreeAVL tree;

	public Presenter() {
		frame = new MyFrame(this);
		tree = new TreeAVL();
		this.fillComboBoxes();
		this.addBooks();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		switch (source) {
		case "delete":
			frame.setConfirDelete(true);
			break;

		case "addMenu":
			frame.showAdd();
			break;

		case "deleteMenu":
			frame.showDelete();
			break;

		case "searchMenu":
			frame.showSearch();
			break;

		case "listMenu":
			frame.showList();
			break;

		case "back":
			frame.showMenu();
			break;
			
		case "searchBook":
			this.searchBook();
			break;
			
		case "listBooks":
			this.listBook();
			break;
		}
	}
	
	private void fillComboBoxes() {
		frame.fillSearchComboBox(tree.getSedes());
		frame.fillDeleteComboBox(tree.getSedes());
		frame.fillListComboBox(tree.getSedes());
		frame.fillCbSedes(tree.getSedes());
	}
	
	private void addBooks() {
		tree.insertar(new Book("Camilo", 1, "Volumen 4.5", "Ramiriqui's fundation", "Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
		tree.insertar(new Book("Años de soledad", 2, "Volumen 4.5", "Ramiriqui's fundation", "Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
		tree.insertar(new Book("Casa", 3, "Volumen 4.5", "Ramiriqui's fundation", "Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
		tree.insertar(new Book("Aerografo", 4, "Volumen 4.5", "Ramiriqui's fundation", "Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
	}
	
	private void searchBook() {
		if(!frame.getIsbnToSearch().equals("")) {
			ArrayList<Book> temporal = new ArrayList<>();
			temporal.add(tree.searchByISBN(Integer.parseInt(frame.getIsbnToSearch())));
			frame.fillSearchTable(temporal);
		}else if(!frame.getNameToSearch().equals("")) {
			frame.fillSearchTable(tree.searchByName(frame.getNameToSearch()));
		}else if(!frame.getWorldSearchComboBox().equals("Ninguno")) {
			frame.fillSearchTable(tree.searchBySede(frame.getWorldSearchComboBox()));
		}
	}
	
	private void listBook() {
		if(frame.getWorldListComboBox().equals("Ninguno")) {
			frame.fillListTable(tree.listAllBooks());
		}else{
			frame.fillListTable(tree.listBooksBySede(frame.getWorldListComboBox()));
		}
	}
	
	public static void main(String[] args) {
		new Presenter();
	}
}
