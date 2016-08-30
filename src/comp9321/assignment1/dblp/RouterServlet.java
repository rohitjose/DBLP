package comp9321.assignment1.dblp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RouterServlet
 */

public class RouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.  
     */
    public RouterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method");
		PrintWriter printer = response.getWriter();
		printer.println("<h1>This is stupid, I should already know all this</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST method");
		String strAction = request.getParameter("form_action");
		PrintWriter printer = response.getWriter();
		Enumeration<String> parameters = request.getParameterNames();
		while(parameters.hasMoreElements()){
			String parameter = parameters.nextElement();
			printer.println(parameter+":"+request.getParameter(parameter));
			System.out.println("Parameter="+parameter+"\n"+"Value="+request.getParameter(parameter));
		}
		
		printer.println("<h1>This is stupid, I should already know all this</h1>");		
		System.out.println(strAction);
	}

}
