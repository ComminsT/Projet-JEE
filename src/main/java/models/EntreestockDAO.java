package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EntreestockDAO {
	public void save(Entreestock e) {
		
				try {
					
					if(e.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE entreestock set quantite=?,date=?,id_propduit=? WHERE id=?");
						preparedStatement.setInt(1,e.getQuantite());
						preparedStatement.setString(2,e.getDate());
						preparedStatement.setInt(3,e.getId_produit());
						preparedStatement.setInt(4,e.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO entreestock (quantite,date,id_produit) VALUES(?,?,?)");
						preparedStatement.setInt(1,e.getQuantite());
						preparedStatement.setString(2,e.getDate());
						preparedStatement.setInt(3,e.getId_produit());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Entreestock getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM entreestock WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Entreestock e = new Entreestock();
					while(resultat.next()) {
						e.setId(resultat.getInt( "id" ));
						e.setQuantite(resultat.getInt("quantite"));
						e.setDate(resultat.getString("date"));
						e.setId_produit(resultat.getInt("id_produit"));
					}
					return e;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Entreestock> getAll() {
			ArrayList<Entreestock> list = new ArrayList<Entreestock>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM entreestock");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Entreestock e = new Entreestock();
						e.setId(resultat.getInt( "id" ));
						e.setQuantite(resultat.getInt("quantite"));
						e.setDate(resultat.getString("date"));
						e.setId_produit(resultat.getInt("id_produit"));
						list.add(e);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		public void deleteById(int id) {
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM entreestock WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
