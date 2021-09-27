package models;

public class Wishlist {
	private int id;
	private int id_produit;
	private int id_utilisateur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Wishlist(int id_produit, int id_utilisateur) {
		super();
		this.id_produit = id_produit;
		this.id_utilisateur = id_utilisateur;
	}
	public Wishlist() {
		super();
	}
	

}
