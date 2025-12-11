package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.daoimplementation.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/menu")
public class MenuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		System.out.println("menu servlet called");
//		
		
//		System.out.println(rId);
		
		
        String id = req.getParameter("restaurantId");
        

        if (id == null || id.isEmpty()) {
            resp.getWriter().println("restaurantId is missing in the URL");
            return;
        }

        int rId = Integer.parseInt(id);

	    req.getSession().setAttribute("restaurantId", rId);

        MenuDAOImpl menuDAO = new MenuDAOImpl();
        List<Menu> menuList = menuDAO.getMenuByRestaurantId(rId);

        req.setAttribute("allMenu", menuList);
        RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
        rd.forward(req, resp);


	}

	
}
