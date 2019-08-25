package mx.aja.pyme.ordenes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.aja.pyme.ordenes.dto.DtoOrden;
import mx.aja.pyme.ordenes.service.OrdenSrv;

@RestController
@RequestMapping("/api/v0/pymes")
public class ApiController {

	@Autowired
	private OrdenSrv ordenSrv;
    @Autowired
    private PagedResourcesAssembler<DtoOrden> assemblerOrden;
    
    /*Listado de ordenes*/
	@GetMapping(path = "/{userId}/ordenes", produces = "application/json")
	public HttpEntity<PagedResources<Resource<DtoOrden>>> getAllOrdenes(@PathVariable("userId") String userId, Pageable pageable) {
		Page<DtoOrden> widgets = ordenSrv.findAll(userId, pageable);
		return new ResponseEntity<>(assemblerOrden.toResource(widgets), HttpStatus.OK);
	}
	
    /*get orden*/
	@GetMapping(path = "/{userId}/ordenes/{ordenId}", produces = "application/json")
	public ResponseEntity<DtoOrden> getOrden(@PathVariable("userId") String userId, @PathVariable("ordenId") String ordenId) {
		return new ResponseEntity<>(ordenSrv.findById(ordenId), HttpStatus.OK);
	}
	
	/*Actualizar estado orden*/
	@PatchMapping(path = "/{userId}/ordenes/{ordenId}", produces = "application/json")
	public ResponseEntity<DtoOrden> updateEstadoOrden(@PathVariable("userId") String userId, @PathVariable("ordenId") String ordenId, @RequestBody DtoOrden request) {
		return new ResponseEntity<>(ordenSrv.update(userId, ordenId, request), HttpStatus.OK);
	}
	
	/*Agregar orden*/
	@PostMapping(path = "/{userId}/ordenes", produces = "application/json")
	public ResponseEntity<DtoOrden> addOrden(@PathVariable("userId") String userId, @RequestBody DtoOrden request) {
		return new ResponseEntity<>(ordenSrv.add(userId, request), HttpStatus.OK);
	}
}
