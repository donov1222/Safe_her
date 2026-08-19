/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JOptionPane;
/**
 *
 * @author Mathe
 */
public class Administrador {
    
     private int idAdministrador;
    private String nombre;
    private String usuario;
    private String contrasenha;

    public Administrador(int idAdministrador, String nombre, String usuario, String contrasenha) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contrasenha;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    
    public int agregarCancha(Cancha[] listaCanchas, int cantidadActual, Cancha nuevaCancha) {
        if (cantidadActual < listaCanchas.length) {
            listaCanchas[cantidadActual] = nuevaCancha;
            JOptionPane.showMessageDialog(null, "Cancha agregada correctamente: " + nuevaCancha.getNombre());
            return cantidadActual + 1;} 
        else {
            JOptionPane.showMessageDialog(null, "No hay espacio para agregar mas canchas.");
            return cantidadActual;}
      }
     
    public int eliminarCancha(Cancha[] listaCanchas, int cantidadActual, int idCancha) {
        int i = 0;
        int posicion = -1;

        while (i < cantidadActual) {
            if (listaCanchas[i].getIdCancha() == idCancha) {posicion = i;}
            i = i + 1;
        }

        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "No se encontro una cancha con ese ID.");
            return cantidadActual;}
        else {
            int j = posicion;
            while (j < cantidadActual - 1) {
                listaCanchas[j] = listaCanchas[j + 1];
                j = j + 1;
            }
            JOptionPane.showMessageDialog(null, "Cancha eliminada correctamente.");
            return cantidadActual - 1;
        }
       }
}

