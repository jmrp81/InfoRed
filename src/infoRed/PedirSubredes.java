package infoRed;

import java.awt.GridBagConstraints;
import javax.swing.JOptionPane;


/**
 * Interfaz para pedir la direccion IP
 * @version 2013
 * @serial 1.0
 * @author Juan Manuel / Abraham Lopez
 */
public class PedirSubredes extends javax.swing.JDialog {
    //Atributos
    private InfoRed info;
    private int[] direccionIP1;
    private int[] direccionIP2;
    private GridBagConstraints gridBagConstraints;
    private javax.swing.JTextField textCampo1;
    private javax.swing.JTextField textCampo2;
    private javax.swing.JTextField textCampo3;
    private javax.swing.JTextField textCampo4;
    private javax.swing.JTextField textCampo5;
    private javax.swing.JTextField textCampo6;
    private javax.swing.JTextField textCampo7;
    private javax.swing.JTextField textCampo8;
    
    /**
     * Creates new form PedirSubredes
     * @param parent
     * @param modal
     */
    public PedirSubredes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        info = (InfoRed) parent;
        initComponents();
        this.setLocationRelativeTo(null);
        direccionIP1=new int[4];
        direccionIP2=new int[4];
        crearTextFields();
    }
    
        /**
         * Metodo para crear los botones
         */
        private void crearTextFields(){
            textCampo1 = new javax.swing.JTextField(1);
            textCampo1.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo1.setDocument(new JTextFieldLimit(3));
            textCampo2 = new javax.swing.JTextField(1);
            textCampo2.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo2.setDocument(new JTextFieldLimit(3));
            textCampo3 = new javax.swing.JTextField(1);
            textCampo3.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo3.setDocument(new JTextFieldLimit(3));
            textCampo4 = new javax.swing.JTextField(1);
            textCampo4.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo4.setDocument(new JTextFieldLimit(3));
            
            textCampo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo1.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo1.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo1.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo1.setToolTipText("campo 1 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo1, gridBagConstraints);

            textCampo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo2.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo2.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo2.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo2.setToolTipText("campo 2 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo2, gridBagConstraints);

            textCampo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo3.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo3.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo3.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo3.setToolTipText("campo 3 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 8;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo3, gridBagConstraints);

            textCampo4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo4.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo4.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo4.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo4.setToolTipText("campo 4 de la direccion ip");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 12;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps.add(textCampo4, gridBagConstraints);
           
            
            textCampo5 = new javax.swing.JTextField(1);
            textCampo5.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo5.setDocument(new JTextFieldLimit(3));
            textCampo6 = new javax.swing.JTextField(1);
            textCampo6.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo6.setDocument(new JTextFieldLimit(3));
            textCampo7 = new javax.swing.JTextField(1);
            textCampo7.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo7.setDocument(new JTextFieldLimit(3));
            textCampo8 = new javax.swing.JTextField(1);
            textCampo8.setFont(new java.awt.Font("Tahoma", 1, 12));
            textCampo8.setDocument(new JTextFieldLimit(3));
            
            textCampo5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo5.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo5.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo5.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo5.setToolTipText("campo 1 de la subred2");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps1.add(textCampo5, gridBagConstraints);

            textCampo6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo6.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo6.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo6.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo6.setToolTipText("campo 2 de la subred2");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps1.add(textCampo6, gridBagConstraints);

            textCampo7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo7.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo7.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo7.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo7.setToolTipText("campo 3 de la subred2");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 8;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps1.add(textCampo7, gridBagConstraints);

            textCampo8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            textCampo8.setMaximumSize(new java.awt.Dimension(33, 23));
            textCampo8.setMinimumSize(new java.awt.Dimension(33, 23));
            textCampo8.setPreferredSize(new java.awt.Dimension(33, 23));
            textCampo8.setToolTipText("campo 4 de la subred2");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridwidth = 3;
            gridBagConstraints.ipadx = 12;
            gridBagConstraints.ipady = 3;
            gridBagConstraints.gridx = 12;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            panelIps1.add(textCampo8, gridBagConstraints);
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
        labelPedirSubred1 = new javax.swing.JLabel();
        panelIps = new javax.swing.JPanel();
        label1Punto = new javax.swing.JLabel();
        label2Punto = new javax.swing.JLabel();
        label3Punto = new javax.swing.JLabel();
        buttonIngresarSubredes = new javax.swing.JButton();
        panelIps1 = new javax.swing.JPanel();
        label1Punto1 = new javax.swing.JLabel();
        label2Punto1 = new javax.swing.JLabel();
        label3Punto1 = new javax.swing.JLabel();
        labelPedirSubred2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Introducir Subredes");
        setMaximumSize(new java.awt.Dimension(370, 249));
        setMinimumSize(new java.awt.Dimension(370, 249));
        setResizable(false);

        panelContenedor.setToolTipText("Panel contenedor de pedir la IP");
        panelContenedor.setMaximumSize(new java.awt.Dimension(300, 200));
        panelContenedor.setMinimumSize(new java.awt.Dimension(300, 200));
        panelContenedor.setPreferredSize(new java.awt.Dimension(300, 200));

        labelPedirSubred1.setText("Introducir la subred 1 de la que se calcula nº de hosts:");
        labelPedirSubred1.setToolTipText("label pidiendo la IP");

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

        buttonIngresarSubredes.setText("Ingresar Subredes");
        buttonIngresarSubredes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarSubredesActionPerformed(evt);
            }
        });

        panelIps1.setLayout(new java.awt.GridBagLayout());

        label1Punto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label1Punto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1Punto1.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        panelIps1.add(label1Punto1, gridBagConstraints);

        label2Punto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label2Punto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2Punto1.setText(".");
        label2Punto1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        panelIps1.add(label2Punto1, gridBagConstraints);

        label3Punto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label3Punto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3Punto1.setText(".");
        label3Punto1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        panelIps1.add(label3Punto1, gridBagConstraints);

        labelPedirSubred2.setText("Introducir la subred 2:");
        labelPedirSubred2.setToolTipText("label pidiendo la IP");

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonIngresarSubredes)
                .addGap(101, 101, 101))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIps1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(labelPedirSubred2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 115, Short.MAX_VALUE))
                    .addComponent(labelPedirSubred1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelPedirSubred1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelIps, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPedirSubred2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(panelIps1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonIngresarSubredes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIngresarSubredesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarSubredesActionPerformed
        // TODO add your handling code here:
        if(textCampo1.getText().equals("")||textCampo2.getText().equals("")||textCampo3.getText().equals("")||textCampo4.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Existen campos vacios, debe completarlos en la subred1", "ERROR de lectura", 1);
        }else{
        direccionIP1[0]=Integer.parseInt(textCampo1.getText().trim());
        direccionIP1[1]=Integer.parseInt(textCampo2.getText().trim());
        direccionIP1[2]=Integer.parseInt(textCampo3.getText().trim());
        direccionIP1[3]=Integer.parseInt(textCampo4.getText().trim());
        info.asignarSubred1(direccionIP1);
        this.setVisible(false);
        }
        
        if(textCampo5.getText().equals("")||textCampo6.getText().equals("")||textCampo7.getText().equals("")||textCampo8.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Existen campos vacios, debe completarlos en la subred2", "ERROR de lectura", 1);
        }else{
        direccionIP2[0]=Integer.parseInt(textCampo5.getText().trim());
        direccionIP2[1]=Integer.parseInt(textCampo6.getText().trim());
        direccionIP2[2]=Integer.parseInt(textCampo7.getText().trim());
        direccionIP2[3]=Integer.parseInt(textCampo8.getText().trim());
        info.asignarSubred2(direccionIP2);
        this.setVisible(false);
        }
    }//GEN-LAST:event_buttonIngresarSubredesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonIngresarSubredes;
    private javax.swing.JLabel label1Punto;
    private javax.swing.JLabel label1Punto1;
    private javax.swing.JLabel label2Punto;
    private javax.swing.JLabel label2Punto1;
    private javax.swing.JLabel label3Punto;
    private javax.swing.JLabel label3Punto1;
    private javax.swing.JLabel labelPedirSubred1;
    private javax.swing.JLabel labelPedirSubred2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelIps;
    private javax.swing.JPanel panelIps1;
    // End of variables declaration//GEN-END:variables
}
