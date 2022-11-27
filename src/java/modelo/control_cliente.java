package modelo;

import com.mysql.cj.protocol.Resultset;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Luis Fernando Paxel
 */
public class control_cliente {
    
    private int idControlCliente, idCliente, idtraer;
    private String fechaControl;
    private String dpi, email;
    
    public control_cliente() {
        
    }
    
    public control_cliente(int idControlCliente, int idCliente, String fechaControl) {
        this.idControlCliente = idControlCliente;
        this.idCliente = idCliente;
        this.fechaControl = fechaControl;
    }
    
    Conexion cn;
    
    public int getIdControlCliente() {
        return idControlCliente;
    }
    
    public void setIdControlCliente(int idControlCliente) {
        this.idControlCliente = idControlCliente;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getFechaControl() {
        return fechaControl;
    }
    
    public void setFechaControl(String fechaControl) {
        this.fechaControl = fechaControl;
    }
    
    public String getDpi() {
        return dpi;
    }
    
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getIdtraer() {
        return idtraer;
    }
    
    public void setIdtraer(int idtraer) {
        this.idtraer = idtraer;
    }
    
    public control_cliente validar(String dpi, String email) {
        control_cliente control = new control_cliente();
        String query = "select * from clientes where NoDPI= ? and Correo_electronico = ?;";
        try {
            cn = new Conexion();
            cn.openConexion();
            PreparedStatement parametro;
            parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
            parametro.setString(1, dpi);
            parametro.setString(2, email);
            ResultSet watch = parametro.executeQuery();
            int tr = 0;
            while (watch.next()) {
                control.setDpi(watch.getString("NoDPI"));
                control.setEmail(watch.getString("Correo_electronico"));
                tr = watch.getInt("id_Cliente");
            }
            this.setIdtraer(tr);
            cn.closedConexion();
        } catch (SQLException ex) {
            System.out.println("Error val control cliente " + ex);
        }
        return control;
    }
    
    public int insertarControlCliente() {
        int retorno;
        {
            try {
                String fechaH = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                
                cn = new Conexion();
                cn.openConexion();
                PreparedStatement parametro;
                String query = "insert into control_clientes(IdCliente, FechaH_control)values(?,?);";
                
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);
                parametro.setInt(1, this.getIdCliente());
                parametro.setString(2, fechaH);
                retorno = parametro.executeUpdate();
                cn.closedConexion();
                
            } catch (SQLException ex) {
                
                System.out.println("Error al insertar control cliente " + ex);
                retorno = 0;
                
            }
            return retorno;
            
        }
        
    }
    
}
