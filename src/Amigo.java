public class Amigo {
    private String nombre;
    private final int nivelAdrenalina;

    public Amigo(String nombre, int nivelAdrenalina){
        this.nombre = nombre;
        this.nivelAdrenalina = nivelAdrenalina;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelAdrenalina(){
        return nivelAdrenalina;
    }
}
