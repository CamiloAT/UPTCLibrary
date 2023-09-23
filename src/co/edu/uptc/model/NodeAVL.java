package co.edu.uptc.model;


public class NodeAVL {
	private int altura;
	private int ISBN;
	private NodeAVL left;
	private NodeAVL right;
	private Book book;

	public NodeAVL (Book book) {
		this.book = book;
		ISBN = book.getISBN();
		altura = 1;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public NodeAVL getLeft() {
		return left;
	}

	public void setLeft(NodeAVL left) {
		this.left = left;
	}

	public NodeAVL getRight() {
		return right;
	}

	public void setRight(NodeAVL right) {
		this.right = right;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	} 
	
}
