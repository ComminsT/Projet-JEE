package models;

public class Entreestock {
	private int id;
	private int quantite;
	private int id_produit;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Entreestock(int quantite, int id_produit, String date) {
		super();
		this.quantite = quantite;
		this.id_produit = id_produit;
		this.date = date;
	}
	public Entreestock() {
		super();
	}
	

}
