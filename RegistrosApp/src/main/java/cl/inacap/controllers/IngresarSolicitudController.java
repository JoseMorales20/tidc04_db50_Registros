package cl.inacap.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.registrosModel.dao.SolicitudesDAOLocal;
import cl.inacap.registrosModel.dto.Solicitud;

/**
 * Servlet implementation class IngresarSolicitudController
 */
@WebServlet("/IngresarSolicitudController.do")
public class IngresarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SolicitudesDAOLocal solicitudesDAO;
	
	public static boolean validarRut(String rut) {  //https://es.stackoverflow.com/questions/118104/validacion-de-rut-en-java <- pagina referencia
		boolean validacion = false;
		
		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".","");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0,rut.length() - 1));
			char dv = rut.charAt(rut.length() - 1);
			int m = 0, s = 1;
			for(;rutAux != 0; rutAux /=10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if(dv == (char) (s != 0 ? s + 47 : 75)){
				validacion = true;
			}
					
		}catch(java.lang.NumberFormatException e){
		}catch(Exception e){
			
		}
		
		return validacion;
				
	}
	
	private AtomicInteger counter; //https://www.it-swarm-es.com/es/java/usos-practicos-de-atomicinteger./972090787/ <- pagina referencia
	public int getNextUniqueIndex() {
		return counter.getAndIncrement();
	}

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/ingresoSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores = new ArrayList<>();
		
		String rut = request.getParameter("rut-txt").trim();
		if(validarRut(rut) == false) {
			errores.add("debe ingresar correctamente su rut");
		}
		String nombre = request.getParameter("nombre-txt").trim();
		if(nombre.isEmpty()) {
			errores.add("debe ingresar su nombre y apellido");
		}
		String tipo = request.getParameter("tipo-select").trim();
		if(tipo.isEmpty()) {
			errores.add("seleccione el tipo de solicitud");
		}
		if(errores.isEmpty()) {
			Solicitud solicitud = new Solicitud();
			solicitud.setNumeroSoli(counter.getAndIncrement());
			solicitud.setRut(rut);
			solicitud.setNombre(nombre);
			solicitud.setTipo(tipo);
			solicitudesDAO.save(solicitud);
			request.setAttribute("mensaje", "consola ingresada exitosamente");
		}else {
			request.setAttribute("errores", errores);
		}
		
		doGet(request, response);
	}

}
