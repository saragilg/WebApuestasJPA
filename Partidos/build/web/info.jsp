<%-- 
    Document   : info
    Created on : 13-feb-2021, 17:41:37
    Author     : Sara
--%>

<%@page import="entities.Apuestas"%>
<%@page import="java.util.List"%>
<%@page import="entities.Porra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String local = (String) request.getAttribute("local");
    String visitante = (String) request.getAttribute("visitante");
    List<Apuestas> apuestas = (List<Apuestas>) request.getAttribute("apuestas");
%>
<h4 class="text-center"><%= local.toUpperCase() %> - <%= visitante.toUpperCase() %></h4>
<% if(apuestas.size() == 0){ %>
    <h3 class="text-danger text-center">Este partido no tiene apuestas, ¡apuesta ya!</h3>

<% } else{ %>
    <table class="table text-center">
      <thead>
          <tr class="bg-primary text-white">
          <th scope="col">Local</th>
          <th scope="col">Visitante</th>
          <th scope="col">Nº apuestas</th>
        </tr>
      </thead>
      <tbody>
        <% for (Apuestas apuesta : apuestas) {
        %>  
        <tr>
          <td><%= apuesta.getGlocal() %></td>
          <td><%= apuesta.getGvisitante() %></td>
          <td><%= apuesta.getCuantos() %></td>
        </tr>
        <% } %>
      </tbody>
    </table>
<% } %>



   
