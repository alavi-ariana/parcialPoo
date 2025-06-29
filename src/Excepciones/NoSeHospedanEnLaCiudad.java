package Excepciones;

public class NoSeHospedanEnLaCiudad extends RuntimeException {
    public NoSeHospedanEnLaCiudad(String message) {
        super(message);
    }
}
