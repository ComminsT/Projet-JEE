package models;

public class Promotion {
	private int id;
	private String date_debut;
	private String date_fin;
	private int id_produit;
	private int taux;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}
	
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public int getTaux() {
		return taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}
	public Promotion() {
		super();
	}

	public Promotion(String date_debut, String date_fin, int id_produit, int taux) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_produit = id_produit;
		this.taux = taux;
	}

}
