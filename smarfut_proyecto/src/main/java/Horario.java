import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "El horario esta disponible.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El horario no esta disponible.");
            return false;
        }
    }

    public void mostrarHorario() {
        JOptionPane.showMessageDialog(null, "Fecha: " + fecha + " | Inicio: " + horaInicio + " | Fin: " + horaFin);
    }   
}
