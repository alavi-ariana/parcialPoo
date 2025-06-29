public class Ciudad {
    private String nombre;
    private int tasaTurismo = 0;

    public Ciudad(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTasaTurismo(int tasaTurismo) {
        this.tasaTurismo = tasaTurismo;
    }

    public int getTasaTurismo() {
        return tasaTurismo;
    }

    public boolean tieneTasaTurismo(){
        return (tasaTurismo != 0);
    }
}
