package infoRed;

import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;


/**
 * Interfaz para pedir la direccion IP
 * @version 2013
 * @serial 1.0
 * @author Juan Manuel / Abraham Lopez
 */
public class PedirIPCambioBase extends javax.swing.JDialog {
    //Atributos
    private InfoRed info;
    private int[] direccionIP;
    private GridBagConstraints gridBagConstraints;
    private javax.swing.JTextField textCampo1;
    private javax.swing.JTextField textCampo2;
    private javax.swing.JTextField textCampo3;
    private javax.swing.JTextField textCampo4;
    
    /**
     * Creates new form PedirIP
     * @param parent
     * @param modal
     */
    public PedirIPCambioBase(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        info = (InfoRed) parent;
        initComponents();
        this.setLocationRelativeTo(null);
        direccionIP=new int[4];
        crearTextFields();
    }
    
        /**
         * Metodo para crear los botones
         */
        private void crearTextFields(){
            textCampo1 = new javax.swing.JTextField(1);
            textCampo1.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo1.setDocument(new JTextFieldLimit(8));
            textCampo2 = new javax.swing.JTextField(1);
            textCampo2.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo2.setDocument(new JTextFieldLimit(8));
            textCampo3 = new javax.swing.JTextField(1);
            textCampo3.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo3.setDocument(new JTextFieldLimit(8));
            textCampo4 = new javax.swing.JTextField(1);
            textCampo4.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo4.setDocument(new JTextFieldLimit(8));
            
            textCampo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo1.setMaximumSize(new java.awt.Dimension(80, 23));
            textCampo1.setMinimumSize(new java.awt.Dimension(80, 23));
            textCampo1.setPreferredSize(new java.awt.Dimension(80, 23));
            textCampo1.setToolTipText("campo 1 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 55;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo1, gridBagConstraints);

            textCampo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo2.setMaximumSize(new java.awt.Dimension(80, 23));
            textCampo2.setMinimumSize(new java.awt.Dimension(80, 23));
            textCampo2.setPreferredSize(new java.awt.Dimension(80, 23));
            textCampo2.setToolTipText("campo 2 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 55;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo2, gridBagConstraints);

            textCampo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo3.setMaximumSize(new java.awt.Dimension(80, 23));
            textCampo3.setMinimumSize(new java.awt.Dimension(80, 23));
            textCampo3.setPreferredSize(new java.awt.Dimension(80, 23));
            textCampo3.setToolTipText("campo 3 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 55;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 8;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo3, gridBagConstraints);

            textCampo4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo4.setMaximumSize(new java.awt.Dimension(80, 23));
            textCampo4.setMinimumSize(new java.awt.Dimension(80, 23));
            textCampo4.setPreferredSize(new java.awt.Dimension(80, 23));
            textCampo4.setToolTipText("campo 4 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 55;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 12;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo4, gridBagConstraints);
           
        }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContenedor = new javax.swing.JPanel();
        labelPedirIp = new javax.swing.JLabel();
        panelIps = new javax.swing.JPanel();
        label1Punto = new javax.swing.JLabel();
        label2Punto = new javax.swing.JLabel();
        label3Punto = new javax.swing.JLabel();
        buttonIngresarIP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Introducir IP");
        setMaximumSize(new java.awt.Dimension(400, 200));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setResizable(false);

        panelContenedor.setToolTipText("Panel contenedor de pedir la IP");
        panelContenedor.setMaximumSize(new java.awt.Dimension(300, 200));
        panelContenedor.setMinimumSize(new java.awt.Dimension(300, 200));
        panelContenedor.setPreferredSize(new java.awt.Dimension(300, 200));

        labelPedirIp.setText("Introducir la direccion IP:");
        labelPedirIp.setToolTipText("label pidiendo la IP");

        panelIps.setLayout(new java.awt.GridBagLayout());

        label1Punto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label1Punto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1Punto.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        panelIps.add(label1Punto, gridBagConstraints);

        label2Punto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label2Punto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2Punto.setText(".");
        label2Punto.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        panelIps.add(label2Punto, gridBagConstraints);

        label3Punto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label3Punto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3Punto.setText(".");
        label3Punto.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        panelIps.add(label3Punto, gridBagConstraints);

        buttonIngresarIP.setText("Ingresar IP");
        buttonIngresarIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIps, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(labelPedirIp, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(buttonIngresarIP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelPedirIp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelIps, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(buttonIngresarIP)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIngresarIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarIPActionPerformed
        // TODO add your handling code here:
        if(textCampo1.getText().equals("")||textCampo2.getText().equals("")||textCampo3.getText().equals("")||textCampo4.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Existen campos vacios, debe completarlos", "ERROR de lectura", 1);
        }else{
        direccionIP[0]=Integer.parseInt(textCampo1.getText().trim());
        direccionIP[1]=Integer.parseInt(textCampo2.getText().trim());
        direccionIP[2]=Integer.parseInt(textCampo3.getText().trim());
        direccionIP[3]=Integer.parseInt(textCampo4.getText().trim());
        info.asignarIP(direccionIP);
        info.activarMenus();
        this.setVisible(false);
        }
    }//GEN-LAST:event_buttonIngresarIPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonIngresarIP;
    private javax.swing.JLabel label1Punto;
    private javax.swing.JLabel label2Punto;
    private javax.swing.JLabel label3Punto;
    private javax.swing.JLabel labelPedirIp;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelIps;
    // End of variables declaration//GEN-END:variables
}
