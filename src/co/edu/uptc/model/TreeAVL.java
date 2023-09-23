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

	/***************************************************************************/
	/****************************** INSERCION **********************************/
	/***************************************************************************/

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
		} else {// Si la clave esta duplicada retorna el mismo nodo encontrado
			return nodoActual;
		}

		// Actualizacion de la altura
		nodoActual.altura = (1 + max(getAltura(nodoActual.left), getAltura(nodoActual.right)));

		// Se obtiene el factor de equilibrio
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

//	    mostrar
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

	/***************************************************************************/
	/****************************** BUSQUEDA **********************************/
	/***************************************************************************/
	
	public Book searchByISBN(int ISBN) {
		return this.SearchOnAVL(root, ISBN);
	}

	public ArrayList<Book> seacrhByName(String tittle){
		ArrayList<Book> localBooks = this.getPreOrder();
		ArrayList<Book> output = new ArrayList<>();
		for (Book book : localBooks) {
			if (tittle.equalsIgnoreCase(book.getTittle())) {
				output.add(book);
			}
		}
		return output;
	}
	
	public ArrayList<Book> searchBySede(String sede){
		ArrayList<Book> localBooks = this.getPreOrder();
		ArrayList<Book> output = new ArrayList<>();
		for (Book book : localBooks) {
			if (sede.equals(book.getSede())) {
				output.add(book);
			}
		}
		return output;
	}
	
	private Book SearchOnAVL(NodeAVL nodoActual, int searchISBN) {
		Book output = new Book();
		if (nodoActual == null) {
			output = null;
		}else if (searchISBN == nodoActual.ISBN) {
			output = nodoActual.book;
		}else if (searchISBN < nodoActual.ISBN) {
			output = SearchOnAVL(nodoActual.left, searchISBN);
		}else {
			output = SearchOnAVL(nodoActual.right, searchISBN);
		}
		return output;
	}
	
	/***************************************************************************/
	/****************************** LISTAR **********************************/
	/***************************************************************************/
	
	public ArrayList<Book> listAllBooks(){
		return this.books;
	}
	
	public ArrayList<Book> listBooksBySede(String sede){
		return this.searchBySede(sede);
	}
	
	/***************************************************************************/
	/****************************** ROTACIONES *********************************/
	/***************************************************************************/

	private NodeAVL rightRotate(NodeAVL nodoActual) {
		NodeAVL nuevaRaiz = nodoActual.left;
		NodeAVL temp = nuevaRaiz.right;

		// Se realiza la rotacion
		nuevaRaiz.right = nodoActual;
		nodoActual.left = temp;

		// Actualiza alturas
		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;
		return nuevaRaiz;
	}

	// Rotar hacia la izquierda
	private NodeAVL leftRotate(NodeAVL nodoActual) {
		NodeAVL nuevaRaiz = nodoActual.right;

		NodeAVL temp = nuevaRaiz.left;

		// Se realiza la rotacion
		nuevaRaiz.left = nodoActual;
		nodoActual.right = temp;

		// Actualiza alturas

		nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
		nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

		return nuevaRaiz;
	}

	/***************************************************************************/
	/****************************** AUXILIARES *********************************/
	/***************************************************************************/

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
	
	// Obtiene el peso de un arbol dado
	private int getAltura(NodeAVL nodoActual) {
		if (nodoActual == null) {
			return 0;
		}

		return nodoActual.altura;
	}

	// Devuelve el mayor entre dos numeros
	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Obtiene el factor de equilibrio de un nodo
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

}