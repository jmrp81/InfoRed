
package infoRed;

import javax.swing.JOptionPane;

/**
 * Hilo  de la aplicacion infoRed para el calculo de las subredes de red tipo A
 * @since 2013
 * @author Juan Manuel Rodriguez Perez
 */
public class HiloMostrarSubredes implements Runnable{
    //Atributos
    private InfoRed info;
    private Thread hiloAux;
    private String claseRed;
    private String salida;
    private int[] direccionIP;
    private int numeroDeSubredes;  
    private int numeroBitsAUsar;
    private int posCero=0;
    private int posUno=0;
    private int posDos=0;
    

    /**
     * Constructor de la clase HiloMostrarSubredes
     * @param info
     * @param direccionIP
     * @param numeroBitsAUsar 
     * @param claseRed 
     * @param numeroDeSubredes 
     */
    public HiloMostrarSubredes(InfoRed info, int[] direccionIP, int numeroBitsAUsar,String claseRed,int numeroDeSubredes) {
        this.info = info;
        this.direccionIP = direccionIP;
        this.numeroBitsAUsar = numeroBitsAUsar;
        this.claseRed = claseRed;
        this.numeroDeSubredes = numeroDeSubredes;
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
        String parte1 = String.valueOf(direccionIP[0]);
        String parte2 = String.valueOf(direccionIP[1]);
        String parte3 = String.valueOf(direccionIP[2]);
        posCero=0;
        posUno=0;
        posDos=0;
        int divisor;
        int divisorB;
        int divisorC;
        
        salida="IP para obtener las subredes : "+direccionIP[0]+"."+direccionIP[1]+"."+direccionIP[2]+"."+direccionIP[3]+"\n";
        salida+="Numero de subredes posibles : "+numeroDeSubredes+"\n";
        salida+="Direccion de las subredes: \n";
        info.setTextSalida(salida);
        
        switch(claseRed){
            case "A":
                if(numeroBitsAUsar<=8){
                  divisor = 256/(numeroDeSubredes+2);
                  for(int i=1;i<=numeroDeSubredes;i++){
                        posCero=divisor*i;
                        salida=info.getTextSalida()+"\n"+parte1+"."+posCero+"."+"0"+"."+"0";
                        info.setTextSalida(salida);
                 }  
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
                        salida=info.getTextSalida()+"\n"+parte1+"."+posCero+"."+posUno+"."+"0";
                        info.setTextSalida(salida);
                        }
                        if(i==255){
                            ultimo=true;
                        }
                  for(int j=1;j<=control+1;j++){
                        posUno=divisorB*j;
                        if(ultimo && j == control+1){
                        //no debe hacer nada
                        }else{
                         salida=info.getTextSalida()+"\n"+parte1+"."+posCero+"."+posUno+"."+"0"; 
                         info.setTextSalida(salida);
                        }
                  } 
                  primero=false;
                  }                 
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
                        salida=info.getTextSalida()+"\n"+parte1+"."+posCero+"."+posUno+"."+"0";
                        info.setTextSalida(salida);
                        }
                        if(i==255){
                            ultimo=true;
                        }
                  for(int j=0;j<=255;j++){
                        posUno=divisorB*j;
                        salida=info.getTextSalida()+"\n"+parte1+"."+posCero+"."+posUno+"."+"0";
                        info.setTextSalida(salida);
                        if(j==255){
                            ultimo2=true;
                        }
                  for(int k=1;k<=control+1;k++){
                        posDos=divisorC*k;
                        if(ultimo && ultimo2 && k == control+1){
                        //no debe hacer nada
                        }else{
                         salida=info.getTextSalida()+"\n"+parte1+"."+posCero+"."+posUno+"."+posDos; 
                         info.setTextSalida(salida);
                        }
                  } 
                  primero=false;
                  }    
                }
                }
            break;
            case "B":      
                if(numeroBitsAUsar<=8){
                  divisor = 256/(numeroDeSubredes+2);
                  for(int i=1;i<=numeroDeSubredes;i++){
                        posCero=divisor*i;
                        salida=info.getTextSalida()+"\n"+parte1+"."+parte2+"."+posCero+"."+"0";
                        info.setTextSalida(salida);
                 }  
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
                        salida=info.getTextSalida()+"\n"+parte1+"."+parte2+"."+posCero+"."+posUno;
                        info.setTextSalida(salida);
                        }
                        if(i==255){
                            ultimo=true;
                        }
                  for(int j=1;j<=control+1;j++){
                        posUno=divisorB*j;
                        if(ultimo && j == control+1){
                        //no debe hacer nada
                        }else{
                         salida=info.getTextSalida()+"\n"+parte1+"."+parte2+"."+posCero+"."+posUno; 
                         info.setTextSalida(salida);
                        }
                  } 
                  primero=false;
                  }                 
                }
            break;
            case "C": 
                divisor = 256/(numeroDeSubredes+2);
                for(int i=1;i<=numeroDeSubredes;i++){
                        posCero=divisor*i;
                        salida=info.getTextSalida()+"\n"+parte1+"."+parte2+"."+parte3+"."+posCero;
                        info.setTextSalida(salida);
                }
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
    }
    
}
