package imp;

import java.util.ArrayList;

import models.Auteur;
import models.AuteurDAO;
import models.Auteurprod;
import models.AuteurprodDAO;
import models.Database;
import models.Editeur;
import models.EditeurDAO;
import models.Produit;
import models.ProduitDAO;
import models.Produittag;
import models.ProduittagDAO;
import models.Tag;
import models.TagDAO;

public class Import {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		importation();
		//importation2();		
	}
	
	public static void auteurlink(String auteurname,int id_produit) {
		AuteurDAO auteurdao = new AuteurDAO();
		Auteur auteur = auteurdao.getByName(auteurname.trim());
		AuteurprodDAO auteurproddao = new AuteurprodDAO();
		Auteurprod auteurprod = new Auteurprod(auteur.getId(),id_produit);
		auteurproddao.save(auteurprod);
		System.out.println(auteur.getId());
	}
	
public static Integer editeurlink(String editeurname) {
	int id_editeur=0;
	EditeurDAO editeurdao = new EditeurDAO();
	Editeur editeur = editeurdao.getByName(editeurname);
	id_editeur=editeur.getId();
	return id_editeur;
		
	}

public static void taglink(String tagname, int id_produit) {
	ProduittagDAO produittagdao = new ProduittagDAO();
	TagDAO tagDAO = new TagDAO();
	Tag tag = tagDAO.getByName(tagname);
	Produittag ptag = new Produittag(id_produit,tag.getId());
	produittagdao.save(ptag);
	
	
		
	}
