public class AudiolibroFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String id, String titulo, int duracionSeg, String autor, String narrador) {
        return new AudioLibro(id, titulo, duracionSeg, autor, narrador);
    }
}