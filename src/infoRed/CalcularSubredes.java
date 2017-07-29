
package infoRed;


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase de la aplicacion infoRed para el calculo de las subredes
 * @since 2013
 * @author Juan Manuel Rodriguez Perez
 */
public class CalcularSubredes {
    //Atributos
    private InfoRed infoRed;
    public static ArrayList<int[]> listaSubredes;
    private String claseRed;
    private int[] direccionIP;
    private int numeroDeSubredes;
    private int numeroBitsAUsar;
    private boolean poderCalcular=false;
    
      

    /**
     * Constructor de la clase para calcular subredes
     * @param infoRed
     * @param direccionIP
     * @param numeroBitsAUsar 
     */
    public CalcularSubredes(InfoRed infoRed,int[] direccionIP, int numeroBitsAUsar){
        this.infoRed = infoRed;
        this.direccionIP = direccionIP;
        this.numeroBitsAUsar = numeroBitsAUsar;
        listaSubredes = new ArrayList<int[]>();
        calcularTipoRed(direccionIP);
        calculoNumeroSubredes(numeroBitsAUsar);
    }

    /**
     * Metodo para calcular el tipo de red a traves de la ip
     */
    private void calcularTipoRed(int[] direcIP){
        try {
            claseRed = CalculoIP.tipoRed(direcIP);
        } catch (FueraDeRangoException ex) {
            JOptionPane.showMessageDialog(infoRed, "Error: la IP introducia esta fuera de Rango", "Error de IP", 1);
        }
    }
    
    /**
     * Metodo para calcular el numero de subredes que vamos a tener
     */
    private void calculoNumeroSubredes(int bitsAUsar){
        switch(claseRed){
            case "A":
                if(bitsAUsar<=22 && bitsAUsar>1){
                  numeroDeSubredes=(int) Math.pow(2, bitsAUsar)-2;
                  poderCalcular=true;
                }else{
                  JOptionPane.showMessageDialog(infoRed, "No se puede robar tantos bits en una IP de clase A (max 22 bits)", "Error calculo subredes", 1);  
                }
            break;
            case "B":
                if(bitsAUsar<=14 && bitsAUsar>1){
                  numeroDeSubredes=(int) Math.pow(2, bitsAUsar)-2;
                  poderCalcular=true;
                }else{
                  JOptionPane.showMessageDialog(infoRed, "No se puede robar tantos bits en una IP de clase B (max 14 bits)", "Error calculo subredes", 1);  
                }
            break;
            case "C":
                if(bitsAUsar<=6 && bitsAUsar>1){
                  numeroDeSubredes=(int) Math.pow(2, bitsAUsar)-2;
                  poderCalcular=true;
                }else{
                  JOptionPane.showMessageDialog(infoRed, "No se puede robar tantos bits en una IP de clase C (max 6 bits)", "Error calculo subredes", 1);  
                }
            break;
            case "D":
                JOptionPane.showMessageDialog(infoRed, "No hay subredes para IP de tipo D", "Error calculo subredes", 1);
            break;
            case "E":
                JOptionPane.showMessageDialog(infoRed, "No hay subredes para IP de tipo E", "Error calculo subredes", 1);
            break;
            default:
                JOptionPane.showMessageDialog(infoRed, "Error: no identificada subred", "Error calculo subredes", 1);
            break;
        }
    }
    
    /**
     * Metodo para calcular las direcciones de subredes de la IP pasada
     */
    public void mostrarSubredes(){
        if(poderCalcular){        
        HiloMostrarSubredes hilo = new HiloMostrarSubredes(infoRed,direccionIP,numeroBitsAUsar,claseRed,numeroDeSubredes);
        hilo.start();
        }
    }
    
    /**
     * Metodo devuelve lista de subredes de la red ip
     * @return 
     */
    public ArrayList getSubredes(){
        if(poderCalcular){        
        HiloCalcularSubredes hilo = new HiloCalcularSubredes(infoRed,direccionIP,numeroBitsAUsar,claseRed,numeroDeSubredes);
        hilo.start();
        }
        return listaSubredes;
    }

    /**
     * Asignar arraylist a lsitasubredes
     * @param listaSubredes 
     */
    public static void setListaSubredes(ArrayList<int[]> listaSubredes) {
        CalcularSubredes.listaSubredes = listaSubredes;
    }
    
    
}
