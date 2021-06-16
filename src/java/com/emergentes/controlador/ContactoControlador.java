
package com.emergentes.controlador;

import com.emergentes.ejb.ContactoFacadeLocal;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "ContactoControlador", urlPatterns = {"/ContactoControlador"})
public class ContactoControlador extends HttpServlet {
    @EJB
    private ContactoFacadeLocal contactoFacade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = (request.getParameter("action")!= null)? request.getParameter("action"):"view";
        Contacto c = new Contacto();
        Integer id;
        
        switch(action){
            case "add":
                c.setId(0);
                request.setAttribute("c", c);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                c = contactoFacade.find(id);
                request.setAttribute("c", c);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "delete":
                id= Integer.parseInt(request.getParameter("id"));
                c = contactoFacade.find(id);
                contactoFacade.remove(c);
                response.sendRedirect("ContactoControlador");
                break;
            case "view":
                List<Contacto> lista = new ArrayList<Contacto>();
                lista = contactoFacade.findAll();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                    
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        
        Contacto c =new Contacto();
        
        c.setId(id);
        c.setNombre(nombre);
        c.setCorreo(correo);
        c.setTelefono(telefono);
        
        if(c.getId()==0){
            contactoFacade.create(c);
        }else{
            contactoFacade.edit(c);
        }
        response.sendRedirect("ContactoControlador");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
