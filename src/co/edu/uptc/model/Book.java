package co.edu.uptc.model;

public class Book {
	private String tittle;
	private int ISBN;
	private String volume;
	private String editorial;
	private String sede;
	private Author author;

	public Book(String tittle, int ISBN, String volume, String editorial, String sede, Author author) {
		this.tittle = tittle;
		this.ISBN = ISBN;
		this.volume = volume;
		this.editorial = editorial;
		this.sede = sede;
		this.author = author;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
