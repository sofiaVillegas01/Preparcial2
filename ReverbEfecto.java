public class ReverbEfecto extends EfectoDecorador {
    public ReverbEfecto(IReproductor envuelto) {
        super(envuelto);
    }

    @Override
    public void reproducir(Contenido c) {
        super.reproducir(c);
        System.out.println("Reverb aplicado");
    }
}