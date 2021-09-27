package models;

public class Retour {
	private int id;
	private String date;
	private String suivi;
	private int id_commande;
	private int id_produit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSuivi() {
		return suivi;
	}

	public void setSuivi(String suivi) {
		this.suivi = suivi;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commandes) {
		this.id_commande = id_commandes;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public Retour(String date, String suivi, int id_commande, int id_produit) {
		super();
		this.date = date;
		this.suivi = suivi;
		this.id_commande = id_commande;
		this.id_produit = id_produit;
	}

	public Retour() {
		super();
	}

}
