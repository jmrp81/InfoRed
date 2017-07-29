package infoRed;

/**
 * clase para realizar cambios de bases
 * La clase esta formada por metodos a traves de los cuales haremos los cambios
 * de una base seleccionada a la que nosotros elijamos
 * @author Benhur carcaba Alba
 */
public class CambioBases {
/**
 * Pasamos el numero de decimal a binario
 * @param numero metemos como parametro un string el cual en este caso sera el numero en decimal
 * @return numero, retornamos el string en binario.
 */
    public static String pasarDecimalBinario(String numero) {
        numero = Integer.toString(Integer.parseInt(numero), 2);

        if (numero.length() <= 8) {
            // numeroCeros se utiliza para calcular el numero de ceros que hay que añadir al numero para tener 8 digitos
            int numeroCeros = 8 - numero.length();
            for (int i = 0; i < numeroCeros; i++) {
                numero = "0" + numero;
            }
        }
        return numero;
    }
/**
 * Pasamos de binario a decimal
 * @param numero pasamos por parametro un string el cual pasaremos a decimal
 * @return retornamos un String que sera el numero en decimal
 */
    public static String pasarBinarioDecimal(String numero) {
        int dec = Integer.parseInt(numero, 2);
        return String.valueOf(dec);
    }
/**
 * Pasamos de decimal a hexadecimal
 * @param numero pasamos por parametro un string con un numero decimal
 * el cual pasaremos a hexadecimal
 * @return retornamos un String el cual sera el numero en hexadecimal
 */
    public static String pasarDecimalHexadecimal(String numero) {
        numero = Integer.toString(Integer.parseInt(numero), 16);
        return numero;
    }
/**
 * Pasamos de hexadecimal a decimal
 * @param numero pasamos por parametro un string que sera el numero en hexadecimal
 * para convertirlo en decimal
 * @return retornamos un string con el valor del numero en base decimal
 */
    public static String pasarHexadecimalDecimal(String numero) {
        int dec = Integer.parseInt(numero, 16);
        return String.valueOf(dec);
    }
/**
 * Pasamos de binario a hexadecimal
 * invocamos el metodo "pasarDecimalHexadecimal" ponemos como parametro el metodo "pasarBinarioDecimal" y como parametro el numero del metodo principal
 * @param numero pasamos por parametro un string que sera el numero en binario
 * el cual pasaremos a hexadecimal
 * @return retornamos un string que sera el numero en hexadecimal
 */
    public static String pasarBinarioHexadecimal(String numero) {
        //usamos toUpperCase para pasar a mayusculas las letras
        return (pasarDecimalHexadecimal(pasarBinarioDecimal(numero))).toUpperCase();
    }
/**
 * Pasamos de hexadecimal a binario
 * invocamos el metodo "pasarDecimalBinario" como parametro metemos el metodo "pasarHexadecimalDecimal" y como parametro el numero del metodo principal
 * @param numero pasamos por parametro un string que sera el numero en hexadecimal
 * el cual pasaremos a binario
 * @return retornamos un string que sera el numero en binario
 */
    public static String pasarHexadecimalBinario(String numero) {
        return pasarDecimalBinario(pasarHexadecimalDecimal(numero));
    }
/**
 * Pasamos toda la ip por partes de decimal a binario
 * mediante el metodo "pasarDecimalBinario"
 * @param ip1 primera parte de la ip
 * @param ip2 segunda parte de la ip
 * @param ip3 tercera parte de la ip
 * @param ip4 cuarta parte de la ip
 * @return la ip en binario
 */
    public static String decimalBinario(String ip1, String ip2, String ip3, String ip4) {
        return pasarDecimalBinario(ip1) + "." + pasarDecimalBinario(ip2) + "." + pasarDecimalBinario(ip3)
                + "." + pasarDecimalBinario(ip4);
    }
/**
 * Pasamos toda la ip por partes de binario a decimal
 * mediante el metodo "pasarBinarioDecimal"
 * @param ip1 primera parte de la ip
 * @param ip2 segunda parte de la ip
 * @param ip3 tercera parte de la ip
 * @param ip4 cuarta parte de la ip
 * @return retornamos la ip en decimal
 */
    public static String binarioDecimal(String ip1, String ip2, String ip3, String ip4) {
        return pasarBinarioDecimal(ip1) + "." + pasarBinarioDecimal(ip2) + "." + pasarBinarioDecimal(ip3)
                + "." + pasarBinarioDecimal(ip4);
    }
/**
 * pasamos la ip por partes de decimal a hexadecimal
 * mediante el metodo "pasarDecimalHexadecimal"
 * @param ip1 primera parte de la ip
 * @param ip2 segunda parte de la ip
 * @param ip3 tercera parte de la ip
 * @param ip4 cuarta parte de la ip
 * @return retornamos la ip en hexadecimal
 */
    public static String decimalHexadecimal(String ip1, String ip2, String ip3, String ip4) {
        return (pasarDecimalHexadecimal(ip1) + "." + pasarDecimalHexadecimal(ip2) + "." + pasarDecimalHexadecimal(ip3)
                + "." + pasarDecimalHexadecimal(ip4)).toUpperCase();
    }
/**
 * pasamos la ip por partes de hexadecimal a decimal
 * mediante el metodo "pasarHexadecimalDecimal"
 * @param ip1 primera parte de la ip
 * @param ip2 segunda parte de la ip
 * @param ip3 tercera parte de la ip
 * @param ip4 cuarta parte de la ip
 * @return retornamos la ip en decimal
 */
    public static String hexadecimalDecimal(String ip1, String ip2, String ip3, String ip4) {
        return pasarHexadecimalDecimal(ip1) + "." + pasarHexadecimalDecimal(ip2) + "." + pasarHexadecimalDecimal(ip3)
                + "." + pasarHexadecimalDecimal(ip4);
    }
/**
 * pasamos la ip por partes de binario a hexadecimal
 * mediante el metodo "binarioHexadecimal"
 * @param ip1 primera parte de la ip
 * @param ip2 segunda parte de la ip
 * @param ip3 tercera parte de la ip
 * @param ip4 cuarta parte de la ip
 * @return retornamos la ip en hexadecimal
 */
    public static String binarioHexadecimal(String ip1, String ip2, String ip3, String ip4) {
        return pasarBinarioHexadecimal(ip1) + "." + pasarBinarioHexadecimal(ip2) + "." + pasarBinarioHexadecimal(ip3)
                + "." + pasarBinarioHexadecimal(ip4);
    }
/**
 * pasamos la ip por partes de hexadecimal a binario
 * mediante el metodo "pasarHexadecimalBinario"
 * @param ip1 primera parte de la ip
 * @param ip2 segunda parte de la ip
 * @param ip3 tercera parte de la ip
 * @param ip4 cuarta parte de la ip
 * @return retornamos la ip en binario
 */
    public static String hexadecimalBinario(String ip1, String ip2, String ip3, String ip4) {
        return pasarHexadecimalBinario(ip1) + "." + pasarHexadecimalBinario(ip2) + "." + pasarHexadecimalBinario(ip3)
                + "." + pasarHexadecimalBinario(ip4);
    }

}
