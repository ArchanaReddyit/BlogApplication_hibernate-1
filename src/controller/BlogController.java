package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDaoImpl;
import model.Blog;

/**
 * Servlet implementation class BlogController
 */

@WebServlet(urlPatterns ={"/new"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static int i=0; 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public BlogController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Getting into Add New Blog");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogListView.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering do post");
		String blogTitle = request.getParameter("title");
		String blogDescription = request.getParameter("message");
		LocalDate postedOn = LocalDate.now();
		System.out.println(blogTitle);
		
		Blog blog = new Blog();
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setPostedOn(postedOn);
		
		BlogDaoImpl blogDao = new BlogDaoImpl();
		try {
			blogDao.insertBlog(blog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("allblogs");
	}

}
