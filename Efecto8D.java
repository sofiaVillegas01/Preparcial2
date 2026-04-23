public class Efecto8D extends EfectoDecorador {
    public Efecto8D(IReproductor envuelto) {
        super(envuelto);
    }

    @Override
    public void reproducir(Contenido c) {
        super.reproducir(c);
        System.out.println("Efecto 8D aplicado");
    }
}