public static void importation2() {
	Database.Connect();
	Produit p = new Produit();
	ProduitDAO produitDAO = new ProduitDAO();
	ArrayList<Produit> liste=new ArrayList<Produit>();
	int id_produit=0;
	//Article numéro 3001 

	 

	
	
	
	 
	
	
	
	
}
public static void importation() {
	Database.Connect();
	Produit p = new Produit();
	ProduitDAO produitDAO = new ProduitDAO();
	ArrayList<Produit> liste=new ArrayList<Produit>();
	int id_produit=0;
	//Article numéro 3500 
	 		 
		 //Article numéro 3889 
		 
		 p= new Produit( 8.95 ,"La Vallée des Marchands - Playmat Bag", 0 ,"https://cdn3.philibertnet.com/493547-large_default/la-vallee-des-marchands-playmat-bag.jpg","<div class=\"rte\"><h2>Un sac en toile robuste avec une illustration à l'effigie La Vallée des Marchands.</h2><div>Peut contenir 4 tapis de jeu pour faciliter le stockage et le transport. Comprend une ficelle pour maintenir le sac fermé et un mousqueton pour l'accrocher.</div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("Snowdale Design") ,"Un sac en toile pour votre playmat La Vallée des Marchands."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3890 
		 
		 p= new Produit( 14.90 ,"Call of Cthulhu 7th Edition Black & magenta Dice Set", 18 ,"https://cdn3.philibertnet.com/494029-large_default/call-of-cthulhu-7th-edition-black-magenta-dice-set.jpg","<div class=\"rte\"><h2>La lumière de l'espace.</h2><div><ul><li>Immersion - Les marques des Anciens sur les faces des dés murmurent de façon hypnotique des phénomènes inimaginables qui attendent que vous les découvriez. Que ce soit pour la connaissance, ou la folie...Compatibilité - Ces dés sont utilisables avec chaque édition de Call od Cthulhu, et avec d'autres jeux, car les limites ne sont que dans votre imagination.</li><li>Lisibilité - Pas besoin de se fatiguer les yeux pour voir le résultat de votre test de santé mentale. Il est toujours inférieur aux attentes. Mais vous le verrez néanmoins clairement</li><li>Omniprésence - Même lorsque vous tenez simplement les dés dans votre main et que vous les regardez, ils semblent vous attirer plus profondément. Les particules de couleur hors de l'espace s'agitent-elles ou s'agit-il simplement de votre imagination?</li><li>Étonnement - La couleur magenta vous fait-elle vous demander si elle fonctionne avec le mythe de Call of Cthulhu ? Vous n'avez plus à vous inquiéter. Son ambiguïté rapproche l'horreur de votre imagination...</li></ul></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("Q-Workshop") ,"Set de dé pour l'Appel de Cthulhu."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3891 
		 
		 p= new Produit( 22.95 ,"Foam Tray - Aftermath", 1 ,"https://cdn1.philibertnet.com/493703-large_default/foam-tray-aftermath.jpg","<div class=\"rte\">Ce kit contient: <div><ul><li>1 x mousse avec 9 compartiments (Dimensions : 280 mm x 280 mm x 35 mm dont 25 mm utiles) </li><li>1 x mousse avec 23 compartiments pour les figurines (Dimensions : 280 mm x 188 mm x 60 mm dont 50 mm utiles) </li><li>1 x porte-cartes permettant de ranger dans chacun de ces 2 compartiments 30 cartes sous sleeves ou 60 cartes non protégées.</li><li>1 x couvercle en mousse</li></ul></div><div>Le jeu n'est pas inclus. </div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("Feldherr") ,"Composé de plusieurs mousses pour protéger les éléments du jeu et d'un support pour les cartes, Foam Tray - Aftermath se glisse dans la boîte du jeu et offre un moyen de protéger et classer ceux-ci."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3892 
		 
		 p= new Produit( 29.90 ,"Watchtower 100+  XL  Exclusive Edition 2021", 2 ,"https://cdn2.philibertnet.com/495084-large_default/watchtower-100-xl-exclusive-edition-2021.jpg","<div class=\"rte\"><h2>Watchtower 100+ XL Exclusive Edition 2021 peut contenir jusuq'à 100 cartes protégées.</h2><div><ul><li>Peut contenir jusqu'à 100 cartes avec doubles sleeves</li><li>Peut contenir un deck commander complet, jetons inclus </li><li>Contient un tiroir indépendant pour les accessoires </li><li>Peut s'utiliser comme espace de stockage ou en jeu pour faciliter la mise en place </li><li>Les languettes sont détachables et aimantées pour une fermeture plus sûre </li></ul></div><div></div><div><span style=\"font-weight: bold,:,>Dimensions</span>: 102x99x148 mm </div><div>Tiroir: 70x78x29 mm </div><div>Deck box: 70x78x95 mm </div><div>Matériau: Microfibre Nexofyber+</div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("Gamegenic") ,"Boite de rangement pouvant contenir jusqu'à 100 cartes protégées."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3893 
		 
		 p= new Produit( 18.90 ,"Squire 100+ XL  Exclusive Edition 2021", 1 ,"https://cdn1.philibertnet.com/495089-large_default/squire-100-xl-exclusive-edition-2021.jpg","<div class=\"rte\"><h2>Squire 100+ XL Exclusive Edition 2021</h2><div><ul><li>Peut contenir jusqu'à 100 cartes protégées avec double sleeves</li><li>Peut contenir un deck commander complet, jetons compris</li><li>Fermetures aimantées et détachables</li><li>Rigide et durable</li></ul></div><div></div><div></div><div>Dimensions: 79x99x105 mm</div><div>Dimensions intérieures: 70x78x95 mm</div><div>Matériau: microfibre Nexofyber+</div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("Gamegenic") ,"Deck box pouvant contenir jusqu'à 100 cartes."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3894 
		 
		 p= new Produit( 18.90 ,"Sidekick 100+ XL  Eclusive Edition 2021", 0 ,"https://cdn3.philibertnet.com/495094-large_default/sidekick-100-xl-eclusive-edition-2021.jpg","<div class=\"rte\"><h2>Sidekick 100+ XL Eclusive Edition 2021</h2><div><ul><li>Peut contenir jusqu'à 100 cartes protégées avec doubles sleeves</li><li>Se charge sur le côté pour garder les cartes de manière horizontale</li><li>Fermeture aimantée et détachable</li><li>Rigide et durable</li></ul></div><div></div><div>Dimensions: 105x99x79 mm</div><div>Dimensions internes: 96x78x68 mm</div><div>Matériau: microfibre Nexofyber+</div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("Gamegenic") ,"Deck Box pouvant contenir jusqu'à 100 cartes protégées."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3895 
		 
		 p= new Produit( 2.50 ,"Meeples Political intrigues", 14 ,"https://cdn2.philibertnet.com/494425-large_default/meeples-cyberpunk-copie.jpg","<div class=\"rte\">Contient 12 pièces. <div><br/></div><div>Dimensions : 18,6 mm de hauteur<br/></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("E-Raptor") ,"Remplacez les pions de vos jeux à thématique \"politique\"ou \"affaires\"par ces meeples en plexiglass. Légers, résistants, ils peuvent avoir de nombreuses utilisations."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3896 
		 
		 p= new Produit( 5.50 ,"Meeples Emoji", 17 ,"https://cdn1.philibertnet.com/494428-large_default/meeples-emoji.jpg","<div class=\"rte\">Contient 27 pièces. <div><br/></div><div>Dimensions : 18,6 mm de hauteur<br/></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("E-Raptor") ,"Affichez votre état d'esprit avec ces Meeples Emoji. En plexiglass, ils vous accompagneront au grée de vos humeurs."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3897 
		 
		 p= new Produit( 33.50 ,"Set d'Upgrades - Wingspan", 5 ,"https://cdn3.philibertnet.com/497223-large_default/set-d-upgrades-wingspan.jpg","<div class=\"rte\">Contient 145 pièces en plastique pour remplacer les pions en carton et les cubes (indiqués sur une photo à titre d'échelle) du jeu.<div><br/></div><div>Contenu:</div><div><ul><li>21 Rongeurs </li><li>21 Poissons </li><li>21 Fruits </li><li>21 Vers </li><li>21 Graines </li><li>8 nichoirs pour chacun des joueurs</li></ul></div><div><div><br/></div><div>Le jeu n'est pas inclus.</div></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("BGExpansions") ,"Les jetons ressources en carton et le cubes en bois du jeu de base seront avantageusement remplacés par ces pions en 3D avec Le Set d'Upgrades - Wingspan."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3898 
		 
		 p= new Produit( 7.90 ,"Set de dés JDR - Transparent Orange/Jaune et Blanc", 0 ,"https://cdn1.philibertnet.com/498161-large_default/set-de-des-jdr-transparent-orange-jaune-et-blanc.jpg","<div class=\"rte\"><h2>Set de 7 dés JDR</h2><div><ul><li>Contient 7 dés: 1xD4,:, 1xD6,:, 1xD8,:, 1xD10,:, 1xD10 décimal,:, 1xD12,:, 1xD20</li><li>Taille: 16 mm</li><li>Matière: Résine Acrylique</li><li>Livré avec une bourse</li></ul></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("SueGao") ,"Set de 7 dés JDR"); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3899 
		 
		 p= new Produit( 21.95 ,"Insert Abyss + Extensions", 9 ,"https://cdn2.philibertnet.com/497982-large_default/insert-abyss-extensions.jpg","<div class=\"rte\">Lorsque la boîte est fermée, les éléments sont toujours en ordre, prêts à être réutilisés pour une autre partie.L'insert est fabriqué en HDF de haute qualité. <div><br/></div><div>Pour l'assembler, il n'y a pas besoin de colle. Il permet de maintenir tous les composants à l'intérieur de la boîte. </div><div><br/></div><div>Dimensions : 28.5 x 28.5 x 8.0 cm<div><br/></div><div>Le jeu et ses extensions ne sont pas inclus.</div></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("E-Raptor") ,"Les composants du jeu Abyss et de ses extensions Kraken et Leviathan trouveront tout naturellement leur place dans l'Insert Abyss + Extensions. À assembler et à glisser dans la boîte du jeu de base."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3900 
		 
		 p= new Produit( 38.95 ,"Set d'Upgrades - Brass Birmingham", 5 ,"https://cdn3.philibertnet.com/497316-large_default/set-d-upgrades-brass-birmingham.jpg","<div class=\"rte\">Contient 127 éléments en plastique.<div><br/></div><div>Contenu: </div><div><ul><li>14 pions train de chaque couleur,</li><li>14 pions bâteau de chaque couleur,</li><li>15 tonneaux de bière.</li></ul></div><div><div><div><br/></div><div>Le jeu n'est pas inclus.</div></div></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("BGExpansions") ,"Votre empire industriel se développera bien mieux avec les pions 3D en plastique du Set d'Upgrades - Brass Birmingham, qui remplaceront les tuiles en carton fournies dans le jeu."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3901 
		 
		 p= new Produit( 52.50 ,"Set d'Upgrades - Scythe", 13 ,"https://cdn2.philibertnet.com/498141-large_default/set-d-upgrades-scythe.jpg","<div class=\"rte\">Contient 121 éléments en plastique.<div><br/></div><div>Contenu: </div><div><ul><li>un Monument pour chaque joueur,</li><li>une Mine pour chaque joueur, </li><li>une Armurerie pour chaque joueur, </li><li>un Moulin pour chaque joueur, </li><li>6 pions Étoile,</li><li>un pion Popularité pour chaque joueur, </li><li>un pion Pouvoir pour chaque joueur, </li><li>12 pions Rencontre, </li><li>une Usine géante.</li></ul></div><div><div><div><br/></div><div>Les bâtiments ont les mêmes dimensions que les pions de base afin de les remplacer sans gêne aucune.</div><div><br/></div><div>Le jeu n'est pas inclus. </div></div></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("BGExpansions") ,"Les pions et les bâtiments du jeu Scythe et de ses extensions Scythe - Conquérants du Lointain et Scythe - Le Réveil de Fenris pourront être remplacés par les éléments du Set d'Upgrades - Scythe pour une plus grande jouabilité."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);

		 //Article numéro 3902 
		 
		 p= new Produit( 126.95 ,"Set d'Upgrades - Gloomhaven", 8 ,"https://cdn3.philibertnet.com/498196-large_default/set-d-upgrades-gloomhaven.jpg","<div class=\"rte\">Contient 139 pièces en plastique pour remplacer les pions en carton du jeu.<div><br/></div><div>Contenu (139 pièces) : </div><div><ul><li>Pack de construction (21) :6 sections de mur, 6 piliers de pierre, 4 escaliers, 4 autels et 1 fontaine. </li><li>Pack de mobilier (25) :5 coffres d'or, 5 coffres d'argent, 4 bibliothèques, 3 tonneaux, 2 armoires, 2 étagères, 2 tables et 2 caisses. </li><li>Pack Nature (42) :6 buissons, 14 rochers, 6 stalagmites, 6 piliers rocheux, 5 souches, 3 rondins, 2 rochers de glace. </li><li>Pack de pièges (27) :6 nasses à poison, 6 pièges à pointes, 6 pièges à ours, 5 mines terrestres, 4 pièges à épines. </li><li>Pack d'extras (24) :6 Totems, 6 jetons Décombres, 4 jetons Brouillard, 4 Nids, 4 Sarcophages. </li></ul></div><div><div><br/></div><div>Le jeu n'est pas inclus.</div></div></div>", 0 , 0 ,"0",true,false,0, 0 , 5 , editeurlink("BGExpansions") ,"Bâtiments, mobiliers, pièges, et autres éléments du jeu seront désormais représentés en 3D avec le Set d'Upgrades - Gloomhaven qui comprend 139 pièces en plastique."); 
		 produitDAO.save(p);
		 liste=produitDAO.getAll();
		 p=liste.get(liste.size()-1);
		 id_produit=p.getId(); 
		  
		 auteurlink("NaN",id_produit);
		  
		 taglink("NaN",id_produit); 
		 taglink("NaN",id_produit);
	
	
	
	
	

	 
	 

	
	
}



}
