package com.ipartek.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.model.PruebaDAO;

/**
 * Servlet implementation class Prueba2Controller
 */
@WebServlet("/prueba2")
public class Prueba2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Parametro para redireccionar
	private RequestDispatcher dispatcher;
	
	
	// Parametros a tratar
	int param1;
	String param2;
	int param3;	
	
       
	// Se instancian y destruyen los DAOs al comienzo y final del ciclo
	public void init(ServletConfig config) throws ServletException {
		super.init(config);		
		// pruebaDAO = PruebaDAO.getInstance();
	}
	
	public void destroy() {
		super.destroy();		
		// pruebaDAO = null;
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
		doProcess(request, response);
	}


	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);		
	}
	
    /**
     * 
     * @param request
     * @param response
     */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {		
		recogerParametros(request);		
	}
	
	private void recogerParametros(HttpServletRequest request) {

		if (request.getParameter("param1") != null) {
			param1 = Integer.parseInt(request.getParameter("opcion"));
		} else {
			param1 = 0;
		}
		
		if (request.getParameter("param2") != null) {
			param2 = request.getParameter("opcion");
		} else {
			param2 = "";
		}
		
		if (request.getParameter("param3") != null) {
			param3 = Integer.parseInt(request.getParameter("opcion"));
		} else {
			param3 = 0;
		}
	}

}
