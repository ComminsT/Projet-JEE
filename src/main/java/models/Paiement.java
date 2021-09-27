package models;

public class Paiement {
	private int id;
	private Double montant;
	private String modepaiement;
	private int id_commande;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getModepaiement() {
		return modepaiement;
	}
	public void setModepaiement(String modepaiement) {
		this.modepaiement = modepaiement;
	}
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public Paiement(Double montant, String modepaiement, int id_commande) {
		super();
		this.montant = montant;
		this.modepaiement = modepaiement;
		this.id_commande = id_commande;
	}
	public Paiement() {
		super();
	}
	

}
