package co.edu.uptc.model;

public class Author {
	private String name;
	private String lastName;
	private String biography;

	public Author(String name, String lastName, String bibiography) {
		this.name = name;
		this.lastName = lastName;
		this.biography = bibiography;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBibliography() {
		return biography;
	}

	public void setBibliography(String bibliography) {
		this.biography = bibliography;
	}

}
