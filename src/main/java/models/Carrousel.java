package models;

public class Carrousel {
	private int id;
	private int place;
	private String img;
	private int id_produit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public Carrousel(int place, String img, int id_produit) {
		super();
		this.place = place;
		this.img = img;
		this.id_produit = id_produit;
	}
	public Carrousel() {
		super();
	}
	

}
