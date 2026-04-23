public class EqEfecto extends EfectoDecorador {
    public EqEfecto(IReproductor envuelto) {
        super(envuelto);
    }

    @Override
    public void reproducir(Contenido c) {
        super.reproducir(c);
        System.out.println("Ecualizador aplicado");
    }
}
