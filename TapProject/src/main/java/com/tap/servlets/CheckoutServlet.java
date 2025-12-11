package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.dao.OrdersDAO;
import com.tap.daoimplementation.OrderItemDAOImpl;
import com.tap.daoimplementation.OrdersDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderItems;
import com.tap.model.Orders;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	private OrdersDAO orderDAO;
	private OrderItemDAOImpl orderItemDAOImpl;
	@Override
	public void init()
	{
		orderDAO=new OrdersDAOImpl();
		orderItemDAOImpl=new OrderItemDAOImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
				ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		int restaurantId=(int) session.getAttribute("oldRestaurantId");
		session.setAttribute("oldRestaurantId", restaurantId);

		User user=(User) session.getAttribute("user");

		if (user == null) {

		    resp.sendRedirect("login.jsp");
		    return; 
		}

		//processOrder(req, resp, session, user, cart);
//		if(user==null) {
//			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
//			rd.forward(req, resp);
//		}
		

		if(cart != null && user != null && !cart.getItems().isEmpty()) {


			String address = req.getParameter("address");
			String paymentMethod = req.getParameter("paymentMethod");

			
			Orders order=new Orders();
			order.setUserid(user.getUserId());
			//order.setRestaurantid((int) session.getAttribute("restaurantid"));
			order.setRestaurantid(restaurantId);
			order.setOrderdate(new Timestamp(System.currentTimeMillis()));
			order.setPaymentmethod(paymentMethod);
			order.setDeliveryaddress(address);
			order.setStatus("pending");
	
			double totalAmount=0;
			for(CartItem item:cart.getItems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			
			order.setTotalamount(totalAmount);

				
			try {
				  int orderId = orderDAO.addOrder(order); 
				    
				  for(CartItem item : cart.getItems().values()) {
				        OrderItems orderItem = new OrderItems(orderId, item.getId(), item.getQuantity(), item.getTotalPrice());
				        orderItemDAOImpl.addOrderItem(orderItem); 
				   }
				    
				   session.removeAttribute("cart");
				   session.setAttribute("order", order);
				   resp.sendRedirect("order_confirmation.jsp");
				    
				} catch(Exception e) {
				    e.printStackTrace(); 
				}
	
								
			}
			else{
				resp.sendRedirect("cart.jsp");
			}
		
		}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
