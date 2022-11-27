package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Clientes;
import org.json.simple.JSONObject;

/**
 *
 * @author Luis Fernando Paxel
 */
public class srv_control_cliente extends HttpServlet {

    Clientes clientes = new Clientes();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String operacion = request.getParameter("accion");
            switch (operacion) {
                case "datos_cliente":
                    datos_cliente(request, response);
                    break;
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void datos_cliente(HttpServletRequest request, HttpServletResponse response) {
        
        try (PrintWriter out = response.getWriter()) {
            String idCliente = request.getParameter("idCliente");
            Clientes clientes = new Clientes();
            clientes = clientes.DatosCliente(Integer.valueOf(idCliente));
            JSONObject json = new JSONObject();
            json.put("id_cliente", clientes.getIdRegistro());
            json.put("nombres_c", clientes.getNombres());
            json.put("apellidos_c", clientes.getApellidos());
            json.put("correo_c", clientes.getCorreo());
            json.put("fn_cliente", clientes.getFecha_nacimiento());
            json.put("cui_c", clientes.getDpi());
            json.put("genero_c", clientes.getGenero());
            json.put("telefonon_c", clientes.getTelefono());
            json.put("edad_c", clientes.getEdad());
            json.put("estatura_c", clientes.getEstatura());
            json.put("mombres_emergencia", clientes.getNombreE());
            json.put("apellidos_emergencia", clientes.getApellidoE());
            json.put("telefono_emergencia", clientes.getTelefonoE());
            out.print(json);
            
        } catch (IOException ex) {
            Logger.getLogger(srv_control_cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
