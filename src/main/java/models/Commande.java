package models;

public class Commande {
	private int id;
	private int reference;
	private String adresse;
	private String cp;
	private String complement;
	private String date_recu;
	private String date_expedition;
	private int livraison;
	private int id_utilisateur;
	private Double montant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
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
	public String getDate_recu() {
		return date_recu;
	}
	public void setDate_recu(String date_recu) {
		this.date_recu = date_recu;
	}
	public String getDate_expedition() {
		return date_expedition;
	}
	public void setDate_expedition(String date_expedition) {
		this.date_expedition = date_expedition;
	}
	public int getLivraison() {
		return livraison;
	}
	public void setLivraison(int livraison) {
		this.livraison = livraison;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Commande(int reference, String adresse, String cp, String complement, String date_recu,
			String date_expedition, int livraison, int id_utilisateur, Double montant) {
		super();
		this.reference = reference;
		this.adresse = adresse;
		this.cp = cp;
		this.complement = complement;
		this.date_recu = date_recu;
		this.date_expedition = date_expedition;
		this.livraison = livraison;
		this.id_utilisateur = id_utilisateur;
		this.montant = montant;
	}
	public Commande() {
		super();
	}

}
