package comp9321.assignment1.dblp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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

		String title = request.getParameter("title");
		String hashcode = request.getParameter("hashcode");
		HttpSession session = request.getSession();

		if (action.equals("add_cart")) {
			ArrayList<HashMap<String, String>> itemList = new ArrayList<HashMap<String, String>>();

			if (session.getAttribute("cart") != null)
				itemList = (ArrayList<HashMap<String, String>>) session
						.getAttribute("cart");
			System.out.println("Cart---------------------");

			HashMap<String, String> item = new HashMap<String, String>();
			item.put("title", title);
			item.put("hashcode", hashcode);

			itemList.add(item);
			session.setAttribute("cart", itemList);

			String response_content = "<div class=\"col-md-12 panel panel-primary\" id=\"cart_item"
					+ hashcode
					+ "\"><div><h6>"
					+ title
					+ "<button class=\"btn btn-warning btn-xs cart\" onclick=\"removeCartItem('cart_item"
					+ hashcode
					+ "','"
					+ title
					+ "')\">Remove</button></h6></div></div>";
			System.out.println(response_content);
			printer.println(response_content);
		} else if (action.equals("remove_cart")) {

			hashcode = hashcode.replaceAll("cart_item", "");
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("title", title);
			item.put("hashcode", hashcode);

			// Remove item from the session cart
			ArrayList<HashMap<String, String>> cart = (ArrayList<HashMap<String, String>>) session
					.getAttribute("cart");

			cart.remove(item);
			session.setAttribute("cart", cart);

			// Set the response value
			String response_content = new String();
			if (cart.size() == 0) {
				response.setContentType("text/html");
				response_content = "<div class=\"col-md-12 panel panel-primary\" id=\"empty_cart\"><div><h6>Shopping Cart is Empty!</h6></div></div>";
			} else{
				response.setContentType("text/plain");
				response_content = "";
			}
			printer.println(response_content);
		}

	}

}
