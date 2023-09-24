package co.edu.uptc.presenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import co.edu.uptc.model.Author;
import co.edu.uptc.model.Book;
import co.edu.uptc.model.TreeAVL;
import co.edu.uptc.view.ExceptionPanel;
import co.edu.uptc.view.MyFrame;

public class Presenter implements ActionListener {

	private MyFrame frame;
	private TreeAVL tree;
	ExceptionPanel exceptionPanel;

	public Presenter() {
		frame = new MyFrame(this);
		tree = new TreeAVL();

		this.addBooks();
		this.fillComboBoxes();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		
		switch (source) {
		case "addBook":
			this.addBook();
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

		case "delete":
			this.deleteBook();
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
		tree.insertar(new Book("Camilo", 1, "Volumen 4.5", "Ramiriqui's fundation",
				"Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
		tree.insertar(new Book("Años de soledad", 2, "Volumen 4.5", "Ramiriqui's fundation",
				"Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
		tree.insertar(new Book("Casa", 3, "Volumen 4.5", "Ramiriqui's fundation",
				"Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
		tree.insertar(new Book("Aerografo", 4, "Volumen 4.5", "Ramiriqui's fundation",
				"Tunja, Campus: Central Jorge Palacios Preciado", new Author("Carlos", "Parra", "Se suicido")));
	}

	private void addBook(){
		try {
				if (Integer.parseInt(frame.getSpaceCode()) < 0)throw new Exception();
				if(frame.getSpaceNameBook().isEmpty()|| frame.getSpaceCode().isEmpty()||frame.getSpaceVolume().isEmpty()||frame.getSpaceEditorial().isEmpty()||frame.getSpaceNameAuthor().isEmpty()||frame.getSpaceLastName().isEmpty()||frame.getDescriptionTextArea().isEmpty()) {throw new Exception();}
				tree.insertar(new Book(frame.getSpaceNameBook(), Integer.parseInt(frame.getSpaceCode()),
						frame.getSpaceVolume(), frame.getSpaceEditorial(), frame.getPalabraCombo(), new Author(
								frame.getSpaceNameAuthor(), frame.getSpaceLastName(), frame.getDescriptionTextArea())));
				frame.setConfirAdd(true);

			} catch (NumberFormatException e) {
				exceptionPanel = new ExceptionPanel("Ingresa un ISBN correcto");
				frame.setConfirAdd(false);
			} catch (Exception e) {
				exceptionPanel = new ExceptionPanel("Ingresa informacion correcta");
				frame.setConfirAdd(false);
			}
	}

	private void deleteBook() {
		try {
			if (Integer.parseInt(frame.getIsbnDelete()) < 0)throw new Exception();
			int isbnCombo = Integer.parseInt(frame.getIsbnDelete());
			if(frame.getWoldComboDelete().equals("Ninguno") & tree.searchByISBN(isbnCombo) != null){
			tree.delete(tree.searchByISBN(isbnCombo));
			frame.setConfirDelete(true);

			} else if((!frame.getWoldComboDelete().equals("Ninguno")) & (tree.searchBookBySede(tree.searchBySede(frame.getWoldComboDelete()), isbnCombo).getISBN() == isbnCombo)){
				System.out.println(tree.searchBookBySede(tree.searchBySede(frame.getWoldComboDelete()), isbnCombo) != null);
				tree.delete(tree.searchBookBySede(tree.searchBySede(frame.getWoldComboDelete()), isbnCombo));
				frame.setConfirDelete(true);

			} else {
				frame.setConfirDelete(false);
			}
			fillComboBoxes();
		} catch (NumberFormatException e) {
			exceptionPanel = new ExceptionPanel("Upss. Ingresa un número valido (entero).");
			frame.setConfirAdd(false);
		} catch (Exception e) {
			exceptionPanel = new ExceptionPanel("Upss. Ingresa un número valido (entero).");
			frame.setConfirAdd(false);
		}
	}

	private void searchBook() {
		if (!frame.getIsbnToSearch().equals("")) {
			ArrayList<Book> temporal = new ArrayList<>();
			temporal.add(tree.searchByISBN(Integer.parseInt(frame.getIsbnToSearch())));
			frame.fillSearchTable(temporal);
		} else if (!frame.getNameToSearch().equals("")) {
			frame.fillSearchTable(tree.searchByName(frame.getNameToSearch()));
		} else if (!frame.getWorldSearchComboBox().equals("Ninguno")) {
			frame.fillSearchTable(tree.searchBySede(frame.getWorldSearchComboBox()));
		}
	}

	private void listBook() {
		if (frame.getWorldListComboBox().equals("Ninguno")) {
			frame.fillListTable(tree.listAllBooks());
		} else {
			frame.fillListTable(tree.listBooksBySede(frame.getWorldListComboBox()));
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
