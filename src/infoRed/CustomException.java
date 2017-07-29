package infoRed;

/**
 * @author Sergio
 */
public class CustomException extends Exception{
    public CustomException(String message) {
        super(message);
    }    
}

/**
 * @author Sergio
 */
class FueraDeRangoException extends CustomException{
    public FueraDeRangoException() {
        super("IP fuera de rango (0.0.0.0 - 255.255.255.255).");              
    }
}

/**
 * @author Sergio
 */
class TipoRedInvalidoException extends CustomException{
    public TipoRedInvalidoException() {
        super("Operación válida solo para redes A,B,C.");              
    }
}