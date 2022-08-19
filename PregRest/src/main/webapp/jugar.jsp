<%@page import="java.util.HashMap"%>
<%@page import="com.afd.trivial.modelo.Partida"%>
<%@page import="com.afd.trivial.modelo.Respuesta"%>
<%@page import="com.afd.trivial.modelo.Pregunta"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Jugar</title>
	<link rel="stylesheet" type="text/css" href="estiloJuego.css">
	
</head>
	<body class="jugarPartida">
		<% HashMap<Integer, Partida> listaPartidas = (HashMap<Integer, Partida>)application.getAttribute("partidas"); %>
		<% int idPartida = Integer.parseInt(request.getParameter("idPartida")); %>
		<% Partida partida = listaPartidas.get(idPartida); %>
		<form action="RecogerRespuestas">
			<div class="pregresp">
			<% for (Pregunta p : partida.getListaPreguntas()) { %>
				<div class="pregunta"><%=p.getEnunciado() %></div>
				<div class="respuestas"> 
				<% for (Respuesta r: p.getListaRespuesta()) { %> 
					<input required type="radio" name="resp<%=p.getIdPregunta()%>" value="<%= r.getIdRespuesta()%>"/> <%= r.getTexto() %>
					<br/>
				<% } %>
			 	</div>
			 <%} %>
			 <input type="hidden" name="idPartida" value="<%=idPartida%>"/>
			<input type="submit" value="Enviar respuesta"> 
			</div>
		</form>
	

	</body>
</html>