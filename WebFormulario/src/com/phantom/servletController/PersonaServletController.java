package com.phantom.servletController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.phantom.entity.Persona;
import com.phantom.model.PersonaDaoMemory;



/**
 * Servlet implementation class servlet2D
 */
@WebServlet("/servlet2D")
public class PersonaServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonaDaoMemory personaDAO = new PersonaDaoMemory();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		        
        String action = request.getParameter("action");
        System.out.println(action);
        
        System.out.println(request+" xD "+response);
        
        
        try {
        	 switch (action){
        	 
        	 case "index"   : index(request,response);
        	 break;
        	 
        	 case "nuevo"   : nuevo(request,response);  
        	 break;        	
        	 
        	 case "register": registrar(request,response);
        	 break;
        	 
        	 case "mostrar" : mostrar(request,response);
        	 break;
        	 
        	 case "showeditar"	:showeditar(request,response);
        	 break;
        	         	 
        	 case "showeliminar": showeliminar(request,response);
        	 break;
        	 
        	 case "editar" : editar(request,response);
        	 break;
         	
         	 default: break;
         	
             }
             
        	
        }catch (Exception e) {
        	System.out.println("switch");
			System.out.println(e);
		}
        
       
	
		
	}

	
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				   			
		doGet(request, response);
					
	}
	
	
	
	private void index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/add.jsp");
		dispatcher.forward(request, response);	
	}
	
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		
		out.println("<html>");		
		out.println("<body style=\"text-align: center;\">");
		out.println("<table id=\"tableURL\">");
		out.println("<tr>");
		out.println("<td><a href=\"servlet2D?action=index\">Ir al menú</a></td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("<table id=\"tableData\"  border=\"1\">");
		out.println("<tr>");
		out.println("<td>Id</td>");
		out.println("<td>Nombres</td>");
		out.println("<td>Apellidos</td>");
		out.println("<td>Dirección</td>");
		out.println("<td>País</td>");
		out.println("<td colspan=\"2\">Opciones</td>");
		out.println("</tr>");
		
		
		for(Persona per : personaDAO.readAll()) {
			
			out.println("<tr>");
			out.println("<td>"+per.getId()+"</td>");
			out.println("<td>"+per.getNombres()+"</td>");
			out.println("<td>"+per.getApellidos()+"</td>");
			out.println("<td>"+per.getDireccion()+"</td>");
			out.println("<td>"+per.getPaises()+"</td>");
			out.println("<td><a href=\"servlet2D?action=showeditar&id="+per.getId()+"\">Editar</a></td>");
			out.println("<td><a href=\"servlet2D?action=showeliminar&id="+per.getId()+"\">Eliminar</a></td>");
			out.println("</tr>");						
		}	
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");	
								
	}

	
	
	
	private void showeditar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				
		Persona opersona = personaDAO.findFordId(Integer.parseInt(request.getParameter("id")));
				
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Editar Datos</h1>");
		out.println("<form  action=\"servlet2D?action=editar\" method=\"post\">");		
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>id : </td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"id_persona\" value=\""+opersona.getId()+"\" readonly />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Nombres : </td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"nombrePerson\" value=\""+opersona.getNombres()+"\" />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Apellidos : </td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"apellidoPerson\" value=\""+opersona.getApellidos()+"\" />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Dirección : </td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"direccionPerson\" value=\""+opersona.getDireccion()+"\" />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>País : </td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"paisPerson\" value=\""+opersona.getPaises()+"\" />");
		out.println("</td>");
		out.println("</tr>");		
		out.println("</table>");		
		out.println("<input type=\"submit\" name=\"actualizar\" value=\"Actualizar\"/>");		
		out.println("</form>");
		out.println("</body>");		
		out.println("</html>");
				
	}

	
	
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
		Persona opersona = new Persona();
		opersona.setNombres(request.getParameter("nombres"));
		opersona.setApellidos(request.getParameter("apellidos"));
		opersona.setDireccion(request.getParameter("direccion"));
		opersona.setPaises(request.getParameter("paises"));
			
		personaDAO.create(opersona);
		
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<html>");		
		out.println("<head align=\"center\">");
		out.println("<meta http-equiv=\"Refresh\" content=\"2;url=index.jsp\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">Registro Agregado</h1>");
		out.println("<div align=\"center\">En 2 segundos sera redireccionado a la pagina principal</div>");
		out.println("</body>");
		out.println("</html>");
		
	//	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	//	dispatcher.forward(request, response);			
	}
	
	
	
	
	private void editar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Persona opersona = new Persona();
		
		opersona.setId(Integer.parseInt(request.getParameter("id_persona")));
		opersona.setNombres(request.getParameter("nombrePerson"));
		opersona.setApellidos(request.getParameter("apellidoPerson"));
		opersona.setDireccion(request.getParameter("direccionPerson"));
		opersona.setPaises(request.getParameter("paisPerson"));
		
		personaDAO.update(opersona);
		
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<html>");		
		out.println("<head align=\"center\">");
		out.println("<meta http-equiv=\"Refresh\" content=\"2;url=index.jsp\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">Registro Actualizado</h1>");
		out.println("<div align=\"center\">En 2 segundos sera redireccionado a la pagina principal</div>");
		out.println("</body>");
		out.println("</html>");		
		
	}
		
	
	private void showeliminar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
		
		Persona opersona = personaDAO.findFordId(Integer.parseInt(request.getParameter("id")));
						
		personaDAO.delete(opersona);
			
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<html>");		
		out.println("<head align=\"center\">");
		out.println("<meta http-equiv=\"Refresh\" content=\"2;url=index.jsp\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">Registro Eliminado</h1>");
		out.println("<div align=\"center\">En 2 segundos sera redireccionado a la pagina principal</div>");
		out.println("</body>");
		out.println("</html>");		
		
		
		
	}
	
	
	

}
