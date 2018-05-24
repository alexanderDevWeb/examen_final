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
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.web_service_soap.AlumnoInfo;
import com.ipartek.formacion.web_service_soap.AlumnosPortProxy;
import com.ipartek.formacion.web_service_soap.GetAlumnoRequest;
import com.ipartek.formacion.web_service_soap.GetAlumnoResponse;
import com.ipartek.model.CodigoPostalDAO;
import com.ipartek.pojo.Alert;
import com.ipartek.pojo.Busqueda;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class Prueba2Controller
 */
@WebServlet("/codigos")
public class CodigoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_FORMULARIO = "formCodigos.jsp";

	private CodigoPostalDAO codigoPostalDAO;

	// Parametro para redireccionar
	private RequestDispatcher dispatcher;

	Alert alert;

	ArrayList<String> codigos = new ArrayList<String>();

	// Se instancian y destruyen los DAOs al comienzo y final del ciclo
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.codigoPostalDAO = CodigoPostalDAO.getInstance();
	}

	public void destroy() {
		super.destroy();
		this.codigoPostalDAO = null;
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
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recojo los parametros para la comprobacion
		String codigo = request.getParameter("codigo").trim();

		try {

			// Reseteo el mensaje
			alert = null;
			
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			int id_usuario = usuario.getId();

			// Paso todo a un objeto Busqueda para trabajarlo
			Busqueda busqueda = new Busqueda();
			busqueda.setCodigo(codigo);
			busqueda.setId_usuario(id_usuario);			

			if (codigo != null && !codigo.equals("")) {
				// Hay que guardar todas las consultas mediante el dao
				if (!codigoPostalDAO.guardar(busqueda)) {
					alert = new Alert("No se ha podido guardar la búsqueda", Alert.TIPO_DANGER);
				}

				codigos.add("1");
				codigos.add("2");
				codigos.add("3");
				codigos.add("4");
				codigos.add("5");

				if (codigos.indexOf(codigo) != -1) {					


					System.out.println("Llamando al web service de SOAP");
					
					AlumnosPortProxy client = new AlumnosPortProxy();
					GetAlumnoRequest req = new GetAlumnoRequest("1111111H");
					
					GetAlumnoResponse resp = client.getAlumno(req);		
					AlumnoInfo alumno = resp.getAlumnoInfo();				
					
					
					request.setAttribute("alumno", alumno.getNombre() + " "+ alumno.getApellidos());
					
					// Configuro la respuesta
					String provincia;
					switch (codigo) {
					case "1":
						provincia = "Bizkaia";
						break;
					case "2":
						provincia = "Teruel";
						break;
					case "3":
						provincia = "Soy una tetera";
						break;
					default:
						provincia = "No existe";
						break;
					}

					request.setAttribute("provincia", provincia);

				} else {
					alert = new Alert("La búsqueda debe estar entre los números 1-5", Alert.TIPO_WARNING);
				}
			} else {
				alert = new Alert("Debe enviar alguna búsqueda", Alert.TIPO_WARNING);
			}

		} catch (Exception e) {
			e.printStackTrace();
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			dispatcher = request.getRequestDispatcher(VIEW_FORMULARIO);
			dispatcher.forward(request, response);
		}
	}
}
