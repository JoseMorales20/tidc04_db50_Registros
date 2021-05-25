package cl.inacap.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cl.inacap.registrosModel.dao.SolicitudesDAOLocal;
import cl.inacap.registrosModel.dto.Solicitud;

/**
 * Servlet implementation class AtenderSolicitudController
 */
@WebServlet("/AtenderSolicitudController.do")
public class AtenderSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	
	private SolicitudesDAOLocal solicitudesDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtenderSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Solicitud> solicitudes = solicitudesDAO.getAll();
		if(request.getParameter("atender") != null) {
			String nombre = request.getParameter("atender").trim();
			List<Solicitud> busqueda = solicitudesDAO.filterByName(nombre);
			Solicitud atenderCliente = busqueda.isEmpty()? null:busqueda.get(0);
			if(atenderCliente != null) {
				solicitudesDAO.delete(atenderCliente);
			}
		}
		request.setAttribute("solicitudes", solicitudes);
		request.getRequestDispatcher("WEB-INF/vistas/atencionSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
