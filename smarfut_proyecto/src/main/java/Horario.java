public class Horario {
 private String fecha;
    private String horaInicio;
    private String horaFin;

    public Horario(String fecha, String horaInicio, String horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public boolean verificarDisponibilidad(String fechaSolicitada, String horaSolicitada) {
        if (fecha.equals(fechaSolicitada) && horaInicio.equals(horaSolicitada)) {
            System.out.println("El horario esta disponible.");
            return true;
        } else {
            System.out.println("El horario no esta disponible.");
            return false;
        }
    }

    public void mostrarHorario() {
        System.out.println("Fecha: " + fecha + " | Inicio: " + horaInicio + " | Fin: " + horaFin);
    }   
}
