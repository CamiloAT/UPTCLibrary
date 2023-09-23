package co.edu.uptc.model;

public class NodeAVL {
	private int ISBN;
	int altura;
	NodeAVL left;
	NodeAVL right;
	private Book book;

	public NodeAVL(Book book) {
		this.book = book;
		ISBN = book.getISBN();
		altura = 1;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
