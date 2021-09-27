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
 * Servlet implementation class Modifier_produit
 */
@WebServlet(name = "Modifier_produit", urlPatterns = { "/Admin/Modifier_produit" })
public class Modifier_produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		boolean messageok=false;
		
		Database.Connect();
		ProduitDAO produitdao=new ProduitDAO();

		int id=Integer.valueOf(request.getParameter("id"));
		
		Produit cproduit=produitdao.getById(id);
		
		CategorieDAO categoriedao=new CategorieDAO();
		
		ArrayList<Categorie> cats = new ArrayList<Categorie>();

		cats=categoriedao.getAll();
		
		
		
		
		
		
		

		if(request.getParameter("bmodifier")!=null ) {
			String titre=request.getParameter("titre");
			Double prix=Double.parseDouble(request.getParameter("prix"));
			int qte=Integer.valueOf(request.getParameter("qte"));
			String image=request.getParameter("image");
			int categorie_id=Integer.valueOf(request.getParameter("categorie_id"));
			int jmin=Integer.valueOf(request.getParameter("jmin"));
			int jmax=Integer.valueOf(request.getParameter("jmax"));
			int amin=Integer.valueOf(request.getParameter("amin"));
			String description=request.getParameter("description");
			String descriptionm=request.getParameter("descriptionm");
			Boolean visible=true;
			if(request.getParameter("visible")!=null) {
				visible=true;
			}else {
				visible=false;
			}
			
			cproduit.setTitre(titre);
			cproduit.setPrix(prix);
			cproduit.setQuantite(qte);
			cproduit.setImg(image);
			cproduit.setId_categorie(categorie_id);
			cproduit.setNbrjoueurmin(jmin);
			cproduit.setNbrjoueurmax(jmax);
			cproduit.setAge(amin);
			cproduit.setVisible(visible);
			cproduit.setDescription(description);
			cproduit.setDescriptionsm(descriptionm);
			cproduit.setEnavant(false);
			produitdao.save(cproduit);
			System.out.println("EDIT OK");
			messageok=true;
			
		}
		
		
		request.setAttribute("cats", cats);
		request.setAttribute("cproduit", cproduit);
		request.setAttribute("messageok", messageok);
		request.getRequestDispatcher( "/Admin/modifier_produit.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
