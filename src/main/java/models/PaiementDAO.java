package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaiementDAO {
	public void save(Paiement p) {
		
				try {
					
					if(p.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE paiement set montant=?,modepaiement=?,id_commande=? WHERE id=?");
						preparedStatement.setDouble(1,p.getMontant());
						preparedStatement.setString(2,p.getModepaiement());
						preparedStatement.setInt(3,p.getId_commande());
						preparedStatement.setInt(4,p.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO paiement (montant,modepaiement,id_commande) VALUES(?,?,?)");
						preparedStatement.setDouble(1,p.getMontant());
						preparedStatement.setString(2,p.getModepaiement());
						preparedStatement.setInt(3,p.getId_commande());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Paiement getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM paiement WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					Paiement p = new Paiement();
					while(resultat.next()) {
						p.setId(resultat.getInt( "id" ));
						p.setMontant(resultat.getDouble("montant"));
						p.setModepaiement(resultat.getString("modepaiement"));
						p.setId_commande(resultat.getInt("id_commande"));
					}
					return p;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		
		
		public ArrayList<Paiement> getAll() {
			ArrayList<Paiement> list = new ArrayList<Paiement>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM paiement");
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Paiement p = new Paiement();
						p.setId(resultat.getInt( "id" ));
						p.setMontant(resultat.getDouble("montant"));
						p.setModepaiement(resultat.getString("modepaiement"));
						p.setId_commande(resultat.getInt("id_commande"));
						list.add(p);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		
		public void deleteById(int id) {
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM paiement WHERE id=?");
					preparedStatement.setInt(1,id);
					preparedStatement.executeUpdate();
					System.out.println("DELETED OK");
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}	
}
