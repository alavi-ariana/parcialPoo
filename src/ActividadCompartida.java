public class ActividadCompartida extends Actividad{
    private int nivelMinAdrenalina;
    private int totalActividad;
    private final Ciudad ciudad;

    public ActividadCompartida(String nombreActividad, Ciudad ciudad, int precioFijo, int nivelMinAdrenalina){
        super.nombreActividad = nombreActividad;
        this.ciudad = ciudad;
        super.precioFijo = precioFijo;
        this.nivelMinAdrenalina = nivelMinAdrenalina;
    }

    @Override
    public boolean sonAptos(Grupo grupo){
        for (Amigo integrante : grupo.getIntegrantes()){
            if(integrante.getNivelAdrenalina() >= nivelMinAdrenalina){
                return true;
            }
        }
        return false;
    }

    public void calcularPrecio(Grupo grupo){
        for (Amigo integrante : grupo.getIntegrantes()){
            totalActividad += super.precioFijo;
        }
    }

    public int getNivelMinAdrenalina() {
        return nivelMinAdrenalina;
    }

    public int getTotalActividad() {
        return totalActividad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
