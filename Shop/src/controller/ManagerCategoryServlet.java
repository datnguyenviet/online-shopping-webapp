package controller;

import dao.CategoryDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;



public class ManagerCategoryServlet extends HttpServlet {       

	CategoryDAO categoryDAO = new CategoryDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String category_id = request.getParameter("category_id");
		
		String url = "";
		try {
				switch(command) {

					case "delete":
						categoryDAO.deleteCategory(Long.parseLong(category_id));
						url = "/admin/manager_category.jsp";
						break;
					}	

		}catch (Exception e) {

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
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
					case "update":
						categoryDAO.updateCategory(new Category(Long.parseLong(request.getParameter("category_id")), nameCategory));
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
