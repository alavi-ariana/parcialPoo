import Excepciones.NoHayActividades;
import Excepciones.NoSeHospedanEnLaCiudad;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // CREACION DE CIUDADES
        Ciudad buenosAires = new Ciudad("Buenos Aires");
        Ciudad mendoza = new Ciudad("Mendoza");
        Ciudad bariloche = new Ciudad("Bariloche");
        Ciudad marDelPlata = new Ciudad("Mar del Plata");

        // AGREGADO DE TASA TURISMO A CIUDAD
        bariloche.setTasaTurismo(6);

        // CREACION DE LOS AMIGOS
        Amigo martin = new Amigo("Martin", 6);
        Amigo matias = new Amigo("Matias", 7);
        Amigo nico = new Amigo("Nico", 9);


        // CREACION DE ACTIVIDADES
        ActividadCompartida parapente = new ActividadCompartida("Parapente", marDelPlata, 1500, 5);
        ActividadCompartida claseSki = new ActividadCompartida("Clase de Sky", bariloche, 156, 5);
        ActividadPrivada velero = new ActividadPrivada("Velero", buenosAires, 5, 720);

        // CREACION DE GRUPO AMIGOS
        Grupo grupo1 = new Grupo();

        // CREACION DE PAQUETE
        Paquete paqueteGrupo1 = new Paquete();

        // ASIGNACION DE PAQUETE A GRUPO
        grupo1.setPaqueteDelGrupo(paqueteGrupo1);

        // AGREGACION DE AMIGOS A GRUPO
        grupo1.agregarAmigo(martin);
        grupo1.agregarAmigo(matias);
        grupo1.agregarAmigo(nico);

        // SETTEO DE PRESUPUESTO AL GRUPO
        grupo1.setPresupuestoMax(2400);

        // AGREGADO DE CIUDADES
        paqueteGrupo1.agregarCiudad(buenosAires);
        paqueteGrupo1.agregarCiudad(mendoza);
        paqueteGrupo1.agregarCiudad(bariloche);

        // AGREGACION DE ACTIVIDADES

        try{
            paqueteGrupo1.agregarActividad(grupo1, parapente);
        } catch (NoSeHospedanEnLaCiudad e) {
            throw new RuntimeException(e);
        }

        try{
            paqueteGrupo1.agregarActividad(grupo1, claseSki);
        } catch (NoSeHospedanEnLaCiudad e) {
            throw new RuntimeException(e);
        }

        try{
            paqueteGrupo1.agregarActividad(grupo1, velero);
        } catch (NoSeHospedanEnLaCiudad e) {
            throw new RuntimeException(e);
        }

        // IMPORTE TOTAL DEL PAQUETE
        System.out.println("El importe total del paquete es de: $" + paqueteGrupo1.getImporteTotal());

        // SABER SI EL PAQUETE ESTA DENTRO DEL PRESUPUESTO
        System.out.println("¿El paquete se encuentra dentro del presupuesto? " + grupo1.dentroDelPresupuesto(paqueteGrupo1));

        // VER CUÁL ES LA ACTIVIDAD MÁS CARA
        Actividad actividadMasCara = paqueteGrupo1.actividadMasCara();
        if (actividadMasCara == null){
            throw new NoHayActividades("No hay actividades cargadas");
        }else{
            System.out.println("La actividad más cara es " + actividadMasCara.nombreActividad + " con un precio de $" + actividadMasCara.precioFijo);
        }

        // AJUSTAR PAQUETE AL PRESUPUESTO
        grupo1.ajustarPaquete();





    }

    
}
