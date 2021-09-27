package models;

public class Detail {
private int id;
private int id_commande;
private int id_produit;
private double prixu;
private int quantite;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_commande() {
	return id_commande;
}
public void setId_commande(int id_commande) {
	this.id_commande = id_commande;
}
public int getId_produit() {
	return id_produit;
}
public void setId_produit(int id_produit) {
	this.id_produit = id_produit;
}
public double getPrixu() {
	return prixu;
}
public void setPrixu(double prixu) {
	this.prixu = prixu;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Detail(int id_commande, int id_produit, double prixu,int quantite) {
	super();
	this.quantite=quantite;
	this.id_commande = id_commande;
	this.id_produit = id_produit;
	this.prixu = prixu;
}
public Detail() {
	super();
}


}
