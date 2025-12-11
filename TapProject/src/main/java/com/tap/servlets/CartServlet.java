package com.tap.servlets;

import java.io.IOException;

import com.tap.daoimplementation.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/callingCartServlet")
public class CartServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    handleRequest(req, resp);
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//System.out.println("Called cart servlet");
		handleRequest(req, resp);
	}
	
	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {

	    HttpSession session = req.getSession();

	    // Get cart from session
	    Cart cart = (Cart) session.getAttribute("cart");

	    // Read new restaurantId
	    int newRestaurantId = Integer.parseInt(req.getParameter("restaurantId"));

	    // Read old restaurantId saved earlier
	    Integer oldRestaurantIdObj = (Integer) session.getAttribute("oldRestaurantId");
	    int oldRestaurantId = (oldRestaurantIdObj == null) ? 0 : oldRestaurantIdObj;

	    // If cart empty OR restaurant changed → clear cart
	    if (cart == null || oldRestaurantId != newRestaurantId) {
	        cart = new Cart();  
	        session.setAttribute("cart", cart);  
	        session.setAttribute("oldRestaurantId", newRestaurantId);  
	    }

	    // Read action
	    String action = req.getParameter("action");

	    int itemId = Integer.parseInt(req.getParameter("itemId"));

	    // Now perform actions
	    if (action.equals("add")) {
	        addItemToCart(req, cart, newRestaurantId);
	    }
	    else if (action.equals("update")) {
	        updateItemInCart(req, cart);
	    }
	    else if (action.equals("remove")) {
	        deleteItemFromCart(req, cart);
	    }

	    resp.sendRedirect("cart.jsp");
	}

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
	}

	private void updateItemInCart(HttpServletRequest req, Cart cart) {
	    String itemParam = req.getParameter("itemId");
	    String qtyParam = req.getParameter("quantity");
	    if (itemParam == null || qtyParam == null || cart == null) return;

	    int itemId = Integer.parseInt(itemParam);
	    int quantity = Integer.parseInt(qtyParam);

	    if (quantity <= 0) cart.removeItem(itemId);
	    else cart.updateQuantity(itemId, quantity);

		//cart.updateQuantity(itemId, quantity);
	}

	private void addItemToCart(HttpServletRequest req, Cart cart, int restaurantId) {
		
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
        Menu menu = menuDAOImpl.getMenu(itemId);

        String itemName = menu.getMenuname();
        double price = menu.getPrice();

        CartItem cartItem = new CartItem(itemId, itemName, price, quantity,1);
        cart.addItem(cartItem);
	}

}
