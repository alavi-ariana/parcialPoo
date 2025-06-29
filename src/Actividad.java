public abstract class Actividad {
    protected String nombreActividad;
    protected int precioFijo;

    public abstract boolean sonAptos(Grupo grupo);
}
