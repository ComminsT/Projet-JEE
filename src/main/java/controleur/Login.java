package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Database;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Database.Connect();
		boolean connected = false;
		boolean messageconnexionno=false;
		if(request.getParameter("blogin")!=null) {
		String mail=request.getParameter("email");
		String mdp=request.getParameter("pwd");
		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		Utilisateur u = utilisateurdao.connexion(mail, mdp);
		if(u==null) {
			System.out.println("CONNEXION NO");
			messageconnexionno=true;
		}else {
				System.out.println("CONNEXION OK");
				HttpSession session = request.getSession(true);
				session.setAttribute("userid", u.getId());
				session.setAttribute("usernom", u.getNom());
				session.setAttribute("isConnected", true);
				connected=true;
				response.sendRedirect("Index");
			}
		}
		
		request.setAttribute("messageconnexionno", messageconnexionno);
		
		if(connected==false) {
			request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
