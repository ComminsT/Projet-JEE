package models;

public class Produittag {
	private int id;
	private int id_produit;
	private int id_tag;
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
	public int getId_tag() {
		return id_tag;
	}
	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}
	public Produittag(int id_produit, int id_tag) {
		super();
		this.id_produit = id_produit;
		this.id_tag = id_tag;
	}
	public Produittag() {
		super();
	}
	

}
