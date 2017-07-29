package infoRed;



/**
 * @author Sergio
 */
public class CalculoIP {
    

    /**
     * comprueba que la IP se haya en el rango de IPs válidas 
     * (0.0.0.0 - 255.255.255.255), lanzando excepcion en caso negativo.
     * @param ip IP a comprobar
     * @throws FueraDeRangoException si la IP no es válida.
     */
    public static void checkIP (int[] ip) throws FueraDeRangoException{
        if (ip[0]<0 || ip[0]>255
          ||ip[1]<0 || ip[1]>255
          ||ip[2]<0 || ip[2]>255
          ||ip[3]<0 || ip[3]>255){
            throw new FueraDeRangoException();
        }
    }
    
    
    /**
     * Devuelve el tipo de red al que corresponde una IP.
     * 
     * @param ip IP introducida por el usuario.
     * @return local,A,B,C,D,E.
     * @throws FueraDeRangoException si la IP no es válida.
     */
    public static String tipoRed(int[] ip) throws FueraDeRangoException{
        checkIP(ip);
        if(ip[0]==127){
            return "local";
        }else if (ip[0]<127){
            return "A";
        }else if (ip[0]<192){
            return "B";
        }else if (ip[0]<225){
            return "C";
        }else if (ip[0]<240){
            return "D";
        }else{
            return "E";
        }
    }
    
    /**
     * Devuelve la máscara de red correspondiente al tipo de Red
     * 
     * @param tipoRed Tipo de Red (String), determinará la máscara de red. Debe ser A, B o C.
     * @return (String) La máscara de red correspondiente al tipo de Red.
     * @throws TipoRedInvalidoException si la red no es A, B o C (es decir, no tiene máscara).
     */
    public static String mostrarMascara(String tipoRed) throws TipoRedInvalidoException{
        switch (tipoRed){
            case "A":
                return "255.0.0.0";
            case "B":
                return "255.255.0.0";
            case "C":
                return "255.255.255.0";
            default:
                throw new TipoRedInvalidoException();
        }
    }
    
    /**
     * Calcula la dirección de red que corresponde a la IP indicada mediante parámetro
     * @param ip IP introducida por el usuario
     * @return (String) La dirección de red correspondiente a la ip indicada
     * @throws TipoRedInvalidoException si la red no es A, B o C (es decir, no tiene máscara)
     * @throws FueraDeRangoException si la IP no es válida.
     */
    public static String mostrarDireccionRed(int[] ip) throws TipoRedInvalidoException, FueraDeRangoException{
        switch (tipoRed(ip)){
            case "A":
                return ip[0]+".0.0.0";
            case "B":
                return ip[0]+"."+ip[1]+".0.0";
            case "C":
                return ip[0]+"."+ip[1]+"."+ip[2]+".0";
            default:
                throw new TipoRedInvalidoException(); 
        }
    }
    
    /**
     * Calcula la dirección de broadcast que corresponde a la IP indicada mediante parámetro
     * @param ip IP introducida por el usuario
     * @return (String) La dirección de broadcast correspondiente a la ip indicada
     * @throws TipoRedInvalidoException si la red no es A, B o C (es decir, no tiene máscara)
     * @throws FueraDeRangoException si la IP no es válida.
     */
    public static String mostrarDireccionBroadcast(int[] ip) throws TipoRedInvalidoException, FueraDeRangoException{
        switch (tipoRed(ip)){
            case "A":
                return ip[0]+".255.255.255";
            case "B":
                return ip[0]+"."+ip[1]+".255.255";
            case "C":
                return ip[0]+"."+ip[1]+"."+ip[2]+".255";
            default:
                throw new TipoRedInvalidoException(); 
        }
    }
    
}
