package com.ipartek.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.model.PruebaDAO;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class PruebaController
 */
@WebServlet("/prueba")
public class PruebaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Constantes con las vistas a mostrar
	private static final String VIEW_LOGIN = "index.jsp";
	private static final String VIEW_USUARIOS = "usuarios.jsp";
	private static final String VIEW_FORMULARIO = "formulario.jsp";

	private PruebaDAO pruebaDAO;
	private RequestDispatcher dispatcher;

	private int opcion;

	// Se instancian y destruyen los DAOs al comienzo y final del ciclo
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		pruebaDAO = PruebaDAO.getInstance();
	}

	public void destroy() {
		super.destroy();
		pruebaDAO = null;
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
		doProcess(request, response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * Recoge la información ya venga por GET o por POST
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// En este ejemplo solo recoge opcion
		recogerParametros(request);
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {

			if (this.opcion != 1) {

				String nombre = request.getParameter("usuario");
				String password = request.getParameter("password");

				

				pruebaDAO = PruebaDAO.getInstance();
				usuarios = pruebaDAO.getAll(nombre);

				// Preparar los atributos a enviar
				request.setAttribute("usuarios", usuarios);
				request.setAttribute("nombre", nombre);
				request.setAttribute("password", password);

				// Enviar a la vista correspondiente
				dispatcher = request.getRequestDispatcher(VIEW_USUARIOS);
			} else {
				
				// Añado algo a la lista de forma provisional para que funcione
				Usuario userTest = new Usuario();
				userTest.setNombre("Pako");
				usuarios.add(userTest);
				
				request.setAttribute("usuarios", usuarios);
				
				dispatcher = request.getRequestDispatcher(VIEW_FORMULARIO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		// Resuelve la carga de la vista
		dispatcher.forward(request, response);
	}

	private void recogerParametros(HttpServletRequest request) {

		if (request.getParameter("opcion") != null) {
			opcion = Integer.parseInt(request.getParameter("opcion"));
		} else {
			opcion = 0;
		}

	}

}
