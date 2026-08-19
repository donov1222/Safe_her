import javax.swing.JOptionPane;

public class Smartfut {

    private Usuario[] listaUsuarios;
    private int cantidadUsuarios;

    private Cancha[] listaCanchas;
    private int cantidadCanchas;

    private Reserva[] listaReservas;
    private int cantidadReservas;

    private Pago[] listaPagos;
    private int cantidadPagos;

    private Notificacion[] listaNotificaciones;
    private int cantidadNotificaciones;

    private Administrador admin;
    private Usuario usuarioActual;

    public Smartfut() {
        listaUsuarios = new Usuario[50];
        cantidadUsuarios = 0;

        listaCanchas = new Cancha[50];
        cantidadCanchas = 0;

        listaReservas = new Reserva[50];
        cantidadReservas = 0;

        listaPagos = new Pago[50];
        cantidadPagos = 0;

        listaNotificaciones = new Notificacion[100];
        cantidadNotificaciones = 0;

        usuarioActual = null;
    }

    public Cancha[] getListaCanchas() {
        return listaCanchas;
    }

    public int getCantidadCanchas() {
        return cantidadCanchas;
    }

    public void setCantidadCanchas(int cantidad) {
        this.cantidadCanchas = cantidad;
    }

    public Reserva[] getListaReservas() {
        return listaReservas;
    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public void iniciarSistema() {
        admin = new Administrador(1, "Administrador General", "admin", "admin123");

        listaCanchas[0] = new Cancha(1, "Cancha A", "Futbol 5", 15000, true);
        listaCanchas[1] = new Cancha(2, "Cancha B", "Futbol 7", 20000, true);
        listaCanchas[2] = new Cancha(3, "Cancha C", "Futbol 11", 30000, true);
        cantidadCanchas = 3;

        mostrarMenu();
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            String texto = "=== SMARTFUT - BIENVENIDO ===\n"
                    + "1. Usuario\n"
                    + "2. Consultar canchas\n"
                    + "3. Reservas\n"
                    + "4. Pagos\n"
                    + "5. Administrador\n"
                    + "6. Salir";

            String entrada = JOptionPane.showInputDialog(null, texto);

            if (entrada == null) {
                salir = true;
            } else {
                int opcion = leerEntero(entrada);

                if (opcion == 1) {
                    menuUsuario();
                } else if (opcion == 2) {
                    consultarCanchas();
                } else if (opcion == 3) {
                    menuReservas();
                } else if (opcion == 4) {
                    menuPagos();
                } else if (opcion == 5) {
                    menuAdministrador();
                } else if (opcion == 6) {
                    salir = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Gracias por usar Smartfut.");
    }

    private void menuUsuario() {
        String texto = "=== USUARIO ===\n"
                + "1. Iniciar Sesion\n"
                + "2. Registrarse\n"
                + "3. Salir";

        String entrada = JOptionPane.showInputDialog(null, texto);

        if (entrada != null) {
            int opcion = leerEntero(entrada);

            if (opcion == 1) {
                iniciarSesionUsuario();
            } else if (opcion == 2) {
                registrarUsuario();
            }
        }
    }

    private void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre completo:");
        String telefono = JOptionPane.showInputDialog(null, "Telefono:");
        String correo = JOptionPane.showInputDialog(null, "Correo electronico:");
        String contrasena = JOptionPane.showInputDialog(null, "Contrasena:");

        if (nombre != null && telefono != null && correo != null && contrasena != null) {
            if (cantidadUsuarios < listaUsuarios.length) {
                Usuario nuevo = new Usuario(cantidadUsuarios + 1, nombre, telefono, correo, contrasena);
                listaUsuarios[cantidadUsuarios] = nuevo;
                cantidadUsuarios = cantidadUsuarios + 1;
                usuarioActual = nuevo;

                JOptionPane.showMessageDialog(null, nuevo.registrarse());
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacio para mas usuarios.");
            }
        }
    }

    private void iniciarSesionUsuario() {
        String correo = JOptionPane.showInputDialog(null, "Correo:");
        String contrasena = JOptionPane.showInputDialog(null, "Contrasena:");

        if (correo != null && contrasena != null) {
            int i = 0;
            boolean encontrado = false;

            while (i < cantidadUsuarios && !encontrado) {
                if (listaUsuarios[i].iniciarSesion(correo, contrasena)) {
                    usuarioActual = listaUsuarios[i];
                    encontrado = true;

                    JOptionPane.showMessageDialog(null,
                            "Bienvenido, " + usuarioActual.getNombre());
                }

                i = i + 1;
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null,
                        "Correo o contrasena incorrectos.");
            }
        }
    }

    private void consultarCanchas() {
        String texto = "";
        int i = 0;

        while (i < cantidadCanchas) {
            texto = texto + listaCanchas[i].mostrarInformacion() + "\n";
            i = i + 1;
        }

        if (texto.equals("")) {
            texto = "No hay canchas registradas.";
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    private void menuReservas() {
        if (usuarioActual == null) {
            JOptionPane.showMessageDialog(null,
                    "Debe iniciar sesion primero (Menu Usuario).");
        } else {
            String texto = "=== RESERVAR CANCHA ===\nCanchas disponibles:\n";
            int i = 0;

            while (i < cantidadCanchas) {
                texto = texto
                        + listaCanchas[i].getIdCancha()
                        + ". "
                        + listaCanchas[i].getNombre()
                        + " - "
                        + listaCanchas[i].getTipo()
                        + "\n";

                i = i + 1;
            }

            texto = texto
                    + "\nDigite el ID de la cancha que desea reservar:";

            String entradaId = JOptionPane.showInputDialog(null, texto);

            if (entradaId != null) {
                int idCancha = leerEntero(entradaId);
                Cancha canchaSeleccionada = buscarCanchaPorId(idCancha);

                if (canchaSeleccionada == null) {
                    JOptionPane.showMessageDialog(null,
                            "No existe una cancha con ese ID.");
                } else {
                    String fecha = JOptionPane.showInputDialog(null,
                            "Fecha (dd/mm/aaaa):");

                    String horaInicio = JOptionPane.showInputDialog(null,
                            "Hora de inicio (ej. 18:00):");

                    String horaFin = JOptionPane.showInputDialog(null,
                            "Hora de fin (ej. 19:00):");

                    if (fecha != null && horaInicio != null && horaFin != null) {
                        Horario nuevoHorario =
                                new Horario(fecha, horaInicio, horaFin);

                        if (horarioDisponible(idCancha, nuevoHorario)) {
                            Reserva nuevaReserva = new Reserva(
                                    cantidadReservas + 1,
                                    usuarioActual,
                                    canchaSeleccionada,
                                    nuevoHorario);

                            listaReservas[cantidadReservas] = nuevaReserva;
                            cantidadReservas = cantidadReservas + 1;

                            String mensaje = nuevaReserva.crearReserva();

                            JOptionPane.showMessageDialog(
                                    null,
                                    mensaje + "\n" + nuevaReserva.toString());

                            registrarNotificacion(
                                    "Su reserva #" + nuevaReserva.getIdReserva()
                                            + " fue creada. Recuerde completar el pago.",
                                    "Reserva");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Ese horario ya esta ocupado para esa cancha.");
                        }
                    }
                }
            }
        }
    }

    private boolean horarioDisponible(int idCancha, Horario horario) {
        boolean disponible = true;
        int i = 0;

        while (i < cantidadReservas) {
            Reserva r = listaReservas[i];

            boolean mismaCancha =
                    r.getCancha().getIdCancha() == idCancha;

            boolean estaActiva =
                    !r.getEstado().equals("Cancelada");

            if (mismaCancha && estaActiva) {
                if (!r.getHorario().verificarDisponibilidad(horario)) {
                    disponible = false;
                }
            }

            i = i + 1;
        }

        return disponible;
    }

    private Cancha buscarCanchaPorId(int idCancha) {
        Cancha encontrada = null;
        int i = 0;

        while (i < cantidadCanchas) {
            if (listaCanchas[i].getIdCancha() == idCancha) {
                encontrada = listaCanchas[i];
            }

            i = i + 1;
        }

        return encontrada;
    }

    private void menuPagos() {
        if (usuarioActual == null) {
            JOptionPane.showMessageDialog(null,
                    "Debe iniciar sesion primero.");
        } else {
            String texto = "=== RESERVAS PENDIENTES DE PAGO ===\n";
            int i = 0;
            int cantidadPendientes = 0;

            while (i < cantidadReservas) {
                Reserva r = listaReservas[i];

                boolean esDelUsuario =
                        r.getUsuario().getIdUsuario()
                                == usuarioActual.getIdUsuario();

                if (esDelUsuario && r.getEstado().equals("Pendiente")) {
                    texto = texto + r.toString() + "\n";
                    cantidadPendientes = cantidadPendientes + 1;
                }

                i = i + 1;
            }

            if (cantidadPendientes == 0) {
                JOptionPane.showMessageDialog(null,
                        "No tiene reservas pendientes de pago.");
            } else {
                texto = texto
                        + "\nDigite el numero de reserva que desea pagar:";

                String entradaId =
                        JOptionPane.showInputDialog(null, texto);

                if (entradaId != null) {
                    int idReserva = leerEntero(entradaId);
                    Reserva reserva = buscarReservaPorId(idReserva);

                    if (reserva == null
                            || !reserva.getEstado().equals("Pendiente")) {

                        JOptionPane.showMessageDialog(null,
                                "Esa reserva no existe o ya fue pagada.");
                    } else {
                        String metodoTexto =
                                "=== PAGO DE RESERVA ===\n"
                                + "Monto a pagar: c"
                                + reserva.getCancha().getPrecioHora()
                                + "\nSeleccione metodo de pago:\n"
                                + "1. Efectivo\n"
                                + "2. Transferencia\n"
                                + "3. Tarjeta de credito";

                        String entradaMetodo =
                                JOptionPane.showInputDialog(
                                        null, metodoTexto);

                        if (entradaMetodo != null) {
                            int metodo = leerEntero(entradaMetodo);
                            String metodoPago;

                            if (metodo == 1) {
                                metodoPago = "Efectivo";
                            } else if (metodo == 2) {
                                metodoPago = "Transferencia";
                            } else if (metodo == 3) {
                                metodoPago = "Tarjeta de credito";
                            } else {
                                metodoPago = "No especificado";
                            }

                            Pago nuevoPago = new Pago(
                                    cantidadPagos + 1,
                                    reserva.getCancha().getPrecioHora(),
                                    metodoPago,
                                    reserva);

                            listaPagos[cantidadPagos] = nuevoPago;
                            cantidadPagos = cantidadPagos + 1;

                            nuevoPago.realizarPago();
                            nuevoPago.confirmarPago();

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Pago registrado con exito.\n"
                                            + nuevoPago.toString());

                            registrarNotificacion(
                                    "Su pago de la reserva #"
                                            + reserva.getIdReserva()
                                            + " fue confirmado.",
                                    "Pago");
                        }
                    }
                }
            }
        }
    }

    private Reserva buscarReservaPorId(int idReserva) {
        Reserva encontrada = null;
        int i = 0;

        while (i < cantidadReservas) {
            if (listaReservas[i].getIdReserva() == idReserva) {
                encontrada = listaReservas[i];
            }

            i = i + 1;
        }

        return encontrada;
    }

    private void menuAdministrador() {
        String usuarioIngresado =
                JOptionPane.showInputDialog(
                        null, "Usuario administrador:");

        String contrasenaIngresada =
                JOptionPane.showInputDialog(
                        null, "Contrasena:");

        if (usuarioIngresado != null
                && contrasenaIngresada != null
                && admin.validarCredenciales(
                        usuarioIngresado,
                        contrasenaIngresada)) {

            boolean volver = false;

            while (!volver) {
                String texto =
                        "=== ADMINISTRADOR ===\n"
                        + "1. Agregar cancha\n"
                        + "2. Eliminar cancha\n"
                        + "3. Ver todas las reservas\n"
                        + "4. Generar reporte\n"
                        + "5. Volver al menu principal";

                String entrada =
                        JOptionPane.showInputDialog(null, texto);

                if (entrada == null) {
                    volver = true;
                } else {
                    int opcion = leerEntero(entrada);

                    if (opcion == 1) {
                        agregarCanchaDesdeMenu();
                    } else if (opcion == 2) {
                        eliminarCanchaDesdeMenu();
                    } else if (opcion == 3) {
                        JOptionPane.showMessageDialog(
                                null,
                                admin.gestionarReservas(this));
                    } else if (opcion == 4) {
                        generarReporte();
                    } else if (opcion == 5) {
                        volver = true;
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Opcion invalida.");
                    }
                }
            }
        } else if (usuarioIngresado != null
                && contrasenaIngresada != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Usuario o contrasena incorrectos.");
        }
    }

    private void agregarCanchaDesdeMenu() {
        String entradaId =
                JOptionPane.showInputDialog(
                        null, "ID de la nueva cancha:");

        String nombre =
                JOptionPane.showInputDialog(
                        null, "Nombre de la cancha:");

        String tipo =
                JOptionPane.showInputDialog(
                        null,
                        "Tipo (Futbol 5 / Futbol 7 / Futbol 11):");

        String entradaPrecio =
                JOptionPane.showInputDialog(
                        null, "Precio por hora:");

        if (entradaId != null
                && nombre != null
                && tipo != null
                && entradaPrecio != null) {

            int id = leerEntero(entradaId);
            double precio = leerDecimal(entradaPrecio);

            Cancha nueva =
                    new Cancha(id, nombre, tipo, precio, true);

            String resultado =
                    admin.agregarCancha(this, nueva);

            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private void eliminarCanchaDesdeMenu() {
        String entradaId =
                JOptionPane.showInputDialog(
                        null,
                        "ID de la cancha a eliminar:");

        if (entradaId != null) {
            int id = leerEntero(entradaId);

            String resultado =
                    admin.eliminarCancha(this, id);

            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    public void generarReporte() {
        int reservasConfirmadas = 0;
        int reservasPendientes = 0;
        int reservasCanceladas = 0;
        int i = 0;

        while (i < cantidadReservas) {
            String estado = listaReservas[i].getEstado();

            if (estado.equals("Confirmada")) {
                reservasConfirmadas = reservasConfirmadas + 1;
            } else if (estado.equals("Pendiente")) {
                reservasPendientes = reservasPendientes + 1;
            } else if (estado.equals("Cancelada")) {
                reservasCanceladas = reservasCanceladas + 1;
            }

            i = i + 1;
        }

        double totalRecaudado = 0;
        i = 0;

        while (i < cantidadPagos) {
            if (listaPagos[i].getEstadoPago().equals("Confirmado")) {
                totalRecaudado =
                        totalRecaudado + listaPagos[i].getMonto();
            }

            i = i + 1;
        }

        String reporte =
                "=== REPORTE SMARTFUT ===\n"
                + "Usuarios registrados: "
                + cantidadUsuarios + "\n"
                + "Canchas registradas: "
                + cantidadCanchas + "\n"
                + "Total de reservas: "
                + cantidadReservas + "\n"
                + "  - Confirmadas: "
                + reservasConfirmadas + "\n"
                + "  - Pendientes: "
                + reservasPendientes + "\n"
                + "  - Canceladas: "
                + reservasCanceladas + "\n"
                + "Total recaudado: c"
                + totalRecaudado;

        JOptionPane.showMessageDialog(null, reporte);
    }

    private void registrarNotificacion(
            String mensaje, String tipo) {

        if (cantidadNotificaciones
                < listaNotificaciones.length) {

            Notificacion nueva =
                    new Notificacion(mensaje, "Hoy", tipo);

            listaNotificaciones[cantidadNotificaciones] = nueva;
            cantidadNotificaciones =
                    cantidadNotificaciones + 1;

            nueva.enviarNotificacion();
        }
    }

    private int leerEntero(String texto) {
        int valor = -1;
        boolean esValido = true;
        int i = 0;

        while (i < texto.length()) {
            char c = texto.charAt(i);

            if (c < '0' || c > '9') {
                esValido = false;
            }

            i = i + 1;
        }

        if (esValido && texto.length() > 0) {
            valor = Integer.parseInt(texto);
        }

        return valor;
    }

    private double leerDecimal(String texto) {
        double valor = 0;
        boolean esValido = true;
        int i = 0;

        while (i < texto.length()) {
            char c = texto.charAt(i);

            if ((c < '0' || c > '9') && c != '.') {
                esValido = false;
            }

            i = i + 1;
        }

        if (esValido && texto.length() > 0) {
            valor = Double.parseDouble(texto);
        }

        return valor;
    }

    public static void main(String[] args) {
        Smartfut sistema = new Smartfut();
        sistema.iniciarSistema();
    }
}
