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

/**
 * Servlet implementation class Liste_produitsAdmin
 */
@WebServlet(name = "Liste_produitsAdmin", urlPatterns = { "/Admin/Liste_produits" })
public class Liste_produitsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_produitsAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		ProduitDAO produitdao=new ProduitDAO();
		
		if(request.getParameter("delete")!=null ) {
			int idtodelete=Integer.valueOf(request.getParameter("delete"));
			produitdao.deleteById(idtodelete);
		}
		
		ArrayList<Produit> prods = new ArrayList<Produit>();
		prods=produitdao.getAllRAW();
		request.setAttribute("prods", prods);
		
		request.getRequestDispatcher( "/Admin/liste_produits.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
