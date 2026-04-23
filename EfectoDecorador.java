public abstract class EfectoDecorador implements IReproductor {
    protected IReproductor envuelto;

    public EfectoDecorador(IReproductor envuelto) {
        this.envuelto = envuelto;
    }

    @Override
    public void reproducir(Contenido c) {
        envuelto.reproducir(c);
    }
}