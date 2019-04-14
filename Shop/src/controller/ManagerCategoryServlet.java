package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;



public class ManagerCategoryServlet extends HttpServlet {       

	CategoryDAO categoryDAO = new CategoryDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String nameCategory = request.getParameter("nameCategory");
		
		String url = "", error = "";
		if (nameCategory.equals("")) {
			error = "Please enter name of category";
			request.setAttribute("error", error);
		}
		
		try {
			if (error.length() == 0) {
				switch(command) {
					case "insert":
						categoryDAO.insertCategory(new Category(new Date().getTime(), nameCategory));
						url = "/admin/manager_category.jsp";
						break;
					}	
				}else {
					url = "/admin/insert_category.jsp";
				}
		}catch (Exception e) {

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
