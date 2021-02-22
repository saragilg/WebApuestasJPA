package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entities.Usuario;
import entities.Partido;
import entities.Jornada;
import java.util.List;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>Partidos</title>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("        integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"\n");
      out.write("        integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\" crossorigin=\"anonymous\" />\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("\tfunction poncombo(combo, valor) {\n");
      out.write("\t\tfor (i = 0; i < combo.options.length; i++)\n");
      out.write("\t\t\tif (combo.options[i].value == valor)\n");
      out.write("\t\t\t\tcombo.options[i].selected = true;\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("     ");

                List<Jornada> jornadas = (List<Jornada>) session.getAttribute("jornadas");
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                
    
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col p-0\">\n");
      out.write("                <nav class=\"navbar navbar-expand-lg navbar-light bg-primary\">\n");
      out.write("                    <a href=\"home.html\"><img src=\"img/liga.png\" alt=\"logo\"/></a>\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\n");
      out.write("                        data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\"\n");
      out.write("                        aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <div class=\"collapse navbar-collapse justify-content-end\" id=\"navbarSupportedContent\">\n");
      out.write("                       ");
 if(usuario==null) {
      out.write("\n");
      out.write("                        <!--  SIN HABERSE REGISTRADO -->\n");
      out.write("                        <button class=\"btn my-2 my-sm-0 text-white bg-success\" data-toggle=\"modal\" data-target=\"#modalLogin\">Log In <i\n");
      out.write("                                    class=\"fas fa-user pl-2\"></i></button>\n");
      out.write("                        ");
 }else { 
      out.write("\n");
      out.write("                        <!--  REGISTRADO -->\n");
      out.write("                        <h4 class=\"text-white mr-3\">Welcome, ");
      out.print( usuario.getNombre() );
      out.write("</h4>\n");
      out.write("                        <a href=\"Controller?op=salir\" class=\"btn my-2 my-sm-0 text-white bg-danger\" type=\"submit\">Log Out <i class=\"fas fa-user pl-2\"></i></a>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row pt-3 justify-content-center\">\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <form action=\"Controller?op=traerjornadas\" method=\"POST\" name=\"fjornadas\">\n");
      out.write("                    <select name=\"jornadaseleccionada\" class=\"form-select\" onchange=\"this.form.submit()\">\n");
      out.write("                    <option selected value=\"null\">Elija jornada</option>\n");
      out.write("                    ");
 for(int i=0;i<jornadas.size();i++){ 
      out.write("\n");
      out.write("                    <option value=\"");
      out.print( i );
      out.write('"');
      out.write('>');
      out.print( jornadas.get(i).getNombre() );
      out.write(' ');
      out.write('(');
      out.print( jornadas.get(i).getFechainicio() );
      out.write(" - ");
      out.print( jornadas.get(i).getFechafin() );
      out.write(")</option>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                  </select> \n");
      out.write("\t\t</form>\n");
      out.write("\t\t<script type=\"text/javascript\"> poncombo(document.fjornadas.jornadaseleccionada,\"");
      out.print(request.getParameter("jornadaseleccionada"));
      out.write("\");</script>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");

        List<Partido> partidos = (List<Partido>) request.getAttribute("partidos");
        
        if(partidos==null){

      out.write("   \n");
      out.write("        <!-- SIN JORNADA SELECCIONADA-->\n");
      out.write("        <div class=\"row pt-4\">\n");
      out.write("            <div class=\"col-md-8 offset-md-2 \">\n");
      out.write("                <img src=\"img/bg.jpg\" alt=\"fondo\" class=\"img-fluid\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("        <!-- CON JORNADA--> \n");
      out.write("        <div class=\"row pt-4 text-center\">\n");
      out.write("            ");
 for(Partido partido:partidos) { 
      out.write("\n");
      out.write("            <div class=\"col-md-1\">\n");
      out.write("                ");
 if (usuario!=null){ 
      out.write("\n");
      out.write("                <!--         ESTANDO REGISTRADO        -->\n");
      out.write("                <button class=\"pr-2 btn my-2 my-sm-0 bg-success text-white\" data-toggle=\"modal\" data-target=\"#modalInfo\" data-idpartido=\"");
      out.print( partido.getIdpartido() );
      out.write("\" data-local=\"");
      out.print( partido.getLocal().getNombre());
      out.write("\" data-visitante=\"");
      out.print( partido.getVisitante().getNombre());
      out.write("\"><i class=\"fas fa-info-circle\"></i></button> \n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <!-- IMG DE EQUIPO-->\n");
      out.write("                <img src=\"http://lfpdata.static.interactivecdn.com.s3.amazonaws.com/images/shields/");
      out.print( partido.getLocal().getNombre());
      out.write(".png\" width=\"100px\" height=\"100px\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <h4>");
      out.print( partido.getLocal().getNombre().toUpperCase() );
      out.write("</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <p>");
      out.print( partido.getGoleslocal() );
      out.write(" - ");
      out.print( partido.getGolesvisitante() );
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <h4>");
      out.print( partido.getVisitante().getNombre().toUpperCase() );
      out.write("</h4>\n");
      out.write("                <!-- IMG DE EQUIPO-->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <img src=\"http://lfpdata.static.interactivecdn.com.s3.amazonaws.com/images/shields/");
      out.print( partido.getVisitante().getNombre());
      out.write(".png\" width=\"100px\" height=\"100px\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-1\">\n");
      out.write("                ");
 if (usuario!=null){ 
      out.write("\n");
      out.write("                <!--         ESTANDO REGISTRADO        -->\n");
      out.write("                <button class=\"pl-2 btn my-2 my-sm-0 bg-success text-white\" data-toggle=\"modal\" data-target=\"#modalApostar\" data-dni=\"");
      out.print( usuario.getDni() );
      out.write("\" data-idpartido=\"");
      out.print( partido.getIdpartido() );
      out.write("\" data-local=\"");
      out.print( partido.getLocal().getNombre().toUpperCase() );
      out.write("\" data-visitante=\"");
      out.print( partido.getVisitante().getNombre().toUpperCase() );
      out.write("\">APOSTAR</button>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- MODAL DE LOGIN -->\n");
      out.write("<div class=\"modal fade\" id=\"modalLogin\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Login & Register</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("        <form action=\"Controller?op=registrar\" method=\"POST\" name=\"formregistro\">\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("              <input type=\"text\" class=\"form-control\" placeholder=\"DNI\" name=\"dni\">\n");
      out.write("              <input type=\"text\" class=\"form-control\" placeholder=\"Nombre\" name=\"nombre\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-footer\">\n");
      out.write("              <button type=\"submit\" class=\"btn btn-success text-white\"><i class=\"fas fa-user pr-2\"></i>LOGIN & REGISTER</button>\n");
      out.write("              <button type=\"button\" class=\"btn\" data-dismiss=\"modal\"><i class=\"fas fa-times-circle pr-2\" ></i>CANCELAR</button>\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        <!-- MODAL DE INFO-->\n");
      out.write("<div class=\"modal fade\" id=\"modalInfo\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Información apuestas actuales</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("           \n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("            <button type=\"button\" class=\"btn\" data-dismiss=\"modal\"><i class=\"fas fa-times-circle pr-2\" ></i>Aceptar</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("        \n");
      out.write("         <!-- MODAL DE APOSTAR-->\n");
      out.write("<div class=\"modal fade\" id=\"modalApostar\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">APUESTA</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("        <h4 class=\"text-center\"></h4>\n");
      out.write("      <form action=\"\" method=\"POST\" name=\"formapostar\">\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-6\">\n");
      out.write("                  <input type=\"text\" class=\"form-control \" placeholder=\"Goles local\" name=\"goleslocal\">\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-md-6\">\n");
      out.write("              <input type=\"text\" class=\"form-control float-right\" placeholder=\"Goles visitante\" name=\"golesvisitante\">\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-footer\">\n");
      out.write("              <button type=\"submit\" class=\"btn btn-success text-white\"><i class=\"fas fa-user pr-2\"></i>APOSTAR</button>\n");
      out.write("              <button type=\"button\" class=\"btn\" data-dismiss=\"modal\"><i class=\"fas fa-times-circle pr-2\" ></i>CANCELAR</button>\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("         \n");
      out.write("    <div id=\"tostadaApuesta\" data-delay=\"2000\" class=\"toast mx-auto mt-5 bg-primary\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">\n");
      out.write("       <div class=\"toast-header\">\n");
      out.write("           <strong class=\"mr-auto\">Apuesta realizada.</strong>\n");
      out.write("       </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Optional JavaScript -->\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("     <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("        integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("        integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"js/myjs.js\"></script>\n");
      out.write("   \n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
