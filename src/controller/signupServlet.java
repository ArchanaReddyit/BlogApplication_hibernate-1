package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/signup")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher br=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		br.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		LocalDate date=LocalDate.now();
		
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDao ud=new UserDao();
		user.setDate(date);
		int checkUser=ud.signup(user);
		if(checkUser!=0)
		{
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getDate());
			
			request.setAttribute("message", "registeration successfull");
			RequestDispatcher br=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			br.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "check your credentials");
			RequestDispatcher br=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			br.forward(request, response);
			
		}
			
		
	}

}
