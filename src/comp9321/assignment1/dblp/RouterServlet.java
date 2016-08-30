package comp9321.assignment1.dblp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method");
		PrintWriter printer = response.getWriter();
		printer.println("<h1>hello</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST method");
		String action = request.getParameter("action");
		PrintWriter printer = response.getWriter();

		if (action.equals("add_cart")) {
			HttpSession session = request.getSession();
			ArrayList<String> itemList = new ArrayList<String>();

			if (session.getAttribute("cart") != null)
				itemList = (ArrayList<String>) session.getAttribute("cart");
			System.out.println("Cart---------------------");
			for (String item : itemList)
				System.out.println(item);

			itemList.add(request.getParameter("title"));
			session.setAttribute("cart", itemList);

			String response_content = "<div class=\"col-md-12 panel panel-primary\"><div><h6>"
					+ request.getParameter("title")
					+ "<button class=\"btn btn-warning btn-xs cart\">Remove</button></h6></div></div>";
			printer.println(response_content);
		}

	}

}
