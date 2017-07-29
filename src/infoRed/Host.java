package infoRed;

/**
 * @author Desi y Juanma(modificado de metodos para devolver una lista con vector de enteros)
 */

import java.util.*;


public class Host {

    static int[] subredA = new int[4];
    static int[] subredB = new int[4];
    static int[] equipo = new int[4];
    static ArrayList<String> resultado = new ArrayList<>();
    static ArrayList<int[]> resultadoInt = new ArrayList<>();



    /**
     * Calculo en el numero de host, que si llega el indice 3 del vector a 255,
     * el indice 3 pase a 0, y si no, que se sume uno. Y paro el programa antes
     * que muestre el valor de la 2º subred. Luego, todos los host que ahi, los
     * almaceno en un list. Dento de este metodo, ejecuto otro que hace lo mismo
     * del indice, pero con el indice 2.
     *
     *  * @return
     * @throws Exception
     */
    private static void calculoindice3Vector() throws Exception {

        if (subredA[3] >= 255) {
            subredA[3] = 0;
            calculoindice2Vector();
        } else {
            subredA[3] += 1;
        }
        if (subredA[3] != subredB[3] || subredA[2] != subredB[2] || subredA[1] != subredB[1] || subredA[0] != subredB[0]) {

            resultado.add(String.valueOf(subredA[0] + "." + subredA[1] + "." + subredA[2] + "." + subredA[3]));
            //juanma
            equipo[0]=subredA[0];
            equipo[1]=subredA[1] ;
            equipo[2]=subredA[2];
            equipo[3]=subredA[3];
            resultadoInt.add(equipo);
        }



    }

    /**
     * Calculo en el numero de host, que si llega el indice 2 del vector a 255,
     * el indice 2 pase a 0, y si no, que se sume uno. Dento de este metodo,
     * ejecuto otro que hace lo mismo del indice, pero con el indice 1.
     *
     *  * @return
     * @throws Exception
     */
    static public void calculoindice2Vector() throws Exception {
        if (subredA[2] >= 255) {
            subredA[2] = 0;
            calculoindice1Vector();
        } else {
            subredA[2] += 1;
        }
    }

    /**
     *  * Calculo en el numero de host, que si llega el indice 1 del vector a
     * 255, el indice 1 pase a 0, y si no, que se sume uno. Dento de este
     * metodo, ejecuto otro que hace lo mismo del indice, pero con el indice 0.
     * @throws Exception
     */
    static public void calculoindice1Vector() throws Exception {
        if (subredA[1] >= 255) {
            subredA[1] = 0;
            calculoindice0Vector();
        } else {
            subredA[1] += 1;
        }
    }

    /**
     * Si el indice 0, llega a 255, saldra un mensaje de error, ya que a llegado
     * al limite.
     * @throws Exception
     */
    static public void calculoindice0Vector() throws Exception {
        if (subredA[0] >= 255) {
            throw new Exception();

        }
    }

    /**
     * Hago que me den todos los host entre la subred 1 y la subred 2.
     * @throws Exception
     */
    static public void listadeHost() throws Exception {
        while (subredA[3] < subredB[3] || subredA[2] < subredB[2] || subredA[1] < subredB[1] || subredA[0] < subredB[0]) {
            calculoindice3Vector();
        }

    }

    /**
     *     
     * Para eliminar el ultimo numero del host, que seria el de broadcast, busco
     * en un list la ultima posicion, y luego procedo a borrarla. Devuelvo con
     * un return la lista, para que se pueda listar y por tanto mostrar todos
     * los host.
     *
     * @return
     * @throws Exception
     */
    public static List listartodosHosts(int []subred,int []subred2) throws Exception {
        subredA[0]=subred[0];
        subredA[1]=subred[1];
        subredA[2]=subred[2];
        subredA[3]=subred[3];
        
        subredB[0]=subred2[0];
        subredB[1]=subred2[1];
        subredB[2]=subred2[2];
        subredB[3]=subred2[3];
        listadeHost();
        int ultimohost = resultado.size();
        resultado.remove(ultimohost - 1);
        return resultado;

    }
    
    /**
     * Metodo para calcular todos los hosts y obtener una lista de ellos de una subred (juanma)
     * @param subred
     * @param subred2
     * @return
     * @throws Exception 
     */
    public static List getTodosHosts(int []subred,int []subred2) throws Exception {
        subredA[0]=subred[0];
        subredA[1]=subred[1];
        subredA[2]=subred[2];
        subredA[3]=subred[3];
        
        subredB[0]=subred2[0];
        subredB[1]=subred2[1];
        subredB[2]=subred2[2];
        subredB[3]=subred2[3];
        
        listadeHost();
        int ultimohost = resultadoInt.size();
        resultadoInt.remove(ultimohost - 1);
        return resultadoInt;
    }
}
