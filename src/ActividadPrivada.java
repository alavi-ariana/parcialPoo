public class ActividadPrivada extends Actividad{
    private int maxParticipantes;
    private int precioActividad;
    private final Ciudad ciudad;

    public ActividadPrivada(String nombreActividad, Ciudad ciudad, int maxParticipantes, int precio){
        super.nombreActividad = nombreActividad;
        this.ciudad = ciudad;
        this.maxParticipantes = maxParticipantes;
        this.precioActividad = precio;
    }

    @Override
    public boolean sonAptos(Grupo grupo){
        for (int i = 0; i < grupo.getIntegrantes().size(); i++) {
            if(i > maxParticipantes){
                return false;
            }
        }
        return true;
    }

}
