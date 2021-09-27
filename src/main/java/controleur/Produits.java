package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Categorie;
import models.CategorieDAO;
import models.Database;
import models.Panier;
import models.PanierDetails;
import models.Produit;
import models.ProduitDAO;

/**
 * Servlet implementation class Produits
 */
@WebServlet("/Produits")
public class Produits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		int pagenumber=Integer.valueOf(request.getParameter("p"));
		CategorieDAO categorieDAO = new CategorieDAO();
		ProduitDAO produitDAO = new ProduitDAO();
		
		int id=Integer.valueOf(request.getParameter("id"));
		ArrayList<Produit> prods = produitDAO.getAllByCategorieId(id);
		int nbrdepage=Math.round(prods.size()/20);
		ArrayList<Produit>display= new ArrayList<Produit>();
		for(int i=(pagenumber-1)*20;i<((pagenumber-1)*20)+20;i++) {
			display.add(prods.get(i));
		}
		ArrayList<Categorie>categories = categorieDAO.getAll();
		String titre = categorieDAO.getById(id).getTitre();
		request.setAttribute("currentp", pagenumber);
		request.setAttribute("id_cat", id);
		request.setAttribute("nbrdepage", nbrdepage);
		request.setAttribute("titre",titre);
		request.setAttribute("prods",display);
		request.setAttribute("cat", categories);
		request.setAttribute("maxitem", prods.size());
		
		
		if(request.getParameter("badd")!=null ) {
			int id_produit=Integer.valueOf(request.getParameter("badd"));
			Produit cproduit= produitDAO.getById(id_produit);
			System.out.print("s");
			HttpSession session = request.getSession( true );
			int qte=1;
			PanierDetails panieradd=new PanierDetails(cproduit,qte);
			Panier panier=(Panier) session.getAttribute("panier");
			panier.ajouter(panieradd);
			session.setAttribute( "panier", panier );
			System.out.println((Panier) session.getAttribute("panier"));
			
			
	}
		
		request.getRequestDispatcher( "/produits.jsp" ).forward( request, response );
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
