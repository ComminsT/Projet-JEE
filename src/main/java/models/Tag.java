package models;

public class Tag {
	private int id;
	private String titre;
	private int id_produit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public Tag(String titre, int id_produit) {
		super();
		this.titre = titre;
		this.id_produit = id_produit;
	}
	public Tag() {
		super();
	}
	

}
