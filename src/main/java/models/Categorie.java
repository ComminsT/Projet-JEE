package models;

public class Categorie {
	
	private int id;
	private String titre;
	private int mere;
	
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
	public int getMere() {
		return mere;
	}
	public void setMere(int mere) {
		this.mere = mere;
	}
	public Categorie() {
		super();
	}
	public Categorie(String titre, int mere) {
		super();
		this.titre = titre;
		this.mere = mere;
	}

}
