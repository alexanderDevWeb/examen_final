package com.ipartek.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.model.UsuarioDAO;
import com.ipartek.pojo.Alert;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class PruebaController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Constantes con las vistas a mostrar
	private static final String VIEW_LOGIN = "index.jsp";
	private static final String VIEW_FORMULARIO = "formCodigos.jsp";

	private UsuarioDAO usuarioDAO;
	private RequestDispatcher dispatcher;

	private Alert alert;

	// Se instancian y destruyen los DAOs al comienzo y final del ciclo
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDAO = UsuarioDAO.getInstance();
	}

	public void destroy() {
		super.destroy();
		usuarioDAO = null;
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
		alert = null;

		try {

			// Recojo los parametros para la comprobacion
			String nombre = request.getParameter("usuario").trim();
			String password = request.getParameter("password").trim();
			
			// Control de datos introducidos
			if (nombre.equals("") || password.equals("")) {
				alert = new Alert("Los campos no pueden dejarse en blanco", Alert.TIPO_WARNING);
				dispatcher = request.getRequestDispatcher(VIEW_LOGIN);
			} else if (nombre.length() < 5) {
				alert = new Alert("El nombre no puede tener menos de 5 caracteres", Alert.TIPO_WARNING);
				dispatcher = request.getRequestDispatcher(VIEW_LOGIN);
			} else {

				// Hago la consulta en el DAO y devuelvo el usuario en caso de existir
				Usuario usuario = usuarioDAO.check(nombre, password);

				// Si existe el usuario
				if (usuario != null) {
					// guardar usuario en session para tratarlo más adelante
					HttpSession session = request.getSession();
					session.setAttribute("usuario", usuario);

					alert = new Alert("Ongi Etorri " + nombre.toUpperCase(), Alert.TIPO_PRIMARY);

					dispatcher = request.getRequestDispatcher(VIEW_FORMULARIO);

				} else { // Si no existe vuelve al login con un alert
					dispatcher = request.getRequestDispatcher(VIEW_LOGIN);
					alert = new Alert("Credenciales incorrectas, prueba de nuevo");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher(VIEW_LOGIN);
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			dispatcher.forward(request, response);
		}

	}	
}
