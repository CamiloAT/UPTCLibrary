package co.edu.uptc.model;

import java.util.ArrayList;

public class TreeAVL {
	 private NodeAVL root;
	 private ArrayList<String> sedes;
	    public TreeAVL() {
	    	fillSedes();
		}
	  public void fillSedes() {
		  sedes= new ArrayList<>();
		  sedes.add("Tunja, Campus: Central Jorge Palacios Preciado");
		  sedes.add("Tunja, Campus: Facultad de medicina");
		  sedes.add("Tunja, Campus: Facultad de estudios a distancia");
		  sedes.add("Tunja, Campus: Facultad Especializada en Musica");
		  sedes.add("Tunja, Campus: Facultad de Ciencias");
		  sedes.add("Tunja, Campus: Facultad de Ciencias Agropecuarias(INIAG) " );
		  sedes.add("Tunja, Campus: Facultad de Ciencias de la educacion " );
		  sedes.add("Tunja, Campus: Facultad de Ciencias Economicas area administracion " );
		  sedes.add("Tunja, Campus: Facultad de Ciencias Economicas area economia " );
		  sedes.add("Tunja, Campus: Facultad de Derecho y Ciencias Sociales" );
		  sedes.add("Tunja, Campus: Biblioteca Publica Escolar Juan De Vargas" );
		  sedes.add("Duitama, Campus: Facultad seccional Duitama ");
		  sedes.add("Duitama, Campus: Facultad de estudios a distancia");
		  sedes.add("Chiquinquira, Campus: Facultad seccional Chiquinquira ");
		  sedes.add("Chiquinquira, Campus: Facultad de estudios a distancia");
		  sedes.add("Sogamoso, Campus: Facultad Seccional Sogamoso");
	  }
	   

}
