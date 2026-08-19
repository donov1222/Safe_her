import javax.swing.JOptionPane;

public class Usuario {
   private int idUsuario;
    private String nombre;
    private String telefono;
    private String correo;

    public Usuario(int idUsuario, String nombre, String telefono, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void registrarse() {
       JOptionPane.showMessageDialog(null, "Usuario registrado: " + nombre);
    }

    public boolean iniciarSesion(String correoIngresado) {
        if (correo.equals(correoIngresado)) {
            JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Correo incorrecto.");
            return false;
        }
    }

    public void actualizarDatos(String nuevoTelefono, String nuevoCorreo) {
        telefono = nuevoTelefono;
        correo = nuevoCorreo;
        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
    } 
}
