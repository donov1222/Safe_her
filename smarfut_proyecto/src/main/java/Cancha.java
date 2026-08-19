import javax.swing.JOptionPane;

public class Cancha {
private int idCancha;
    private String nombre;
    private String tipo;
    private double precioHora;
    private boolean disponible;

    public Cancha(int idCancha, String nombre, String tipo, double precioHora, boolean disponible) {
        this.idCancha = idCancha;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.disponible = disponible;
    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "Cancha#" + idCancha + " - " + nombre +
                                      "\nTipo: " + tipo +
                                      "\nPrecio por hora: " + precioHora);

        if (disponible) {
           JOptionPane.showMessageDialog(null, "Estado: Disponible");
        } else {
            JOptionPane.showMessageDialog(null, "Estado: No disponible");
        }
    }

    public void cambiarEstado() {
        disponible = !disponible;
        JOptionPane.showMessageDialog(null, "El estado de la cancha " + nombre + " cambio.");
    }    
}
