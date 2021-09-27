package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Database;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		boolean messagemailno = false;
		boolean messageinscriptionok = false;
		if (request.getParameter("bsave") != null) {
			UtilisateurDAO utilisateurdao = new UtilisateurDAO();
			String mail = request.getParameter("email");
			if (utilisateurdao.mailcheck(mail) == false) {
				messagemailno = true;
				
			} else {
				String mdp = request.getParameter("pwd");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String tel = request.getParameter("tel");
				String sex=request.getParameter("gender");
				String nomdb=sex+"-"+nom+"-"+prenom;
				Utilisateur utilisateur = new Utilisateur(nomdb, mail, mdp, 0, tel);
				utilisateurdao.save(utilisateur);
				messageinscriptionok=true;
			}

		}
		request.setAttribute("messagemailno", messagemailno);
		request.setAttribute("messageinscriptionok", messageinscriptionok);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
