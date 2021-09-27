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

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "IndexAdmin", urlPatterns = { "/Admin/Index" })
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
		CategorieDAO categoriedao=new CategorieDAO();
		ArrayList<Categorie> cats = new ArrayList<Categorie>();

		cats=categoriedao.getAll();
		
		String char_cats_titre="";
		String char_cats_nbr="";
		
		for(Categorie cat:cats){ 
			char_cats_titre+= "'"+cat.getTitre()+"',";
			
			char_cats_nbr+= categoriedao.getCountProduitsById(cat.getId())+",";
		
		}
		System.out.println(char_cats_titre);
		System.out.println(char_cats_nbr);
		request.setAttribute("char_cats_titre", char_cats_titre);
		request.setAttribute("char_cats_nbr", char_cats_nbr);
		
		request.getRequestDispatcher( "/Admin/index.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
