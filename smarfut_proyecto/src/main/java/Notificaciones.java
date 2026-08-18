
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mathe
 */
public class Notificaciones {
    private String mensaje;
    private String fecha;
    private String tipo;

    public Notificaciones(String mensaje, String fecha, String tipo){
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public void enviarNotificacion() {
        JOptionPane.showMessageDialog(null,"SMARTFUT NOTIFICATION:" + 
                "\n" + "(" + tipo + ") " + mensaje + 
                "\n" + "Fecha: " + fecha);
     }
    

}

