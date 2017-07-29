
package infoRed;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Hilo  de la aplicacion infoRed para el calculo de las subredes de red tipo A
 * @since 2013
 * @author Juan Manuel Rodriguez Perez
 */
public class HiloCalcularSubredes implements Runnable{
    //Atributos
    private InfoRed info;
    private Thread hiloAux;
    private String claseRed;
    private ArrayList<int[]> listaSubredes;
    private int[] subred;
    private int[] direccionIP;
    private int[] subredFinal;
    private int numeroBitsAUsar;
    private int posCero=0;
    private int posUno=0;
    private int posDos=0;
    private int numeroDeSubredes;
    
    
      

    /**
     * Constructor de la clase HiloMostrarSubredes
     * @param info
     * @param direccionIP
     * @param numeroBitsAUsar 
     * @param claseRed 
     * @param numeroDeSubredes 
     */
    public HiloCalcularSubredes(InfoRed info, int[] direccionIP, int numeroBitsAUsar,String claseRed,int numeroDeSubredes) {
        this.info = info;
        this.direccionIP = direccionIP;
        this.numeroBitsAUsar = numeroBitsAUsar;
        this.claseRed = claseRed;
        this.numeroDeSubredes = numeroDeSubredes;
        subredFinal = new int[4];
        listaSubredes = new ArrayList<>();
        
    }
    
    /**
     * Metodo para iniciar el hilo
     */
    public void start(){
        hiloAux = new Thread(this);
        hiloAux.start();
    }
    
