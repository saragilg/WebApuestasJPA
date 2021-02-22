<%-- 
    Document   : home
    Created on : 08-feb-2021, 21:49:26
    Author     : Sara
--%>

<%@page import="entities.Usuario"%>
<%@page import="entities.Partido"%>
<%@page import="entities.Jornada"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Partidos</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    
</head>

<script language="javascript" type="text/javascript">
	function poncombo(combo, valor) {
		for (i = 0; i < combo.options.length; i++)
			if (combo.options[i].value == valor)
				combo.options[i].selected = true;
	}
</script>

<body>
    
     <%
                List<Jornada> jornadas = (List<Jornada>) session.getAttribute("jornadas");
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                String msg = (String)session.getAttribute("msg");
    %>
    
    <div class="container">
        <div class="row">
            <div class="col p-0">
                <nav class="navbar navbar-expand-lg navbar-light bg-primary">
                    <a href="home.html"><img src="img/liga.png" alt="logo"/></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                       <% if(usuario==null) {%>
                        <!--  SIN HABERSE REGISTRADO -->
                        <button class="btn my-2 my-sm-0 text-white bg-success" data-toggle="modal" data-target="#modalLogin">Log In <i
                                    class="fas fa-user pl-2"></i></button>
                        <% }else { %>
                        <!--  REGISTRADO -->
                        <h4 class="text-white mr-3">Welcome, <%= usuario.getNombre() %></h4>
                        <a href="Controller?op=salir" class="btn my-2 my-sm-0 text-white bg-danger" type="submit">Log Out <i class="fas fa-user pl-2"></i></a>
                        <% } %>
                    </div>
                </nav>
            </div>
        </div>
        <div class="row pt-3 justify-content-center">
            <div class="col-md-4">
                <form action="Controller?op=traerjornadas" method="POST" name="fjornadas">
                    <select name="jornadaseleccionada" class="form-select" onchange="this.form.submit()">
                    <option selected value="null">Elija jornada</option>
                    <% for(int i=0;i<jornadas.size();i++){ %>
                    <option value="<%= i %>"><%= jornadas.get(i).getNombre() %> (<%= jornadas.get(i).getFechainicio() %> - <%= jornadas.get(i).getFechafin() %>)</option>
                    <% }%>
                  </select> 
		</form>
		<script type="text/javascript"> poncombo(document.fjornadas.jornadaseleccionada,"<%=request.getParameter("jornadaseleccionada")%>");</script>
            </div>
        </div>
<%
        List<Partido> partidos = (List<Partido>) request.getAttribute("partidos");
        
        if(partidos==null){
%>   
        <!-- SIN JORNADA SELECCIONADA-->
        <div class="row pt-4">
            <div class="col-md-8 offset-md-2 ">
                <img src="img/bg.jpg" alt="fondo" class="img-fluid"/>
            </div>
        </div>
        <% } else { %>
        <!-- CON JORNADA--> 
        <div class="row pt-4 text-center">
            <% for(Partido partido:partidos) { %>
            <div class="col-md-1">
                <% if (usuario!=null){ %>
                <!--         ESTANDO REGISTRADO        -->
                <button class="pr-2 btn my-2 my-sm-0 bg-success text-white" data-toggle="modal" data-target="#modalInfo" data-idpartido="<%= partido.getIdpartido() %>" data-local="<%= partido.getLocal().getNombre()%>" data-visitante="<%= partido.getVisitante().getNombre()%>"><i class="fas fa-info-circle"></i></button> 
                <% } %>
            </div>
            <div class="col-md-2">
                <!-- IMG DE EQUIPO-->
                <img src="http://lfpdata.static.interactivecdn.com.s3.amazonaws.com/images/shields/<%= partido.getLocal().getNombre()%>.png" width="100px" height="100px"/>
            </div>
            <div class="col-md-2">
                <h4><%= partido.getLocal().getNombre().toUpperCase() %></h4>
            </div>
            <div class="col-md-2">
                <p><%= partido.getGoleslocal() %> - <%= partido.getGolesvisitante() %></p>
            </div>
            <div class="col-md-2">
                <h4><%= partido.getVisitante().getNombre().toUpperCase() %></h4>
                <!-- IMG DE EQUIPO-->
            </div>
            <div class="col-md-2">
                <img src="http://lfpdata.static.interactivecdn.com.s3.amazonaws.com/images/shields/<%= partido.getVisitante().getNombre()%>.png" width="100px" height="100px"/>
            </div>
            <div class="col-md-1">
                <% if (usuario!=null){ %>
                <!--         ESTANDO REGISTRADO        -->
                <button class="pl-2 btn my-2 my-sm-0 bg-success text-white" data-toggle="modal" data-target="#modalApostar" data-dni="<%= usuario.getDni() %>" data-idpartido="<%= partido.getIdpartido() %>" data-local="<%= partido.getLocal().getNombre().toUpperCase() %>" data-visitante="<%= partido.getVisitante().getNombre().toUpperCase() %>">APOSTAR</button>
                <% } %>
            </div>
            <% } %>
        </div>
        <% } %>
    </div>


    <!-- MODAL DE LOGIN -->
<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Login & Register</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <form action="Controller?op=registrar" method="POST" name="formregistro">
        <div class="modal-body">
              <input type="text" class="form-control" placeholder="DNI" name="dni">
              <input type="text" class="form-control" placeholder="Nombre" name="nombre">
        </div>
        <div class="modal-footer">
              <button type="submit" class="btn btn-success text-white"><i class="fas fa-user pr-2"></i>LOGIN & REGISTER</button>
              <button type="button" class="btn" data-dismiss="modal"><i class="fas fa-times-circle pr-2" ></i>CANCELAR</button>
        </div>
      </form>
    </div>
  </div>
</div>

        <!-- MODAL DE INFO-->
<div class="modal fade" id="modalInfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Información apuestas actuales</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
           
      </div>
      <div class="modal-footer">
            <button type="button" class="btn" data-dismiss="modal"><i class="fas fa-times-circle pr-2" ></i>Aceptar</button>
      </div>
    </div>
  </div>
</div>
        
         <!-- MODAL DE APOSTAR-->
<div class="modal fade" id="modalApostar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">APUESTA</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        <h4 class="text-center"></h4>
      <form action="" method="POST" name="formapostar">
        <div class="modal-body">
            <div class="row">
              <div class="col-md-6">
                  <input type="text" class="form-control " placeholder="Goles local" name="goleslocal">
              </div>
              <div class="col-md-6">
              <input type="text" class="form-control float-right" placeholder="Goles visitante" name="golesvisitante">
              </div>
            </div>
        </div>
        <div class="modal-footer">
              <button type="submit" class="btn btn-success text-white"><i class="fas fa-user pr-2"></i>APOSTAR</button>
              <button type="button" class="btn" data-dismiss="modal"><i class="fas fa-times-circle pr-2" ></i>CANCELAR</button>
        </div>
      </form>
    </div>
  </div>
</div>
<div id="tostadaMsg" data-delay="4000" class="toast mx-auto mt-5 bg-primary" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="toast-header">
        <%if (msg!=null) {%>
            <strong class="mr-auto"><%=msg%></strong>
        <%}%>
    </div>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
     <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="js/myjs.js"></script>
    
    <%if (msg!=null) {%>
        <script>
            $('#tostadaMsg').toast('show')
        </script>
        <%
        session.removeAttribute("msg");
    }%>
   
</body>

</html>
