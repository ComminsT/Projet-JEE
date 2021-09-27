package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProduitDAO {
	public void save(Produit a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE produits set prix=?,titre=?,quantite=?,img=?,description=?,descriptionsm=?,nombrejoueursmin=?,nombrejoueursmax=?,duree=?,visible=?,miseenavant=?,vues=?,age=?,id_categorie=?,id_editeur=? WHERE id=?");
						preparedStatement.setDouble(1,a.getPrix());
						preparedStatement.setString(2,a.getTitre());
						preparedStatement.setInt(3,a.getQuantite());
						preparedStatement.setString(4,a.getImg());
						preparedStatement.setString(5,a.getDescription());
						preparedStatement.setString(6,a.getDescriptionsm());
						preparedStatement.setInt(7,a.getNbrjoueurmin());
						preparedStatement.setInt(8,a.getNbrjoueurmax());
						preparedStatement.setString(9,a.getDuree());
						preparedStatement.setBoolean(10,a.getVisible());
						preparedStatement.setBoolean(11,a.getEnavant());
						preparedStatement.setInt(12,a.getVues());
						preparedStatement.setInt(13,a.getAge());
						preparedStatement.setInt(14,a.getId_categorie());
						
						preparedStatement.setInt(15,a.getId_editeur());
						preparedStatement.setInt(16,a.getId());
						
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO produits (prix,titre,quantite,img,description,descriptionsm,nombrejoueursmin,nombrejoueursmax,duree,visible,miseenavant,vues,age,id_categorie,id_editeur) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						preparedStatement.setDouble(1,a.getPrix());
						preparedStatement.setString(2,a.getTitre());
						preparedStatement.setInt(3,a.getQuantite());
						preparedStatement.setString(4,a.getImg());
						preparedStatement.setString(5,a.getDescription());
						preparedStatement.setString(6,a.getDescriptionsm());
						preparedStatement.setInt(7,a.getNbrjoueurmin());
						preparedStatement.setInt(8,a.getNbrjoueurmax());
						preparedStatement.setString(9,a.getDuree());
						preparedStatement.setBoolean(10,a.getVisible());
						preparedStatement.setBoolean(11,a.getEnavant());
						preparedStatement.setInt(12,a.getVues());
						preparedStatement.setInt(13,a.getAge());
						preparedStatement.setInt(14,a.getId_categorie());
			
						preparedStatement.setInt(15,a.getId_editeur());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Produit getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produits WHERE id=? AND visible=1");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Produit a = new Produit();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setPrix(resultat.getDouble("prix"));
						a.setTitre(resultat.getString("titre"));	
						a.setQuantite(resultat.getInt("quantite"));	
						a.setImg(resultat.getString("img"));	
						a.setDescription(resultat.getString("description"));
						a.setDescriptionsm(resultat.getString("descriptionsm"));
						a.setNbrjoueurmin(resultat.getInt("nombrejoueursmin"));
						a.setNbrjoueurmax(resultat.getInt("nombrejoueursmax"));
						a.setDuree(resultat.getString("duree"));
						a.setVisible(resultat.getBoolean("visible"));
						a.setEnavant(resultat.getBoolean("miseenavant"));
						a.setVues(resultat.getInt("vues"));
						a.setAge(resultat.getInt("age"));
						a.setId_categorie(resultat.getInt("id_categorie"));

						a.setId_editeur(resultat.getInt("id_editeur"));
					}
					System.out.println("Visible bool ="+a.getVisible());
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Produit> getAll() {
			ArrayList<Produit> list = new ArrayList<Produit>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produits WHERE visible=1");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Produit a = new Produit();
						a.setId(resultat.getInt( "id" ));
						a.setPrix(resultat.getDouble("prix"));
						a.setTitre(resultat.getString("titre"));	
						a.setQuantite(resultat.getInt("quantite"));	
						a.setImg(resultat.getString("img"));	
						a.setDescription(resultat.getString("description"));
						a.setDescriptionsm(resultat.getString("descriptionsm"));
						a.setNbrjoueurmin(resultat.getInt("nombrejoueursmin"));
						a.setNbrjoueurmax(resultat.getInt("nombrejoueursmax"));
						a.setDuree(resultat.getString("duree"));
						a.setVisible(resultat.getBoolean("visible"));
						a.setEnavant(resultat.getBoolean("miseenavant"));
						a.setVues(resultat.getInt("vues"));
						a.setAge(resultat.getInt("age"));
						a.setId_categorie(resultat.getInt("id_categorie"));
						
						a.setId_editeur(resultat.getInt("id_editeur"));
						list.add(a);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		public ArrayList<Produit> getAllRAW() {
			ArrayList<Produit> list = new ArrayList<Produit>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produits");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Produit a = new Produit();
						a.setId(resultat.getInt( "id" ));
						a.setPrix(resultat.getDouble("prix"));
						a.setTitre(resultat.getString("titre"));	
						a.setQuantite(resultat.getInt("quantite"));	
						a.setImg(resultat.getString("img"));	
						a.setDescription(resultat.getString("description"));
						a.setDescriptionsm(resultat.getString("descriptionsm"));
						a.setNbrjoueurmin(resultat.getInt("nombrejoueursmin"));
						a.setNbrjoueurmax(resultat.getInt("nombrejoueursmax"));
						a.setDuree(resultat.getString("duree"));
						a.setVisible(resultat.getBoolean("visible"));
						a.setEnavant(resultat.getBoolean("miseenavant"));
						a.setVues(resultat.getInt("vues"));
						a.setAge(resultat.getInt("age"));
						a.setId_categorie(resultat.getInt("id_categorie"));
						
						a.setId_editeur(resultat.getInt("id_editeur"));
						list.add(a);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		public void deleteById(int id) {
			try {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE produits SET visible=0 WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}

		public ArrayList<Produit> getAllByCategorieId(int id) {
			ArrayList<Produit> list = new ArrayList<Produit>();
			try {
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produits WHERE id_categorie=? and visible=1");
					preparedStatement.setInt(1, id);
					ResultSet resultat=preparedStatement.executeQuery();
					while(resultat.next()) {
						Produit a = new Produit();
						a.setId(resultat.getInt( "id" ));
						a.setPrix(resultat.getDouble("prix"));
						a.setTitre(resultat.getString("titre"));	
						a.setQuantite(resultat.getInt("quantite"));	
						a.setImg(resultat.getString("img"));	
						a.setDescription(resultat.getString("description"));
						a.setDescriptionsm(resultat.getString("descriptionsm"));
						a.setNbrjoueurmin(resultat.getInt("nombrejoueursmin"));
						a.setNbrjoueurmax(resultat.getInt("nombrejoueursmax"));
						a.setDuree(resultat.getString("duree"));
						a.setVisible(resultat.getBoolean("visible"));
						a.setEnavant(resultat.getBoolean("miseenavant"));
						a.setVues(resultat.getInt("vues"));
						a.setAge(resultat.getInt("age"));
						a.setId_categorie(resultat.getInt("id_categorie"));
						a.setId_editeur(resultat.getInt("id_editeur"));
						list.add(a);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
}
