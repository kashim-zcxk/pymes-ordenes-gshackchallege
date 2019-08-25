package mx.aja.pyme.ordenes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import mx.aja.pyme.ordenes.dto.DtoOrden;

public interface OrdenRepo extends MongoRepository<DtoOrden, String> {
	
	Page<DtoOrden> findByUserId(String userId, Pageable pageable);

}
