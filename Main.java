public class Main {

    public static void main(String[] args) {

        // ===== SINGLETON =====
        ReproductorGlobal global = ReproductorGlobal.getInstancia();
        Usuario sara  = new Usuario("U001", "sara",  Usuario.TipoSuscripcion.PREMIUM);
        Usuario pedro = new Usuario("U002", "pedro", Usuario.TipoSuscripcion.FREE);
        global.iniciarSesion(sara);

        // ===== FACTORY METHOD =====
        ContenidoFactory cancionF     = new CancionFactory();
        ContenidoFactory podcastF     = new PodcastFactory();
        ContenidoFactory audiolibroF  = new AudiolibroFactory();

        Contenido c1 = cancionF.crearContenido("C01", "rock",          230,   "Bolivar",    "oh no");
        Contenido c2 = cancionF.crearContenido("C02", "miami",       391,   "robles",         "Hotel las vegas");
        Contenido c3 = podcastF.crearContenido("P012","El Método de clichock",        1800,  "rocky",          "66");
        Contenido c4 = audiolibroF.crearContenido("A01","the vampires", 75000, "García rodriguez", "Sebanti");

        // ===== COMPOSITE =====
        Playlist favoritas = new Playlist("Favoritas");
        favoritas.agregar(new ElementoContenido(c1));
        favoritas.agregar(new ElementoContenido(c2));

        Playlist aprender = new Playlist("Aprendizaje");
        aprender.agregar(new ElementoContenido(c3));
        aprender.agregar(new ElementoContenido(c4));

        Playlist miSemana = new Playlist("Mi semana");
        miSemana.agregar(favoritas);
        miSemana.agregar(aprender);

        miSemana.mostrar("");
        System.out.println("Duración total: " + miSemana.duracionTotal() + " segundos");

        // ===== DECORATOR + PROXY =====
        IReproductor paraSara  = construirReproductor(sara,  true, true,  false);
        IReproductor paraPedro = construirReproductor(pedro, true, false, true);

        System.out.println("\n--- sara (PREMIUM) reproduce un audiolibro");
        paraSara.reproducir(c4);

        System.out.println("\n--- pedro (FREE) intenta un audiolibro (bloqueado)");
        paraPedro.reproducir(c4);

        System.out.println("\n--- pedro (FREE) escucha una canción (con anuncio)");
        paraPedro.reproducir(c1);
    }


    private static IReproductor construirReproductor(Usuario u, boolean eq, boolean reverb, boolean d8) {
        IReproductor r = new ReproductorBase();
        if (eq)    r = new EqEfecto(r);
        if (reverb) r = new ReverbEfecto(r);
        if (d8)    r = new Efecto8D(r);
        return new ProxyReproductor(r, u);
    }
}