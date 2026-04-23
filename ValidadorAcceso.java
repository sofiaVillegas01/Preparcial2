public class ValidadorAcceso {
    public static boolean puedeReproducir(Usuario u, Contenido c) {
        if (u == null) return false;
        if (u.esPremium()) return true;
// Usuarios free no pueden acceder a audiolibros
        if (c instanceof AudioLibro) return false;
        return true;
    }
}
