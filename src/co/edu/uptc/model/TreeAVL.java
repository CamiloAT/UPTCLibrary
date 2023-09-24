package co.edu.uptc.model;

import java.util.ArrayList;

public class TreeAVL {
	private NodeAVL root;
	private ArrayList<String> sedes;
	private ArrayList<Book> books;

	public TreeAVL() {
		fillSedes();
	}

	public void fillSedes() {
		sedes = new ArrayList<>();
		sedes.add("Ninguno");
		sedes.add("Tunja, Campus: Central Jorge Palacios Preciado");
		sedes.add("Tunja, Campus: Facultad de medicina");
		sedes.add("Tunja, Campus: Facultad de estudios a distancia");
		sedes.add("Tunja, Campus: Facultad Especializada en Musica");
		sedes.add("Tunja, Campus: Facultad de Ciencias");
		sedes.add("Tunja, Campus: Facultad de Ciencias Agropecuarias(INIAG) ");
		sedes.add("Tunja, Campus: Facultad de Ciencias de la educacion ");
		sedes.add("Tunja, Campus: Facultad de Ciencias Economicas area administracion ");
		sedes.add("Tunja, Campus: Facultad de Ciencias Economicas area economia ");
		sedes.add("Tunja, Campus: Facultad de Derecho y Ciencias Sociales");
		sedes.add("Tunja, Campus: Biblioteca Publica Escolar Juan De Vargas");
		sedes.add("Duitama, Campus: Facultad seccional Duitama ");
		sedes.add("Duitama, Campus: Facultad de estudios a distancia");
		sedes.add("Chiquinquira, Campus: Facultad seccional Chiquinquira ");
		sedes.add("Chiquinquira, Campus: Facultad de estudios a distancia");
		sedes.add("Sogamoso, Campus: Facultad Seccional Sogamoso");
	}

	public void clearAll() {
		root = null;
	}

	public void insertar(Book book) {
		root = insertarAVL(root, book);
	}

	private NodeAVL insertarAVL(NodeAVL nodoActual, Book book) {
		if (nodoActual == null) {
			return (new NodeAVL(book));
		}
		if (book.getISBN() < nodoActual.getISBN()) {
			nodoActual.left = insertarAVL(nodoActual.left, book);
		} else if (book.getISBN() > nodoActual.getISBN()) {
			nodoActual.right = insertarAVL(nodoActual.right, book);
		} else {
			return nodoActual;
		}
		nodoActual.altura = (1 + max(getAltura(nodoActual.left), getAltura(nodoActual.right)));
		int fe = getFactorEquilibrio(nodoActual);
		if (fe > 1 && book.getISBN() < nodoActual.left.getISBN()) {
			return rightRotate(nodoActual);
		}
		if (fe < -1 && book.getISBN() > nodoActual.right.getISBN()) {
			return leftRotate(nodoActual);
		}
		if (fe > 1 && book.getISBN() > nodoActual.left.getISBN()) {
			nodoActual.left = leftRotate(nodoActual.left);
			return rightRotate(nodoActual);
		}
		if (fe < -1 && book.getISBN() < nodoActual.right.getISBN()) {
			nodoActual.right = rightRotate(nodoActual.right);
			return leftRotate(nodoActual);
		}
		return nodoActual;
	}

	public void mostrarArbolAVL() {
		System.out.println("Arbol AVL");
		showTree(root, 0);
	}

	private void showTree(NodeAVL nodo, int depth) {
		if (nodo.right != null) {
			showTree(nodo.right, depth + 1);
		}
		for (int i = 0; i < depth; i++) {
			System.out.print("    ");
		}
		System.out.println("(" + nodo.getISBN() + ")");

		if (nodo.left != null) {
			showTree(nodo.left, depth + 1);
		}
	}

	public Book searchByISBN(int ISBN) {
		return this.searchOnAVL(root, ISBN);
	}

	public ArrayList<Book> searchByName(String tittle) {
		books = new ArrayList<>();
		ArrayList<Book> localBooks = this.getPreOrder();
		ArrayList<Book> output = new ArrayList<>();
		for (Book book : localBooks) {
			if (tittle.equalsIgnoreCase(book.getTittle())) {
				output.add(book);
			}
		}
		return output;
	}

	public ArrayList<Book> searchBySede(String sede) {
		books = new ArrayList<>();
		ArrayList<Book> localBooks = this.getPreOrder();
		ArrayList<Book> output = new ArrayList<>();
		for (Book book : localBooks) {
			if (sede.equals(book.getSede())) {
				output.add(book);
			}
		}
		return output;
	}

