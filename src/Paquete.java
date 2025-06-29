import Excepciones.NoSeHospedanEnLaCiudad;

import java.util.ArrayList;
import java.util.HashSet;

public class Paquete {
    private int importeTotal;
    private final int precioHospedaje = 36;
    private int tasaTurismo = 0;
    private ArrayList<Ciudad> ciudadesVisitar = new ArrayList<>();
    private ArrayList<Actividad> actividadesHacer = new ArrayList<>();

    public int getImporteTotal() {
        return importeTotal;
    }

    public ArrayList<Ciudad> getCiudadesVisitar() {
        return ciudadesVisitar;
    }

    public ArrayList<Actividad> getActividadesHacer() {
        return actividadesHacer;
    }

    public void agregarCiudad(Ciudad c){
        ciudadesVisitar.add(c);
    }

    public void eliminarCiudad(Ciudad c){
        ciudadesVisitar.remove(c);
    }

    public void agregarActividad(Grupo grupo, Actividad actividad){
        if(actividad.sonAptos(grupo)){
            actividadesHacer.add(actividad);
        }
        throw new NoSeHospedanEnLaCiudad("No se hospedan en la ciudad de la actividad, por lo que no es posible agregar la ciudad.");
    }

    public void eliminarActividad(Actividad actividad){
        actividadesHacer.remove(actividad);
    }

    public void calcularTasaTurismo(Ciudad c){
        if (c.tieneTasaTurismo()){
            int diasEnCiudad = calcularDiasCiudad(c);
            tasaTurismo = c.getTasaTurismo() * diasEnCiudad;
        }
    }

    public int calcularDiasCiudad(Ciudad c){
        int totalDias = 0;
        for (Ciudad ciudad : ciudadesVisitar){
            if (ciudad.getNombre().equals(c.getNombre())){
                totalDias++;
            }
        }
        return totalDias;
    }

    public HashSet<String> nombreCiudadesSinRepetir(){
        HashSet<String> nombreCiudadesSinRepetir = new HashSet<>();
        for (Ciudad c : ciudadesVisitar){ // [Calafate, Calafate, Calafate, Ushuaia, Ushuaia]
            nombreCiudadesSinRepetir.add(c.getNombre());
        }
        return nombreCiudadesSinRepetir; //[Calafate, Ushuaia]
    }

    public void calcularTotalPaquete(){
        int precioActividades = 0;
        int precioDiasTotales = diasTotalDelViaje() * precioHospedaje;
        for(Ciudad c : ciudadesVisitar){
            calcularTasaTurismo(c);
        }
        for(Actividad actividad : actividadesHacer){
            precioActividades += actividad.precioFijo;
        }
        importeTotal += precioDiasTotales + tasaTurismo + precioActividades;
    }

    public int diasTotalDelViaje(){
        int dias = 0;
        for (Ciudad c : ciudadesVisitar){
            dias++;
        }
        return dias;
    }

    public Actividad actividadMasCara(){
        int precioMax = 0;
        Actividad actividadMasCara = null;
        for (Actividad actividad : actividadesHacer){
            if (actividad.precioFijo > precioMax){
                precioMax = actividad.precioFijo;
                actividadMasCara = actividad;
            }
        }
        return actividadMasCara;
    }

}
