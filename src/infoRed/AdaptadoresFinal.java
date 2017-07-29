package infoRed;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.util.TreeMap;

/**
 *
 * @author Daniel,David,Arancha
 */
public class AdaptadoresFinal {

    static String[] nombreAdaptadores = new String[100];                        //Genera cadena para almacenar los nombres de los adaptadores
    static int numeroAdaptadores = 0;                                           //Almacena el numero total de adaptadores
    static TreeMap Adaptadores = new TreeMap();                                 //TreeMap que almacena los nombres e informacion de los adaptadores

    /**
     * Este metodo inicializa todos los metodos necesarios para el
     * funcionamiento de esta clase
     *
     * @throws IOException
     */
    public static void IniciarAdaptadores() throws IOException {
        TemporalAdaptadores();                                                             //Genera un archivo temporal para el calculo de las variables
        NombreAdaptadores();                                                      //Almacena los nombres de los adaptadores en el vector nombreAdaptadores
        InfoAdaptadores();                                                        //Almacena la informacion y el codigo de adaptador en el TreeMap
        BorrarTempAdaptadores();                                                           //Borra el archivo "temp.txt" empleado en el calculo de los adaptadores
    }

    /**
     * Este metodo ejecuta un "ipconfig /all" para asi obtener toda la
     * informacion de las connexiones de red del equipo
     */
    private static String BusquedaAdaptadores() throws IOException {                       //Busca todos los adaptadores de red instalados en el equipo
        Process p = Runtime.getRuntime().exec("ipconfig /all");                 //Ejecuta un "ipconfig /all" para descubrir los adaptadores
        String salida;
        try (InputStream stdoutStream = new BufferedInputStream(p.getInputStream())) {
            StringBuilder buffer = new StringBuilder();                         //Crea un buffer para mostrar cada linea del ipconfig
            for (;;) {                                                          //Bucle for
                int c = stdoutStream.read();                                    //Crea una variable "i" donde almacena el codigo del caracter
                if (c == -1) {                                                  //if que detecta la ultima linea
                    break;                                                      //Rompe el bucle for
                }                                                               //Fin if
                buffer.append((char) c);                                        //Añade al buffer el codigo del caracter
            }                                                                   //Fin for
            salida = buffer.toString();                                         //Transforma el bufer a un String "salida"
        }
        return salida;                                                          //Devuelbe el String "salida"
    }

    /**
     * Este metodo almacena el resultado del metodo "Busqueda()" en un fichero
     * txt
     */
    public static void TemporalAdaptadores() {                                             //Genera archivo temporal "temp.txt"
        try {
            File file = new File("temp.txt");                                   //Genera archivo "temp.txt"
            file.createNewFile();                                               //Crea archivo "temp.txt"
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(BusquedaAdaptadores());                                       //Almacena el String "salida" en un .txt
                writer.flush();                                                 //Obliga a vaciar el buffer
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Este metodo busca los nombres de los adaptadores de red de cada connexion
     * dentro del archivo "temp.txt"
     *
     * @throws IOException
     */
    public static void NombreAdaptadores() throws IOException {                   //Lee el archivo "temp.txt" y extrae el nombre del adaptador a "nombreAdaptadores"
        try {
            try (BufferedReader adaptadoresIpconfig = new BufferedReader(new FileReader("temp.txt"))) {     //Carga "temp.txt" en el buffer
                String line;                                                    //Crea un objeto de clase String
                while ((line = adaptadoresIpconfig.readLine()) != null) {       //Bucle que recorre todo el buffer hasta llegar al final
                    if (line.indexOf("Descripci") != -1) {                      //If que selecciona la linea donde se encuentra el nombre del adaptador
                        nombreAdaptadores[numeroAdaptadores] = line.substring(47);//Añade el nombre del adaptador que esta apartir del caracter 47
                        numeroAdaptadores++;                                    //Añade 1 numeroAdaptadores
                    }                                                           //Fin if
                }                                                               //Fin while
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Este metodo busca la informacion de cada conexion de red dentro del
     * archivo "temp.txt"
     *
     * @throws IOException
     */
    public static void InfoAdaptadores() throws IOException {                     //Lee el archivo "temp.txt" y extrae el nombre del adaptador a "nombreAdaptadores"
        String AlmacenarInfo = "";
        String adaptador;
        numeroAdaptadores = -1;
        try {
            try (BufferedReader adaptadoresIpconfig = new BufferedReader(new FileReader("temp.txt"))) {     //Carga "temp.txt" en el buffer
                String line;                                                    //Crea un objeto de clase String
                while ((line = adaptadoresIpconfig.readLine()) != null) {       //Bucle que recorre todo el buffer hasta llegar al final
                    if (line.indexOf("Adaptador de") != -1) {                   //If que se ejecuta al encuentrar informacion de la red
                        if (numeroAdaptadores != -1) {
                            Adaptadores.put(nombreAdaptadores[numeroAdaptadores], AlmacenarInfo);//inserta los datos en un TreeMap
                        }
                        AlmacenarInfo = "";                                     //vacia el String AlmacenarInfo
                        AlmacenarInfo = line;                                   //Establece como primera linea del String el nombre de la connexion
                        numeroAdaptadores++;                                    //Añade 1 numeroAdaptadores
                    } else {
                        AlmacenarInfo = AlmacenarInfo + "\n" + line;
                    }                                                           //Fin if
                }                                                               //Fin while
                Adaptadores.put(nombreAdaptadores[numeroAdaptadores], AlmacenarInfo);//inserta el ultimo dato en el TreeMap
            }
        } catch (Exception ex) {
        }
        
    }

    /**
     * Este metodo elimina el archivo "temp.txt" que se empleo para obtener
     * datos
     */
    public static void BorrarTempAdaptadores() {                                           //Borra el archivo "temp.txt" empleado en el calculo de los adaptadores
        File tempo = new File("temp.txt");                                      //Genera "tempo" tipo archivo "temp.txt"
        tempo.delete();                                                         //Elimina el archivo "temp.txt" del ordenador
    }
}
