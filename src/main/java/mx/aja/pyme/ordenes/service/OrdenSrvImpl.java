package mx.aja.pyme.ordenes.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.aja.pyme.ordenes.dto.DtoOrden;
import mx.aja.pyme.ordenes.dto.DtoOrdenProducto;
import mx.aja.pyme.ordenes.repository.OrdenProductoRepo;
import mx.aja.pyme.ordenes.repository.OrdenRepo;

@Service
public class OrdenSrvImpl implements OrdenSrv {

	@Autowired
	private OrdenRepo ordenRepo;
	@Autowired
	private OrdenProductoRepo ordenProductoRepo;
	
	@Override
	public DtoOrden update(String userId, String ordenId, DtoOrden orden) {
		orden.setUserId(userId);
		orden.setOrdenId(ordenId);
		return ordenRepo.save(orden);
	}

	@Override
	public DtoOrden findById(String ordenId) {
		return ordenRepo.findById(ordenId).get();
	}

	@Override
	public Page<DtoOrden> findAll(String userId, Pageable pageable) {
		return ordenRepo.findByUserId(userId, pageable);
	}

	@Override
	public DtoOrden add(String userId, DtoOrden orden) {
		orden.setUserId(userId);
		orden.setFechCreado(new Date());
		Double total = new Double(0);
		if(orden.getHistorial() != null) {
			for(DtoOrdenProducto ord : orden.getHistorial()) {
				if(orden.getHistorial() != null) {
					for(DtoOrdenProducto hist : orden.getHistorial()) {
						hist.setTotal(hist.getCantidad() * hist.getPrecioUnitario());
					}
				}
				total = total + ord.getTotal();
			}
		}
		orden.setTotal(total);
		orden.setHistorial(ordenProductoRepo.insert(orden.getHistorial()));
		return ordenRepo.save(orden);
	}

}
