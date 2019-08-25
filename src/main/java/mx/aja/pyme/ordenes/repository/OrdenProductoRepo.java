package mx.aja.pyme.ordenes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.aja.pyme.ordenes.dto.DtoOrdenProducto;

public interface OrdenProductoRepo extends MongoRepository<DtoOrdenProducto, String> {

}
