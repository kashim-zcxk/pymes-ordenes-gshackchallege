package mx.aja.pyme.ordenes.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordenes")
public class DtoOrdenProducto {

	@Id
	private String ordenProductoId;
	private Integer cantidad;
	private Double precioUnitario;
	private Double total;
	@DBRef
	private DtoProducto producto;

	public String getOrdenProductoId() {
		return ordenProductoId;
	}

	public void setOrdenProductoId(String ordenProductoId) {
		this.ordenProductoId = ordenProductoId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public DtoProducto getProducto() {
		return producto;
	}

	public void setProducto(DtoProducto producto) {
		this.producto = producto;
	}

}
