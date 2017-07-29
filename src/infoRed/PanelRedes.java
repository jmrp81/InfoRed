
package infoRed;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;



/**
 * PanelRedes genera un panel donde se crean de 1 a 5 subpanesles que contienen
 * informacion relativa a distintas subredes.
 * 
 * El programa mostrará, por defecto:
 * - Todas las direcciones de red, si son 5 o menos
 * - Las dos primeras y las dos últimas, en otro caso
 * 
 * ATRIBUTOS:
 * 
 * ipRed -> lista de direcciones de red
 * lbPuntos -> etiqueta con puntos suspensivos (aparecerá si hay más de 5 direcciones
 * de red
 *
 * @author Sergio
 */
public class PanelRedes extends javax.swing.JPanel {
    List <int[]> ipRed = new ArrayList<>();
    JLabel lbPuntos;
    private int[] subredFinal;//variable para marcar la ultima subred para los calculos --JUANMA
    
    
    /**
     * constructor de la clase
     * @param ipRed
     */
    public PanelRedes(List <int[]> ipRed) throws Exception { //lista de subredes como parametro
        this.ipRed = ipRed;
        initComponents();
        initMoreComponents();
    }
    
    /**
     * Inicializacion manual del resto de componentes
     */
    public void initMoreComponents() throws Exception{
        if (ipRed.size()<=5) {
            int posX=10;
            for (int i = 0; i < ipRed.size(); i++) {
                colocaPanelRed(i,ipRed,posX);
                posX+=160;
            }
        }else if (ipRed.size()>=5){
            colocaPanelRed(0,ipRed,10);
            colocaPanelRed(1,ipRed,170);
            
            lbPuntos = new JLabel();
            lbPuntos.setBounds(70+160*2,60,50,50);
            lbPuntos.setText("<html><h1>. . .</h1></html>");
            add(lbPuntos);
            
            colocaPanelRed(ipRed.size()-2,ipRed,490);
            colocaPanelRed(ipRed.size()-1,ipRed,650);
        }
    }
    
    /**
     * Coloca un jPanel con el contenido de la Direccion de Red que se le pasa
     * por parámetro     * 
     * 
     * @param i posicion de la direccion de red en la lista de direcciones de red
     * @param ipRed lista de direcciones de red
     * @param posX posicion X en el jPanel
     */
    public void colocaPanelRed(int i, List<int[]> ipRed, int posX) throws Exception{
        ArrayList<String> ips;
        PanelRed panelRed;
        if((i+1)<ipRed.size()){
                //añadida la condicion if para que no se salga de rango --> juanma
                if(ipRed.get(i+1)!=null){
                ips =(ArrayList)  Host.listartodosHosts(ipRed.get(i), ipRed.get(i+1));
                }else{
                ips =(ArrayList) Host.listartodosHosts(ipRed.get(i), subredFinal);    
                }
                int ultimo = ips.size();    
                panelRed = new PanelRed(ipRed.get(i),ips.get(i),ips.get(ultimo-1));
                panelRed.setBounds(posX,20,150,150);
                setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REDES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP)); 
                add(panelRed);
        }   
    }

    /**
     * Metodo set para pasarle a la subredFinal su valor
     * JUANMA
     * @param subredFinal 
     */
    public void setSubredFinal(int[] subredFinal) {
        this.subredFinal = subredFinal;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}