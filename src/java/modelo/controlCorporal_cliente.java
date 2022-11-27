package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Luis Fernando Paxel
 */
public class controlCorporal_cliente {

    private int idControlCliente;

    public controlCorporal_cliente() {
    }
    private String pectoral, dorsal, biceps, antebrazos, cintura, cadera, muslo, pantorrilla, peso, grasaCorporal, aguaP, masaMuscular, valorFisico, metabolismoB, edadM, MasaOs, grasaV, observacion;

    public controlCorporal_cliente(int idControlCliente, String pectoral, String dorsal, String biceps, String antebrazos, String cintura, String cadera, String muslo, String pantorrilla, String peso, String grasaCorporal, String aguaP, String masaMuscular, String valorFisico, String metabolismoB, String edadM, String MasaOs, String grasaV, String observacion) {
        this.idControlCliente = idControlCliente;
        this.pectoral = pectoral;
        this.dorsal = dorsal;
        this.biceps = biceps;
        this.antebrazos = antebrazos;
        this.cintura = cintura;
        this.cadera = cadera;
        this.muslo = muslo;
        this.pantorrilla = pantorrilla;
        this.peso = peso;
        this.grasaCorporal = grasaCorporal;
        this.aguaP = aguaP;
        this.masaMuscular = masaMuscular;
        this.valorFisico = valorFisico;
        this.metabolismoB = metabolismoB;
        this.edadM = edadM;
        this.MasaOs = MasaOs;
        this.grasaV = grasaV;
        this.observacion = observacion;
    }

    Conexion cn;

    public int getIdControlCliente() {
        return idControlCliente;
    }

    public void setIdControlCliente(int idControlCliente) {
        this.idControlCliente = idControlCliente;
    }

    public String getPectoral() {
        return pectoral;
    }

    public void setPectoral(String pectoral) {
        this.pectoral = pectoral;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public String getBiceps() {
        return biceps;
    }

    public void setBiceps(String biceps) {
        this.biceps = biceps;
    }

    public String getAntebrazos() {
        return antebrazos;
    }

    public void setAntebrazos(String antebrazos) {
        this.antebrazos = antebrazos;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getCadera() {
        return cadera;
    }

    public void setCadera(String cadera) {
        this.cadera = cadera;
    }

    public String getMuslo() {
        return muslo;
    }

    public void setMuslo(String muslo) {
        this.muslo = muslo;
    }

    public String getPantorrilla() {
        return pantorrilla;
    }

    public void setPantorrilla(String pantorrilla) {
        this.pantorrilla = pantorrilla;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGrasaCorporal() {
        return grasaCorporal;
    }

    public void setGrasaCorporal(String grasaCorporal) {
        this.grasaCorporal = grasaCorporal;
    }

    public String getAguaP() {
        return aguaP;
    }

    public void setAguaP(String aguaP) {
        this.aguaP = aguaP;
    }

    public String getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(String masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public String getValorFisico() {
        return valorFisico;
    }

    public void setValorFisico(String valorFisico) {
        this.valorFisico = valorFisico;
    }

    public String getMetabolismoB() {
        return metabolismoB;
    }

    public void setMetabolismoB(String metabolismoB) {
        this.metabolismoB = metabolismoB;
    }

    public String getEdadM() {
        return edadM;
    }

    public void setEdadM(String edadM) {
        this.edadM = edadM;
    }

    public String getMasaOs() {
        return MasaOs;
    }

    public void setMasaOs(String MasaOs) {
        this.MasaOs = MasaOs;
    }

    public String getGrasaV() {
        return grasaV;
    }

    public void setGrasaV(String grasaV) {
        this.grasaV = grasaV;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int insertarControl_Corporal() {
        int retorno;
        {
            try {
                cn = new Conexion();
                cn.openConexion();

                PreparedStatement parametro;

                String query = "insert into control_corporales(id_ControlC, Pectoral, Dorsal, Biceps, Antebrazos, Cintura, Cadera, Muslo, Pantorrila, Peso, GrasaCorporal,\n"
                        + " Porcentaje_Agua,Masa_muscular, Valor_fisico, Metabolismo_basal, Edad_metabolica, Masa_osea, Grasa_visceral, Observacion)\n"
                        + "values(?,?, ?, ?, ?, ?, ?,?,?,?, ?, ?,\n"
                        + "?, ?,?,?,?, ?, ?);";
                parametro = (PreparedStatement) cn.conexiondb.prepareStatement(query);

                parametro.setInt(1, this.getIdControlCliente());
                parametro.setString(2, this.getPectoral());
                parametro.setString(3, this.getDorsal());
                parametro.setString(4, this.getBiceps());
                parametro.setString(5, this.getAntebrazos());
                parametro.setString(6, this.getCintura());
                parametro.setString(7, this.getCadera());
                parametro.setString(8, this.getMuslo());
                parametro.setString(9, this.getPantorrilla());
                parametro.setString(10, this.getPeso());
                parametro.setString(11, this.getGrasaCorporal());
                parametro.setString(12, this.getAguaP());
                parametro.setString(13, this.getMasaMuscular());
                parametro.setString(14, this.getValorFisico());
                parametro.setString(15, this.getMetabolismoB());
                parametro.setString(16, this.getEdadM());
                parametro.setString(17, this.getMasaOs());
                parametro.setString(18, this.getGrasaV());
                parametro.setString(19, this.getObservacion());
                retorno = parametro.executeUpdate();

                cn.closedConexion();

            } catch (SQLException ex) {
                System.out.println("Error al insertar control corporal " + ex);
                retorno = 0;
            }
            return retorno;
        }

    }

}
