package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProduittagDAO {
	public void save(Produittag a) {
		
				try {
					
					if(a.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE produittag set id_produit=?,id_tag=? WHERE id=?");
						preparedStatement.setInt(1,a.getId_produit());
						preparedStatement.setInt(2,a.getId_tag());
						preparedStatement.setInt(3,a.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO produittag (id_produit,id_tag) VALUES(?,?)");
						preparedStatement.setInt(1,a.getId_produit());
						preparedStatement.setInt(2,a.getId_tag());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Produittag getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produittag WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Produittag a = new Produittag();
					while(resultat.next()) {
						a.setId(resultat.getInt( "id" ));
						a.setId_produit(resultat.getInt("id_produit"));
						a.setId_tag(resultat.getInt("id_tag"));	
					}
					return a;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Produittag> getAll() {
			ArrayList<Produittag> list = new ArrayList<Produittag>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produittag");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Produittag a = new Produittag();
						a.setId(resultat.getInt( "id" ));
						a.setId_produit(resultat.getInt("id_produit"));
						a.setId_tag(resultat.getInt("id_tag"));	
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
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM produittag WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
