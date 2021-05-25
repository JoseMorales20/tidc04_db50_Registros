package cl.inacap.registrosModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.registrosModel.dto.Solicitud;

@Local
public interface SolicitudesDAOLocal {
	
	void save(Solicitud solicitud);
	List<Solicitud> getAll();
	void delete(Solicitud solicitud);
	List<Solicitud> filterByName(String nombre);
}
