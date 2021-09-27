package models;

public class Utilisateur {
	private int id;
	private String nom;
	private String email;
	private String mdp;
	private int fidelite;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getFidelite() {
		return fidelite;
	}
	public void setFidelite(int fidelite) {
		this.fidelite = fidelite;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Utilisateur(String nom, String email, String mdp, int fidelite, String tel) {
		super();
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.fidelite = fidelite;
		this.tel = tel;
	}
	public Utilisateur() {
		super();
	}
	

}
