/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mathe
 */
public class Reserva {
    
    private int idReserva;
    private String estado;
    private Usuario usuario;
    private Cancha cancha;
    private Horario horario;
   
    public Reserva(int idReserva, Usuario usuario, Cancha cancha, Horario horario){
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.cancha = cancha;
        this.horario = horario;
        this.estado = "Pendiente";
    }
 
    public int getIdReserva() {
        return idReserva;
    }
 
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getEstado() {
        return estado;
    }
 
    public void setEstado(String estado) {
        this.estado = estado;
    }
       
    public Usuario getUsuario() {
        return usuario;
    }
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     
    public Cancha getCancha() {
        return cancha;
    } 
    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }


    public void crearReserva() {
        estado = "Pendiente";
        System.out.println("Reserva #" + idReserva + " creada para " + usuario.getNombre()
                + " en " + cancha.getNombre() + ".");
  }

    public void cancelarReserva() {
        estado = "Cancelada";
        System.out.println("Reserva #" + idReserva + " cancelada.");
     }

    public void confirmarReserva() {
        estado = "Confirmada";
        System.out.println("Reserva #" + idReserva + " confirmada.");
    }}
    

