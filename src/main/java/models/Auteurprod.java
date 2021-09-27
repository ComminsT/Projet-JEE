package models;

public class Auteurprod {
	private int id;
	private int id_auteur;
	private int id_produit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_auteur() {
		return id_auteur;
	}
	public void setId_auteur(int id_auteur) {
		this.id_auteur = id_auteur;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public Auteurprod(int id_auteur, int id_produit) {
		super();
		this.id_auteur = id_auteur;
		this.id_produit = id_produit;
	}
	public Auteurprod() {
		super();
	}

}
