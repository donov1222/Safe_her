/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mathe
 */
public class Administrador {
    
     private int idAdministrador;
    private String nombre;
    private String usuario;
    private String contraseña;

    public Administrador(int idAdministrador, String nombre, String usuario, String contraseña) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public int agregarCancha(Cancha[] listaCanchas, int cantidadActual, Cancha nuevaCancha) {
        if (cantidadActual < listaCanchas.length) {
            listaCanchas[cantidadActual] = nuevaCancha;
            System.out.println("Cancha agregada correctamente: " + nuevaCancha.getNombre());
            return cantidadActual + 1;} 
        else {
            System.out.println("No hay espacio para agregar mas canchas.");
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
            System.out.println("No se encontro una cancha con ese ID.");
            return cantidadActual;}
        else {
            int j = posicion;
            while (j < cantidadActual - 1) {
                listaCanchas[j] = listaCanchas[j + 1];
                j = j + 1;
            }
            System.out.println("Cancha eliminada correctamente.");
            return cantidadActual - 1;
        }
       }
}

