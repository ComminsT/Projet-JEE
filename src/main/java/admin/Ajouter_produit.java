package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Categorie;
import models.CategorieDAO;
import models.Database;
import models.Produit;
import models.ProduitDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Ajouter_produit
 */
@WebServlet(name = "Ajouter_produit", urlPatterns = { "/Admin/Ajouter_produit" })
public class Ajouter_produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		CategorieDAO categoriedao=new CategorieDAO();
		
		ArrayList<Categorie> cats = new ArrayList<Categorie>();
		
		cats=categoriedao.getAll();
		request.setAttribute("cats", cats);
		
		boolean messageok=false;
		if(request.getParameter("bajouter")!=null ) {
			String titre=request.getParameter("titre");
			Double prix=Double.parseDouble(request.getParameter("prix"));
			int qte=Integer.valueOf(request.getParameter("qte"));
			String image=request.getParameter("image");
			int categorie_id=Integer.valueOf(request.getParameter("categorie_id"));
			
			ProduitDAO produitdaodao=new ProduitDAO();
			//Produit p=new Produit(titre,prix,qte,categorie_id,image);
			//produitdaodao.save(p);
			System.out.println("ADD OK");
			messageok=true;
			
		}
		
		request.setAttribute("messageok", messageok);
		request.getRequestDispatcher( "/Admin/ajouter_produit.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
