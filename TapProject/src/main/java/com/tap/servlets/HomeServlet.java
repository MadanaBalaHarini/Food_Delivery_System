package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.daoimplementation.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Restaurant")
public class HomeServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();

	        List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurant();

	        req.setAttribute("allRestaurants",allRestaurants);
	        RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
	        
	        rd.forward(req, resp);

	        
	}

}
