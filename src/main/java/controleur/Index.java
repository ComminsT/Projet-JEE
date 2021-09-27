package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Panier;
import models.PanierDetails;
import models.Produit;
import models.ProduitDAO;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		ProduitDAO produitdao = new ProduitDAO();
		ArrayList<Produit>produits = produitdao.getAll();
		ArrayList<Produit>news=new ArrayList<Produit>();
		for(int i=produits.size()-40;i<produits.size();i++) {
			news.add(produits.get(i));
		}
		request.setAttribute("news", news);
		
		if(request.getParameter("badd")!=null ) {
			int id_produit=Integer.valueOf(request.getParameter("badd"));
			Produit cproduit= produitdao.getById(id_produit);
			HttpSession session = request.getSession( true );
			int qte=1;
			PanierDetails panieradd=new PanierDetails(cproduit,qte);
			Panier panier=(Panier) session.getAttribute("panier");
			panier.ajouter(panieradd);
			session.setAttribute( "panier", panier );
			System.out.println((Panier) session.getAttribute("panier"));	
	}
		
		request.getRequestDispatcher( "/index.jsp" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
