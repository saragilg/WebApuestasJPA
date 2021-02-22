package controller;

import entities.Apuestas;
import entities.Jornada;
import entities.Partido;
import entities.Porra;
import entities.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.JPAUtil;

/**
 * Servlet implementation class Controller
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;
                List<Jornada> jornadas = null;
                List<Partido> partidos = null;
                String log = "out";
                String dni ="";
                String nombre ="";
                Jornada jornada;
                
                EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
                EntityManager em = emf.createEntityManager();
                
		if (op.equals("inicio")) {                                         
                    Query q = em.createQuery("select j from Jornada j");
                        
                    jornadas = (List<Jornada>) q.getResultList();
 
                    session.setAttribute("jornadas", jornadas);
                    session.setAttribute("log", log);
                    session.setAttribute("dni", dni);
                    session.setAttribute("nombre", nombre);
			
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
		}else if (op.equals("registrar")){
                    dni = request.getParameter("dni");
                    nombre = request.getParameter("nombre");
                    
                    Usuario usuario = em.find(Usuario.class, dni);
                    
                    if(usuario==null){
                    //para persist / merge /remove
                    //_------AÑADIR USER
                        EntityTransaction transaccion = em.getTransaction();
                        transaccion.begin();
                        usuario = new Usuario(dni);
                        usuario.setNombre(nombre);
                        em.persist(usuario);
                        transaccion.commit();
                    }
                    session.setAttribute("usuario", usuario);
                    
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                    
                }else if (op.equals("salir")){
                    session.removeAttribute("usuario");
                    
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if (op.equals("traerjornadas")){
                    String i = request.getParameter("jornadaseleccionada");
                    if (i.equals("null")){
                        partidos=null;
                    }else{
                        jornadas = (List<Jornada>) session.getAttribute("jornadas");
                        jornada = jornadas.get(Integer.parseInt(i));
                        partidos = jornada.getPartidoList();
                    }
                    
                    request.setAttribute("partidos", partidos);
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }else if (op.equals("info")){
                    // LOCAL --- VISITANTE
                    String local = request.getParameter("local");
                    String visitante = request.getParameter("visitante");
                    request.setAttribute("local", local);
                    request.setAttribute("visitante", visitante);
                    // INFO APUESTAS
                    String idpartido = request.getParameter("idpartido");
                    String sql = "select p.goleslocal, p.golesvisitante, count(p) FROM Porra p where p.partido.idpartido="+idpartido+" group by p.goleslocal, p.golesvisitante";
                    Query q = em.createQuery(sql);
                    List<Object[]> resultList = q.getResultList();
                    List<Apuestas> apuestas = new ArrayList<>();
                    for (Object[] row : resultList) {
                        apuestas.add(new Apuestas((Short)row[0], (Short)row[1], (Long)row[2]));
                    }
                    
                    request.setAttribute("apuestas", apuestas);
                    dispatcher = request.getRequestDispatcher("info.jsp");
                    dispatcher.forward(request, response);
                }else if (op.equals("apostar")){
                    //del formulario
                    Short goleslocal = Short.parseShort(request.getParameter("goleslocal"));
                    Short golesvisitante = Short.parseShort(request.getParameter("golesvisitante"));
                    
                    //datos pasados en el boton
                    Short idpartido = Short.parseShort(request.getParameter("idpartido"));
                    dni = request.getParameter("dni");
                    
                    EntityTransaction transaccion = em.getTransaction();
                    transaccion.begin();
                    Porra porra = new Porra(dni, idpartido);
                    porra.setGoleslocal(goleslocal);
                    porra.setGolesvisitante(golesvisitante);
                    em.persist(porra);
                    transaccion.commit();
           
                    dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
