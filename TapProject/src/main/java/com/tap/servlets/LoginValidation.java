package com.tap.servlets;

import java.io.IOException;

import com.tap.daoimplementation.UserDAOImpl;
import com.tap.model.Cart;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginValidation") 
public class LoginValidation extends HttpServlet {

    private UserDAOImpl impl = new UserDAOImpl();
    private int count = 3; 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = impl.getUserByEmailId(email);
        HttpSession session = req.getSession();

        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            session.setAttribute("user", user); 

            // Check if there is a pending checkout
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart != null && session.getAttribute("oldRestaurantId") != null) {
                // Redirect back to CheckoutServlet to finish the order
                resp.sendRedirect("checkout");
            } else {
     
                resp.sendRedirect("Restaurant");
            }

        } else {
            // Invalid credentials
            count--;
            if(count > 0) {
                session.setAttribute("loginError", "Invalid credentials. " + count + " attempts left.");
            } else {
                session.setAttribute("loginError", "Attempts over. Contact admin.");
            }
            resp.sendRedirect("login.jsp"); 
        }
    }
}
