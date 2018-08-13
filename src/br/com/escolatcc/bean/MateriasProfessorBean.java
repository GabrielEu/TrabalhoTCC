package br.com.escolatcc.bean;

public class MateriasProfessorBean {

	private static int idMateria;
	private static String nomeMateria;
	
	public static int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	
}
