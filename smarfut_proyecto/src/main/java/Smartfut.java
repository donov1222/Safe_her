public class Smartfut {
  private Usuario[] listaUsuarios;
    private int cantidadUsuarios;

    private Cancha[] listaCanchas;
    private int cantidadCanchas;

    public Smartfut() {
        listaUsuarios = new Usuario[50];
        cantidadUsuarios = 0;

        listaCanchas = new Cancha[50];
        cantidadCanchas = 0;
    }

    public void iniciarSistema() {
        System.out.println("===== BIENVENIDO A SMARTFUT =====");
    }

    public static void main(String[] args) {
        Smartfut sistema = new Smartfut();
        sistema.iniciarSistema();
    }  
}
