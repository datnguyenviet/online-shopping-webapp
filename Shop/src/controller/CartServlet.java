package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Product;
import model.Item;


public class CartServlet extends HttpServlet {
	private final ProductDAO productDAO = new ProductDAO(); 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String productID = request.getParameter("productID");
		Cart cart = (Cart) session.getAttribute("cart");
		
		try {
			Long idProduct = Long.parseLong(productID);
			Product product = productDAO.getProduct(idProduct);
			switch (command) {
				case "plus":
					if(cart.getCartItems().containsKey(idProduct)) {
						cart.plusToCart(idProduct, 
								new Item(product, cart.getCartItems().get(idProduct).getQuantity()));
						
					}else {
						cart.plusToCart(idProduct, new Item(product,1));
					}
					break;
				case "remove":
					cart.removeToCart(idProduct);
					break;
					
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/Shop/index.jsp");
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("/Shop/index.jsp");
	}

}
