package models;

import java.util.ArrayList;

public class Produit {
	private int id;
	private double prix;
	private String titre;
	private int quantite;
	private String img;
	private String description;
	private int nbrjoueurmin;
	private int nbrjoueurmax;
	private String duree;
	private Boolean visible;
	private Boolean enavant;
	private int vues;
	private int age;
	private int id_categorie;
	private int id_editeur;
	private String descriptionsm;
	public String getDescriptionsm() {
		return descriptionsm;
	}
	public void setDescriptionsm(String descriptionsm) {
		this.descriptionsm = descriptionsm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbrjoueurmin() {
		return nbrjoueurmin;
	}
	public void setNbrjoueurmin(int nbrjoueurmin) {
		this.nbrjoueurmin = nbrjoueurmin;
	}
	public int getNbrjoueurmax() {
		return nbrjoueurmax;
	}
	public void setNbrjoueurmax(int nbrjoueurmax) {
		this.nbrjoueurmax = nbrjoueurmax;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Boolean getEnavant() {
		return enavant;
	}
	public void setEnavant(Boolean enavant) {
		this.enavant = enavant;
	}
	public int getVues() {
		return vues;
	}
	public void setVues(int vues) {
		this.vues = vues;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	
	public int getId_editeur() {
		return id_editeur;
	}
	public void setId_editeur(int id_editeur) {
		this.id_editeur = id_editeur;
	}
	
	public Produit(double prix, String titre, int quantite, String img, String description, int nbrjoueurmin,
			int nbrjoueurmax, String duree, Boolean visible, Boolean enavant, int vues, int age, int id_categorie,
			 int id_editeur, String descriptionsm) {
		super();
		this.prix = prix;
		this.titre = titre;
		this.quantite = quantite;
		this.img = img;
		this.description = description;
		this.nbrjoueurmin = nbrjoueurmin;
		this.nbrjoueurmax = nbrjoueurmax;
		this.duree = duree;
		this.visible = visible;
		this.enavant = enavant;
		this.vues = vues;
		this.age = age;
		this.id_categorie = id_categorie;
		this.id_editeur = id_editeur;
		this.descriptionsm = descriptionsm;
	}
	
	public Produit() {
		super();
	}
	
	

}
