package mx.aja.pyme.ordenes.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.aja.pyme.ordenes.dto.DtoOrden;

public interface OrdenSrv {

	DtoOrden add(String userId, DtoOrden orden);
	DtoOrden update(String userId, String ordenId, DtoOrden orden);
	DtoOrden findById(String ordenId);
	Page<DtoOrden> findAll(String userId, Pageable pageable);
	
}
