/**
 * Clase que representa el pago asociado a una reserva.
 */
public class Pago {

    private int idPago;
    private double monto;
    private String metodoPago;
    private String estadoPago; // "Pendiente" o "Confirmado"
    private Reserva reserva;

    public Pago(int idPago, double monto, String metodoPago, Reserva reserva) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.reserva = reserva;
        this.estadoPago = "Pendiente";
    }

    public int getIdPago() {
        return idPago;
    }

    public double getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    // Procesa el pago (en este avance solo se marca como realizado)
    public boolean realizarPago() {
        this.estadoPago = "Realizado";
        return true;
    }

    public void confirmarPago() {
        this.estadoPago = "Confirmado";
        reserva.confirmarReserva();
    }

    public String toString() {
        return "Pago #" + idPago + " | Monto: c" + monto + " | Metodo: " + metodoPago
                + " | Estado: " + estadoPago + " | Reserva #" + reserva.getIdReserva();
    }
}
