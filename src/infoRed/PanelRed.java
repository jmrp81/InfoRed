package infoRed;

import javax.swing.JLabel;

/**
 * JPanel que contiene la informacion relevante a una direccion de red concreta.
 * Como título tendrá dicha direccion de red y, en su interior, se indicarán su primer y 
 * su último host
 * @author Sergio
 */
public class PanelRed extends javax.swing.JPanel {

    JLabel lbHostInicial = new JLabel();
    JLabel lbHostFinal = new JLabel();
    JLabel lbPuntos = new JLabel();
    
    /**
     * Constructor de la clase. Recibe como único parametro la ip que configura su
     * dirección de red y, a través de distintos métodos, muestra sus host inicial y final
     * @param ip
     * @param ip1
     * @param ip2
     */
    public PanelRed(int[] ip, String ip1,String ip2) {
        initComponents();
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "D. Red: "+ipTexto(ip), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));
        
        //primer hosts 
        lbHostInicial.setText(ip1);
        lbHostInicial.setBounds(20,30,120,20);
        add(lbHostInicial);
        
        lbPuntos.setText("...");
        lbPuntos.setBounds(35,65,120,20);
        add(lbPuntos);
        
        //ultimo hosts 
        lbHostFinal.setText(ip2);
        lbHostFinal.setBounds(20,110,120,20);
        add(lbHostFinal);
    }
    
    /**
     * Convierte una ip int[] en String
     * 
     * @param ip
     * @return
     */
    public String ipTexto(int[] ip){
        return ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "tituloPorDefecto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
