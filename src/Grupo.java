import java.util.ArrayList;
import java.util.HashSet;

public class Grupo {
    private HashSet<Amigo> integrantes = new HashSet<>();
    private int presupuestoMax;
    private Paquete paqueteDelGrupo;

    public Grupo(){
    }

    public boolean dentroDelPresupuesto(Paquete paquete){
        if (paquete.getImporteTotal() > presupuestoMax){
            return false;
        }
        return true;
    }

    public int getPresupuestoMax() {
        return presupuestoMax;
    }

    public HashSet<Amigo> getIntegrantes() {
        return integrantes;
    }

    public void agregarAmigo(Amigo amigo){
        integrantes.add(amigo);
    }

    public void eliminarAmgio(Amigo amigo){
        integrantes.remove(amigo);
    }

    public void setPresupuestoMax(int presupuesto){
        this.presupuestoMax = presupuesto;
    }

    public void setPaqueteDelGrupo(Paquete paquete){
        this.paqueteDelGrupo = paquete;
    }

    public void ajustarPaquete(){
        if (!dentroDelPresupuesto(paqueteDelGrupo)){
            paqueteDelGrupo.eliminarActividad(paqueteDelGrupo.actividadMasCara());
        }
    }
}
