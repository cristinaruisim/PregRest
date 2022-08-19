package com.afd.trivial.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class Fachada {

	private static Fachada instance;
	
	//M�todo para la implementaci�n del patr�n Singleton, para obtener la instancia
	//de la fachada
	public static Fachada getInstance() {
		if (instance == null) {
			instance = new FachadaImpl();
		}
		return instance;
	}
	
	//M�todo que devolver� un jugador si existe el alias o null si no existe
	public abstract Jugador iniciarSesion(String alias);
	
	//M�todo que registrar� un jugador en la aplicaci�n. Devolver� el jugador si
	//se ha podido registrar o null en caso contrario
	public abstract Jugador registrarJugador(String alias);
	
	//M�todo que crear� una partida a partir de los datos recibidos
	public abstract Partida crearPartida(String nombre, int maxJugadores, int numPreguntasPorCategoria, int[]categorias, Jugador jugador);

	//M�todo que devolver� verdadero o falso si un alias est� disponible para registrarse
	public abstract boolean comprobarAlias(String alias);

	//M�todo que devuelve la lista de jugadores
	public abstract List<Jugador> obtenerRanking();
	
	//M�todo que devuelve la lista de categorias
	public abstract List<Categoria> obtenerCategoria();

	public abstract Jugador corregirPartida(ArrayList<Integer> listaRespuestas, Partida partida, Jugador jugador) ;
	
}
