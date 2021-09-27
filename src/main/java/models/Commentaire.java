package models;

public class Commentaire {
	private int id;
	private String commentaire;
	private String date;
	private int id_utilisateur;
	private int id_produit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public Commentaire(String commentaire, String date, int id_utilisateur, int id_produit) {
		super();
		this.commentaire = commentaire;
		this.date = date;
		this.id_utilisateur = id_utilisateur;
		this.id_produit = id_produit;
	}

	public Commentaire() {
		super();
	}

}
