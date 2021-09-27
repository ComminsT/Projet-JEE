package models;

public class Adresse {
	private int id;
	private String adresse;
	private String cp;
	private String complement;
	private String nom;
	private int id_utilisateur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Adresse(String adresse, String cp, String complement, String nom, int id_utilisateur) {
		super();
		this.adresse = adresse;
		this.cp = cp;
		this.complement = complement;
		this.nom = nom;
		this.id_utilisateur = id_utilisateur;
	}
	public Adresse() {
		super();
	}

}