    /**
     * Accion del hilo
     */
    @Override
    public void run() {
        boolean primero=true;//comprobar si es el primer acceso al bucle
        boolean ultimo=false;//controlamos estamos ultimo valor tipo B para no mostrar subred todo a unos
        boolean ultimo2=false;//controlamos estamos ultimo valor tipo C para no mostrar subred todo a unos
        posCero=0;
        posUno=0;
        posDos=0;
        int divisor;
        int divisorB;
        int divisorC;        
        
        switch(claseRed){
            case "A":
                if(numeroBitsAUsar<=8){
                  divisor = 256/(numeroDeSubredes+2);
                  for(int i=1;i<=numeroDeSubredes;i++){
                        posCero=divisor*i;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=posCero;
                        subred[2]=0;
                        subred[3]=0;
                        listaSubredes.add(subred);                   
                 }
                  subredFinal[0]=direccionIP[0];
                  subredFinal[1]=255;
                  subredFinal[2]=0;
                  subredFinal[3]=0;
                  info.setSubredFinal(subredFinal);
                }else if(numeroBitsAUsar<=16){
                  int nuevoNumSubred = (int) Math.pow(2, (numeroBitsAUsar-8))-2;
                  int control;
                  if(nuevoNumSubred==0){
                      control=1;
                  }else{
                      control=nuevoNumSubred;
                  }
                  divisor = 1;
                  divisorB = 256/(nuevoNumSubred+2);
                  for(int i=0;i<=255;i++){
                        posCero=divisor*i;
                        if(!primero){
                        posUno=0;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=posCero;
                        subred[2]=posUno;
                        subred[3]=0;
                        listaSubredes.add(subred);
                        }
                        if(i==255){
                            ultimo=true;
                        }
                  for(int j=1;j<=control+1;j++){
                        posUno=divisorB*j;
                        if(ultimo && j == control+1){
                        //no debe hacer nada
                        }else{
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=posCero;
                        subred[2]=posUno;
                        subred[3]=0;
                        listaSubredes.add(subred);
                        }
                  } 
                  primero=false;
                  }  
                  subredFinal[0]=direccionIP[0];
                  subredFinal[1]=255;
                  subredFinal[2]=255;
                  subredFinal[3]=0;
                  info.setSubredFinal(subredFinal);
                }else if(numeroBitsAUsar>16){
                  int nuevoNumSubred = (int) Math.pow(2, (numeroBitsAUsar-16))-2;
                  int control;
                  if(nuevoNumSubred==0){
                      control=1;
                  }else{
                      control=nuevoNumSubred;
                  }
                  divisor = 1;
                  divisorB =1;
                  divisorC = 256/(nuevoNumSubred+2);
                  for(int i=0;i<=255;i++){
                        posCero=divisor*i;
                        if(!primero){
                        posUno=0;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=posCero;
                        subred[2]=posUno;
                        subred[3]=0;
                        listaSubredes.add(subred);
                        }
                        if(i==255){
                            ultimo=true;
                        }
                  for(int j=0;j<=255;j++){
                        posUno=divisorB*j;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=posCero;
                        subred[2]=posUno;
                        subred[3]=0;
                        listaSubredes.add(subred);
                        if(j==255){
                            ultimo2=true;
                        }
                  for(int k=1;k<=control+1;k++){
                        posDos=divisorC*k;
                        if(ultimo && ultimo2 && k == control+1){
                        //no debe hacer nada
                        }else{
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=posCero;
                        subred[2]=posUno;
                        subred[3]=posDos;
                        listaSubredes.add(subred);
                        }
                  } 
                  primero=false;
                  }    
                }
                  subredFinal[0]=direccionIP[0];
                  subredFinal[1]=255;
                  subredFinal[2]=255;
                  subredFinal[3]=255;
                  info.setSubredFinal(subredFinal);
                }
            break;
            case "B":      
                if(numeroBitsAUsar<=8){
                  divisor = 256/(numeroDeSubredes+2);
                  for(int i=1;i<=numeroDeSubredes;i++){
                        posCero=divisor*i;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=direccionIP[1];
                        subred[2]=posCero;
                        subred[3]=0;
                        listaSubredes.add(subred);
                 }
                  subredFinal[0]=direccionIP[0];
                  subredFinal[1]=direccionIP[1];
                  subredFinal[2]=255;
                  subredFinal[3]=0;
                  info.setSubredFinal(subredFinal);
                }else if(numeroBitsAUsar>8){
                  int nuevoNumSubred = (int) Math.pow(2, (numeroBitsAUsar-8))-2;
                  int control;
                  if(nuevoNumSubred==0){
                      control=1;
                  }else{
                      control=nuevoNumSubred;
                  }
                  divisor = 1;
                  divisorB = 256/(nuevoNumSubred+2);
                  for(int i=0;i<=255;i++){
                        posCero=divisor*i;
                        if(!primero){
                        posUno=0;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=direccionIP[1];
                        subred[2]=posCero;
                        subred[3]=posUno;
                        listaSubredes.add(subred);
                        }
                        if(i==255){
                            ultimo=true;
                        }
                  for(int j=1;j<=control+1;j++){
                        posUno=divisorB*j;
                        if(ultimo && j == control+1){
                        //no debe hacer nada
                        }else{
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=direccionIP[1];
                        subred[2]=posCero;
                        subred[3]=posUno;
                        listaSubredes.add(subred);
                        }
                  } 
                  primero=false;
                  }  
                  subredFinal[0]=direccionIP[0];
                  subredFinal[1]=direccionIP[1];
                  subredFinal[2]=255;
                  subredFinal[3]=255;
                  info.setSubredFinal(subredFinal);
                }
            break;
            case "C": 
                divisor = 256/(numeroDeSubredes+2);
                for(int i=1;i<=numeroDeSubredes;i++){
                        posCero=divisor*i;
                        subred = new int[4];
                        subred[0]=direccionIP[0];
                        subred[1]=direccionIP[1];
                        subred[2]=direccionIP[2];
                        subred[3]=posCero;
                        listaSubredes.add(subred);
                }
                subredFinal[0]=direccionIP[0];
                subredFinal[1]=direccionIP[1];
                subredFinal[2]=direccionIP[2];
                subredFinal[3]=255;
                info.setSubredFinal(subredFinal);
            break;
            case "D":
                JOptionPane.showMessageDialog(info, "No hay subredes para IP de tipo D", "Error calculo subredes", 1);
            break;
            case "E":
                JOptionPane.showMessageDialog(info, "No hay subredes para IP de tipo E", "Error calculo subredes", 1);
            break;
            default:
                JOptionPane.showMessageDialog(info, "Error: no identificada subred", "Error calculo subredes", 1);
            break;
        }  
        CalcularSubredes.setListaSubredes(listaSubredes);
    }
    
}
