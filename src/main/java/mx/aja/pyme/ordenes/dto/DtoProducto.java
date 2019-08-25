package mx.aja.pyme.ordenes.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "productos")
public class DtoProducto {

	@Id
	private String productId;
	@JsonIgnore
	private String userId;
	private String nombre;
	private String sku;
	private String descripcion;
	@JsonIgnore
	private String precioDescuento;
	@JsonIgnore
	private Integer cantidad;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecioDescuento() {
		return precioDescuento;
	}

	public void setPrecioDescuento(String precioDescuento) {
		this.precioDescuento = precioDescuento;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
