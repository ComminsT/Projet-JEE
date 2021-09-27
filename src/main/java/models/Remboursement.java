package models;

public class Remboursement {
	private int id;
	private Double montant;
	private String date;
	private int id_retour;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId_retour() {
		return id_retour;
	}
	public void setId_retour(int id_retour) {
		this.id_retour = id_retour;
	}
	public Remboursement(Double montant, String date, int id_retour) {
		super();
		this.montant = montant;
		this.date = date;
		this.id_retour = id_retour;
	}
	public Remboursement() {
		super();
	}
	

}
