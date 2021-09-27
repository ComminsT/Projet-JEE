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
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		Database.Connect();
		ProduitDAO produitdao=new ProduitDAO();
		ArrayList<Produit> prods = new ArrayList<Produit>();
		CategorieDAO categoriedao = new CategorieDAO();
		int id=Integer.valueOf(request.getParameter("id"));
		Produit cproduit=produitdao.getById(id);
		Categorie categorie=categoriedao.getById(cproduit.getId_categorie());
		request.setAttribute("cat",categorie);
		
		int produit_categorie=cproduit.getId_categorie();
		
		prods=produitdao.getAllByCategorieId(produit_categorie);
				
		request.setAttribute("cproduit", cproduit);
		request.setAttribute("prods", prods);
		
		//AJOUTER AU PANIER
		if(request.getParameter("badd")!=null ) {
			HttpSession session = request.getSession( true );
			int qte=Integer.valueOf(request.getParameter("pqte"));
			PanierDetails panieradd=new PanierDetails(cproduit,qte);
			Panier panier=(Panier) session.getAttribute("panier");
			panier.ajouter(panieradd);
			session.setAttribute( "panier", panier );
			System.out.println((Panier) session.getAttribute("panier"));
			
			
	}
		request.getRequestDispatcher( "/details.jsp" ).include( request, response );
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
