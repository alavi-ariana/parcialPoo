package Excepciones;

public class NoHayActividades extends RuntimeException {
    public NoHayActividades(String message) {
        super(message);
    }
}
