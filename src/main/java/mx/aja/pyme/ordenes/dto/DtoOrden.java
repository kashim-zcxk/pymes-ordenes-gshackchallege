package mx.aja.pyme.ordenes.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "ordenes")
public class DtoOrden {

	@Id
	private String ordenId;
	@JsonIgnore
	private String userId;
	private EnumOrdenEstatus estado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
	private Date fechCreado;
	private Double total;
	private List<DtoOrdenProducto> historial;

	public String getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(String ordenId) {
		this.ordenId = ordenId;
	}

	public EnumOrdenEstatus getEstado() {
		return estado;
	}

	public void setEstado(EnumOrdenEstatus estado) {
		this.estado = estado;
	}

	public Date getFechCreado() {
		return fechCreado;
	}

	public void setFechCreado(Date fechCreado) {
		this.fechCreado = fechCreado;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<DtoOrdenProducto> getHistorial() {
		return historial;
	}

	public void setHistorial(List<DtoOrdenProducto> historial) {
		this.historial = historial;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
