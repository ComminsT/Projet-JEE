package models;

public class Auteur {
	private int id;
	private String nom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Auteur(String nom) {
		super();
		this.nom = nom;
	}
	public Auteur() {
		super();
	}
	

}
