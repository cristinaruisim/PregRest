package com.afd.trivial.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pregunta {
	
	@Id
	private int idPregunta;
	private String enunciado;
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pregunta")
	private List<Respuesta> listaRespuesta;
	
	public Pregunta(int idPregunta, String enunciado, Categoria categoria, List<Respuesta> listaRespuesta) {
		this.idPregunta = idPregunta;
		this.enunciado = enunciado;
		this.categoria = categoria;
		this.listaRespuesta = listaRespuesta;
	}
	
	public Pregunta() {}
	
	public Pregunta(int idPregunta, String enunciado, Categoria categoria) {
		this.idPregunta = idPregunta;
		this.enunciado = enunciado;
		this.categoria = categoria;
		this.listaRespuesta = new ArrayList<Respuesta>(); 
	}
	
	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Respuesta> getListaRespuesta() {
		return listaRespuesta;
	}

	public void setListaRespuesta(List<Respuesta> listaRespuesta) {
		this.listaRespuesta = listaRespuesta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pregunta [idPregunta=").append(idPregunta).append(", enunciado=").append(enunciado)
				.append(", categoria=").append(categoria).append(", listaRespuesta=").append(listaRespuesta)
				.append("]");
		return builder.toString();
	}

}