	public Book searchBookBySede(ArrayList<Book> listBooks, int ISBN){
		Book bookAux = new Book();
		for (Book book : listBooks) {
			if (book.getISBN() == ISBN){
				bookAux = book;
			}
		}
		return bookAux; 
	}

	private Book searchOnAVL(NodeAVL nodoActual, int searchISBN) {
		Book output = new Book();
		if (nodoActual == null) {
			output = null;
		} else if (searchISBN == nodoActual.ISBN) {
			output = nodoActual.book;
		} else if (searchISBN < nodoActual.ISBN) {
			output = searchOnAVL(nodoActual.left, searchISBN);
		} else {
			output = searchOnAVL(nodoActual.right, searchISBN);
		}
		return output;
	}

	public ArrayList<Book> listAllBooks() {
		books = new ArrayList<>();
		return this.getPreOrder();
	}

	public ArrayList<Book> listBooksBySede(String sede) {
		return this.searchBySede(sede);
	}

	public void delete(Book book) {
		root = deleteAVL(root, book);
	}

	private NodeAVL deleteAVL(NodeAVL nodoActual, Book book) {
		if (nodoActual == null)
			return nodoActual;

		if (book.getISBN() < nodoActual.getISBN()) {
			nodoActual.left = deleteAVL(nodoActual.left, book);
		} else if (book.getISBN() > nodoActual.getISBN()) {
			nodoActual.right = deleteAVL(nodoActual.right, book);
		} else {
			if ((nodoActual.left == null) || (nodoActual.right == null)) {
				NodeAVL temp = null;
				if (temp == nodoActual.left) {
					temp = nodoActual.right;
				} else {
					temp = nodoActual.left;
				}
				if (temp == null) {
					nodoActual = null;
				} else {
					nodoActual = temp;
				}
			} else {
				NodeAVL temp = getNodoConValorMaximo(nodoActual.left);
				nodoActual.setISBN(temp.getISBN());
				nodoActual.left = deleteAVL(nodoActual.left, temp.getBook());
			}
		}
		if (nodoActual == null)
			return nodoActual;
		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		int fe = getFactorEquilibrio(nodoActual);
		if (fe > 1 && getFactorEquilibrio(nodoActual.left) >= 0) {
			return rightRotate(nodoActual);
		}
		if (fe < -1 && getFactorEquilibrio(nodoActual.right) <= 0) {
			return leftRotate(nodoActual);
		}
		if (fe > 1 && getFactorEquilibrio(nodoActual.left) < 0) {
			nodoActual.left = leftRotate(nodoActual.left);
			return rightRotate(nodoActual);
		}
		if (fe < -1 && getFactorEquilibrio(nodoActual.right) > 0) {
			nodoActual.right = rightRotate(nodoActual.right);
			return leftRotate(nodoActual);
		}
		return nodoActual;
	}

	private NodeAVL rightRotate(NodeAVL nodoActual) {
		NodeAVL nuevaRaiz = nodoActual.left;
		NodeAVL temp = nuevaRaiz.right;

		nuevaRaiz.right = nodoActual;
		nodoActual.left = temp;

		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;
		return nuevaRaiz;
	}

	private NodeAVL leftRotate(NodeAVL nodoActual) {
		NodeAVL nuevaRaiz = nodoActual.right;

		NodeAVL temp = nuevaRaiz.left;

		nuevaRaiz.left = nodoActual;
		nodoActual.right = temp;

		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

		return nuevaRaiz;
	}

	public ArrayList<Book> getPreOrder() {
		this.preOrder(this.root);
		return this.books;
	}

	public void preOrder(NodeAVL node) {
		if (node != null) {
			this.books.add(node.book);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	private int getAltura(NodeAVL nodoActual) {
		if (nodoActual == null) {
			return 0;
		}

		return nodoActual.altura;
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int getFactorEquilibrio(NodeAVL nodoActual) {
		if (nodoActual == null) {
			return 0;
		}

		return getAltura(nodoActual.left) - getAltura(nodoActual.right);
	}

	private NodeAVL getNodoConValorMaximo(NodeAVL node) {
		NodeAVL current = node;

		while (current.right != null) {
			current = current.right;
		}

		return current;
	}

	public ArrayList<String> getSedes() {
		return sedes;
	}
}