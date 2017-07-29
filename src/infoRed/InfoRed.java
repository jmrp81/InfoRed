
package infoRed;


/**
 * Interfaz grafica del programa InfoRed
 * @version 2013
 * @serial 1.0
 * @author Juan Manuel / Abraham Lopez
 */
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.help.*;
import java.net.*;
import javax.swing.JOptionPane;


public class InfoRed extends javax.swing.JFrame {
    //Atributos
    private PanelRed panelRed;
    private PanelRedes panelRedes;
    private CalcularSubredes calcularSubredes;
    private Fondo fondo;
    private Image icon;
    private HelpBroker hb;
    private TreeMap mapAdaptadores;
    private JMenuItem items;
    private ArrayList<String> array;
    private String[] adaptadores;
    private int[] direcIP;
    private int[] subred1;
    private int[] subred2;  
    private int[] subredFinal;
    private int bitsRobados;
    
    
    
    /**
     * Creates new form InfoRed
     */
    public InfoRed() {
        try {
            direcIP = new int[4];
            AdaptadoresFinal.IniciarAdaptadores();
            adaptadores = AdaptadoresFinal.nombreAdaptadores;
            mapAdaptadores = AdaptadoresFinal.Adaptadores;
            initComponents();
            cargaAyuda();
            icon = new ImageIcon(getClass().getResource("/infoRed/IconoPeq.jpg")).getImage();
            this.setIconImage(icon);
            this.setLocationRelativeTo(null);
            fondo = new Fondo();
            fondo.setSize(this.getSize()); 
            this.add(fondo);
            colocarBotonesAdaptadores();
        } catch (IOException ioe) {
            System.out.println("ERROR: al iniciar los adaptadores "+ioe);
        }
    }

    /**
     * Metodo para colocar item en el menu como adaptadores de red en el equipo
     */
    private void colocarBotonesAdaptadores(){
        for(int i=0;i<adaptadores.length;i++){
            if(adaptadores[i]!=null){
            items = new JMenuItem();
            if(i<10){
            int cod = 48+i;
            items.setAccelerator(javax.swing.KeyStroke.getKeyStroke(cod, java.awt.event.InputEvent.CTRL_MASK));
            }
            items.setName(adaptadores[i]);
            items.setText(adaptadores[i]);
            items.setToolTipText("Adaptador de red "+adaptadores[i]);
            items.setEnabled(true);
            items.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionItems(evt);
            }
        });
        menuAdaptadorRed.add(items);
        }
       }
    }
    
    /**
       * Metodo para cargar la ayuda en la aplicacion
       */
      private void cargaAyuda(){
        try{
        File fichero = new File("../Proyectos/src/infoRed/help/mi_helpSet.hs");
        URL hsURL = fichero.toURI().toURL();
        HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
        hb = helpset.createHelpBroker();
        hb.enableHelpOnButton(itemAyuda, "introduccion", helpset);
        hb.enableHelpKey(getRootPane(), "introduccion", helpset);
        hb.enableHelpKey(barraMenu.getComponent(), "menu", helpset);
        }catch(Exception exc){
        JOptionPane.showMessageDialog(this, "Fallo al cargar la ayuda", "Erro en la Ayuda", 1);
        }
    }
      
    /**
     * Metodo con la accion de cada item de los adaptadores
     */
    private void accionItems(java.awt.event.ActionEvent evt){
        JMenuItem itemPulsado = (JMenuItem) evt.getSource();
        String nombreItem = itemPulsado.getText();
        
        String informacion = (String) mapAdaptadores.get(nombreItem);
        textIP.setText("Adaptador --> "+nombreItem);
        textSalida.setText(informacion);
    }
    
    /**
     * Metodo para asignar valores a la direccion IP
     */
    public void asignarIP(int[] direccion){
        direcIP=direccion;
    }
    
    /**
     * Metodo para asignar valores a la subred1
     */
    public void asignarSubred1(int[] direccion){
        subred1=direccion;
    }
    
    /**
     * Metodo para asignar valores a la subred2
     */
    public void asignarSubred2(int[] direccion){
        subred2=direccion;
    }
    /**
     * Metodo para activar menus bloqueados 
     */
    public void activarMenus(){
        menuClaseRed.setEnabled(true);
        menuDireccionRed.setEnabled(true);
        menuMascaraRed.setEnabled(true);
        menuBroadcast.setEnabled(true);
        menuSubredes.setEnabled(true);
    }

    /**
     * Metodo para obtener el texto en la pantalla de salida
     * @return 
     */
    public String getTextSalida() {
        return textSalida.getText();
    }

    /**
     * Dar valor en el texto de salida
     * @param textSalida 
     */
    public void setTextSalida(String textoSalida) {
        textSalida.setText(textoSalida);
    }
    
    
    
    /**
     * Metodo para pedir una IP a traves de un JDialog
     */
    private void PedirIPCambioBase(){
        PedirIPCambioBase pedirIp = new PedirIPCambioBase(this,true);
        pedirIp.setVisible(true);
    }


    /**
     * Metodo dar valor a los bitsRobados
     * @param bitsRobados 
     */
    public void setBitsRobados(int bitsRobados) {
        this.bitsRobados = bitsRobados;
    }

    /**
     * Metodo para asignar el valor a la subredFinal
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

        panelPrincipal = new javax.swing.JPanel();
        panelSalida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSalida = new javax.swing.JTextArea();
        labelIP = new javax.swing.JLabel();
        textIP = new javax.swing.JTextField();
        barraMenu = new javax.swing.JMenuBar();
        menuAplicacion = new javax.swing.JMenu();
        menuSolicitarIp = new javax.swing.JMenuItem();
        separadorMenu = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        menuPreparacionRed = new javax.swing.JMenu();
        menuClaseRed = new javax.swing.JMenuItem();
        menuDireccionRed = new javax.swing.JMenuItem();
        menuMascaraRed = new javax.swing.JMenuItem();
        menuBroadcast = new javax.swing.JMenuItem();
        menuSubredes = new javax.swing.JMenuItem();
        menuNumHosts = new javax.swing.JMenuItem();
        menuGraficoRed = new javax.swing.JMenu();
        menuGraficoReds = new javax.swing.JMenuItem();
        menuCambiarBase = new javax.swing.JMenu();
        menu10_2 = new javax.swing.JMenuItem();
        menu2_10 = new javax.swing.JMenuItem();
        menu10_8 = new javax.swing.JMenuItem();
        menu8_10 = new javax.swing.JMenuItem();
        menu1016 = new javax.swing.JMenuItem();
        menu16_10 = new javax.swing.JMenuItem();
        menuAdaptadorRed = new javax.swing.JMenu();
        itemayuda = new javax.swing.JMenu();
        menuAcercaDe = new javax.swing.JMenuItem();
        itemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InfoRED");
        setMaximumSize(new java.awt.Dimension(800, 450));
        setMinimumSize(new java.awt.Dimension(800, 450));
        setPreferredSize(new java.awt.Dimension(800, 450));

        panelPrincipal.setMaximumSize(new java.awt.Dimension(800, 450));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(800, 450));
        panelPrincipal.setOpaque(false);

        panelSalida.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Información de Salida:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 204))); // NOI18N
        panelSalida.setForeground(new java.awt.Color(255, 255, 255));
        panelSalida.setToolTipText("Panel informativo con la informacion de la red");
        panelSalida.setOpaque(false);
        panelSalida.setLayout(new java.awt.GridLayout(1, 2));

        textSalida.setEditable(false);
        textSalida.setColumns(20);
        textSalida.setRows(5);
        textSalida.setToolTipText("Area de texto para mostrar la informacion sobre la red");
        textSalida.setBorder(null);
        jScrollPane1.setViewportView(textSalida);

        panelSalida.add(jScrollPane1);

        labelIP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelIP.setForeground(new java.awt.Color(255, 255, 204));
        labelIP.setText("Direccion IP introducida:");

        textIP.setEditable(false);
        textIP.setToolTipText("Campo de texto que muestra la IP introducida por teclado");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelIP)
                        .addGap(18, 18, 18)
                        .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIP)
                    .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        menuAplicacion.setMnemonic('A');
        menuAplicacion.setText("Aplicacion");
        menuAplicacion.setToolTipText("opcion menu abrir opciones de la aplicacion");

        menuSolicitarIp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuSolicitarIp.setMnemonic('I');
        menuSolicitarIp.setText("Solicitar IP");
        menuSolicitarIp.setToolTipText("Opcion para pedir una direccion IP");
        menuSolicitarIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSolicitarIpActionPerformed(evt);
            }
        });
        menuAplicacion.add(menuSolicitarIp);
        menuAplicacion.add(separadorMenu);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSalir.setMnemonic('S');
        menuSalir.setText("Salir");
        menuSalir.setToolTipText("Opcion cerrar aplicacion");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuAplicacion.add(menuSalir);

        barraMenu.add(menuAplicacion);

        menuPreparacionRed.setMnemonic('P');
        menuPreparacionRed.setText("Preparacion de la Red");
        menuPreparacionRed.setToolTipText("menu con informacion sobre la red");

        menuClaseRed.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuClaseRed.setText("Clase de Red");
        menuClaseRed.setToolTipText("Menu opcion que muestra la clase de red");
        menuClaseRed.setEnabled(false);
        menuClaseRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClaseRedActionPerformed(evt);
            }
        });
        menuPreparacionRed.add(menuClaseRed);

        menuDireccionRed.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuDireccionRed.setText("Direccion de Red");
        menuDireccionRed.setToolTipText("Menu de opcion direccion de red");
        menuDireccionRed.setEnabled(false);
        menuDireccionRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDireccionRedActionPerformed(evt);
            }
        });
        menuPreparacionRed.add(menuDireccionRed);

        menuMascaraRed.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuMascaraRed.setText("Mascara de Red");
        menuMascaraRed.setToolTipText("Menu mascara de red");
        menuMascaraRed.setEnabled(false);
        menuMascaraRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMascaraRedActionPerformed(evt);
            }
        });
        menuPreparacionRed.add(menuMascaraRed);

        menuBroadcast.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menuBroadcast.setText("Direccion de Broadcast");
        menuBroadcast.setToolTipText("Menu muestra direccion broadcast");
        menuBroadcast.setEnabled(false);
        menuBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBroadcastActionPerformed(evt);
            }
        });
        menuPreparacionRed.add(menuBroadcast);

        menuSubredes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSubredes.setText("Numero de Subredes");
        menuSubredes.setToolTipText("menu indica numero de subredes");
        menuSubredes.setEnabled(false);
        menuSubredes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSubredesActionPerformed(evt);
            }
        });
        menuPreparacionRed.add(menuSubredes);

        menuNumHosts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuNumHosts.setText("Numero de Hosts");
        menuNumHosts.setToolTipText("Menu opcion muestra numero de hosts");
        menuNumHosts.setEnabled(false);
        menuNumHosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNumHostsActionPerformed(evt);
            }
        });
        menuPreparacionRed.add(menuNumHosts);

        barraMenu.add(menuPreparacionRed);

        menuGraficoRed.setMnemonic('G');
        menuGraficoRed.setText("Grafico de la Red");
        menuGraficoRed.setToolTipText("menu con opciones para mostrar graficamente la red");

        menuGraficoReds.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menuGraficoReds.setText("Grafico de la Red");
        menuGraficoReds.setToolTipText("Opcion de menu que muestra la grafica de la red");
        menuGraficoReds.setEnabled(false);
        menuGraficoReds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGraficoRedsActionPerformed(evt);
            }
        });
        menuGraficoRed.add(menuGraficoReds);

        barraMenu.add(menuGraficoRed);

        menuCambiarBase.setMnemonic('C');
        menuCambiarBase.setText("Cambiar de Base");
        menuCambiarBase.setToolTipText("Menu con diferentes opciones de cambio de base");

        menu10_2.setText("10 --> 2");
        menu10_2.setToolTipText("Opcion del menu cambio de base de decimal a binario");
        menu10_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu10_2ActionPerformed(evt);
            }
        });
        menuCambiarBase.add(menu10_2);

        menu2_10.setText("2 --> 10");
        menu2_10.setToolTipText("Opcion del menu cambio de base de  binario a decimal");
        menu2_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2_10ActionPerformed(evt);
            }
        });
        menuCambiarBase.add(menu2_10);

        menu10_8.setText("10 --> 8");
        menu10_8.setToolTipText("Opcion del menu cambio de base de decimal a octal");
        menu10_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu10_8ActionPerformed(evt);
            }
        });
        menuCambiarBase.add(menu10_8);

        menu8_10.setText("8 --> 10");
        menu8_10.setToolTipText("Opcion del menu cambio de base de octal a decimal ");
        menu8_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu8_10ActionPerformed(evt);
            }
        });
        menuCambiarBase.add(menu8_10);

        menu1016.setText("10 --> 16");
        menu1016.setToolTipText("Opcion del menu cambio de base de decimal a hexadecimal");
        menu1016.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1016ActionPerformed(evt);
            }
        });
        menuCambiarBase.add(menu1016);

        menu16_10.setText("16 --> 10");
        menu16_10.setToolTipText("Opcion del menu cambio de base de hexadecimal a decimal ");
        menu16_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu16_10ActionPerformed(evt);
            }
        });
        menuCambiarBase.add(menu16_10);

        barraMenu.add(menuCambiarBase);

        menuAdaptadorRed.setMnemonic('R');
        menuAdaptadorRed.setText("Adaptadores de Red");
        menuAdaptadorRed.setToolTipText("Menu con diferentes adaptadores de red");
        barraMenu.add(menuAdaptadorRed);

        itemayuda.setMnemonic('y');
        itemayuda.setText("Ayuda");
        itemayuda.setToolTipText("Menu que abre las opciones de ayuda");

        menuAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuAcercaDe.setText("Acerca De");
        menuAcercaDe.setToolTipText("Opcion del menu ayuda que muestra el Acerca De");
        menuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaDeActionPerformed(evt);
            }
        });
        itemayuda.add(menuAcercaDe);

        itemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        itemAyuda.setMnemonic('y');
        itemAyuda.setText("Ayuda");
        itemAyuda.setToolTipText("Opcion del menu que abre la ayuda");
        itemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAyudaActionPerformed(evt);
            }
        });
        itemayuda.add(itemAyuda);

        barraMenu.add(itemayuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo del boton salir del menu para cerrar la aplicacion
     * @param evt 
     */
    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    /**
     * Metodo que lleva a cabo la accion del item menu Clase de red
     * @param evt 
     */
    private void menuClaseRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClaseRedActionPerformed
        try {
            // TODO add your handling code here:
            textSalida.setText("La ip es de clase. \n"+CalculoIP.tipoRed(direcIP));
        } catch (FueraDeRangoException ex) {
            textSalida.setText("La IP introducida esta fuera de rango; introducir una IP nueva."+ex);
        }
    }//GEN-LAST:event_menuClaseRedActionPerformed

    /**
     * Metodo de la accion del item menu mascara de red
     * @param evt 
     */
    private void menuMascaraRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMascaraRedActionPerformed
        try {
            // TODO add your handling code here:
            textSalida.setText("Mascara de Red: \n"+CalculoIP.mostrarMascara(CalculoIP.tipoRed(direcIP)));
        } catch (TipoRedInvalidoException ex) {
            textSalida.setText("ERROR: Red invalida"+ex);
        } catch (FueraDeRangoException ex) {
            textSalida.setText("La IP introducida esta fuera de rango; introducir una IP nueva."+ex);
        }
    }//GEN-LAST:event_menuMascaraRedActionPerformed

    /**
     * Metodo de la accion del item menu Broadcast
     * @param evt 
     */
    private void menuBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBroadcastActionPerformed
        try {
            // TODO add your handling code here:
            textSalida.setText("Direccion de Broadcast: \n"+CalculoIP.mostrarDireccionBroadcast(direcIP));
        } catch (TipoRedInvalidoException ex) {
            textSalida.setText("ERROR: Red invalida"+ex);
        } catch (FueraDeRangoException ex) {
            textSalida.setText("La IP introducida esta fuera de rango; introducir una IP nueva."+ex);
        }
    }//GEN-LAST:event_menuBroadcastActionPerformed

    /**
     * Metodo de la accion del item menu direccion de red
     * @param evt 
     */
    private void menuDireccionRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDireccionRedActionPerformed
        try {
            // TODO add your handling code here:
            textSalida.setText("Direccion red de la IP introducida: \n"+CalculoIP.mostrarDireccionRed(direcIP));
        } catch (TipoRedInvalidoException ex) {
            textSalida.setText("ERROR: Red invalida"+ex);
        } catch (FueraDeRangoException ex) {
            textSalida.setText("La IP introducida esta fuera de rango; introducir una IP nueva."+ex);
        }
    }//GEN-LAST:event_menuDireccionRedActionPerformed

    private void menu2_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2_10ActionPerformed
        // TODO add your handling code here:
        PedirIPCambioBase();
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("Direccion IP en decimal:\n"+CambioBases.binarioDecimal(String.valueOf(direcIP[0]),String.valueOf(direcIP[1]), String.valueOf(direcIP[2]), String.valueOf(direcIP[3])));
    }//GEN-LAST:event_menu2_10ActionPerformed

    private void menu10_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu10_8ActionPerformed
        // TODO add your handling code here:
        PedirIPCambioBase();
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("Direccion IP en decimal:\nEn construccion esta opcion");
        
    }//GEN-LAST:event_menu10_8ActionPerformed

    private void itemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemAyudaActionPerformed

    private void menu8_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu8_10ActionPerformed
        // TODO add your handling code here:
        PedirIPCambioBase();
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("Direccion IP en decimal:\nEn construccion esta opcion");
    }//GEN-LAST:event_menu8_10ActionPerformed

    /**
     * Metodo de la opcion pedir nueva IP
     * @param evt 
     */
    private void menuSolicitarIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSolicitarIpActionPerformed
        // TODO add your handling code here:
        PedirIP pedirIp = new PedirIP(this,true);
        pedirIp.setVisible(true);
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("");
    }//GEN-LAST:event_menuSolicitarIpActionPerformed

    /**
     * Accion del item menu AcercaDe
     * @param evt 
     */
    private void menuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaDeActionPerformed
        // TODO add your handling code here:
        AcercaDe acercaDe = new AcercaDe(this,true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_menuAcercaDeActionPerformed

    /**
     * Metodo para pedir subredes y calacular el numero de hosts
     * @param evt 
     */
    private void menuNumHostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNumHostsActionPerformed
        // TODO add your handling code here:
        PedirSubredes pedirSub = new PedirSubredes(this,true);
        pedirSub.setVisible(true);
        textIP.setText("Subred1: "+subred1[0]+"."+subred1[1]+"."+subred1[2]+"."+subred1[3]+"    /Subred2: "+subred2[0]+"."+subred2[1]+"."+subred2[2]+"."+subred2[3]);

        
        
        try {
            array =(ArrayList) Host.listartodosHosts(subred1, subred2);
            Iterator elemento = array.iterator();
            
            String salida="Hosts de la subred1: "+subred1[0]+"."+subred1[1]+"."+subred1[2]+"."+subred1[3];
         
            
            int cont=0;
            while(elemento.hasNext()){
                String host = (String) elemento.next();
                salida+="\nHost nº"+cont+": "+host;
                cont++;
            }
                textSalida.setText(salida);
            
        } catch (Exception ex) {
                textSalida.setText("ERROR: al calcular numero de hosts, posible error en subredes. "+ex);         
        }
        
    }//GEN-LAST:event_menuNumHostsActionPerformed

    private void menu10_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu10_2ActionPerformed
        // TODO add your handling code here:
        PedirIPCambioBase();
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("Direccion IP en binario:\n"+CambioBases.decimalBinario(String.valueOf(direcIP[0]),String.valueOf(direcIP[1]), String.valueOf(direcIP[2]), String.valueOf(direcIP[3])));

    }//GEN-LAST:event_menu10_2ActionPerformed

    private void menu1016ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1016ActionPerformed
        // TODO add your handling code here:
        PedirIPCambioBase();
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("Direccion IP en hexadecimal:\n"+CambioBases.decimalHexadecimal(String.valueOf(direcIP[0]),String.valueOf(direcIP[1]), String.valueOf(direcIP[2]), String.valueOf(direcIP[3])));
    }//GEN-LAST:event_menu1016ActionPerformed

    private void menu16_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu16_10ActionPerformed
        // TODO add your handling code here:
        PedirIPCambioBase();
        textIP.setText(direcIP[0]+"."+direcIP[1]+"."+direcIP[2]+"."+direcIP[3]);
        textSalida.setText("Direccion IP en decimal:\n"+CambioBases.hexadecimalDecimal(String.valueOf(direcIP[0]),String.valueOf(direcIP[1]), String.valueOf(direcIP[2]), String.valueOf(direcIP[3])));
    }//GEN-LAST:event_menu16_10ActionPerformed

    /**
     * Metodo para mostrar diferentes subredes de una ip segun los bits a robar
     * @param evt 
     */
    private void menuSubredesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSubredesActionPerformed
        PedirDatosIpBitsRobados robados = new PedirDatosIpBitsRobados(this, true);
        robados.setVisible(true);
        calcularSubredes = new CalcularSubredes(this,direcIP, bitsRobados);
        calcularSubredes.mostrarSubredes();
        menuNumHosts.setEnabled(true);
        menuGraficoReds.setEnabled(true);
    }//GEN-LAST:event_menuSubredesActionPerformed

   /**
    * Accion del item menu grafico
    * @param evt 
    */
    private void menuGraficoRedsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGraficoRedsActionPerformed
        try {
            panelRedes = new PanelRedes(calcularSubredes.getSubredes());
            panelRedes.setSubredFinal(subredFinal);
             JDialog dialogo = new JDialog();
             dialogo.add(panelRedes);
             dialogo.setSize(600, 300);
             dialogo.setLocationRelativeTo(null); 
             dialogo.setVisible(true);
        } catch (Exception ex) {
            textSalida.setText("ERROR: al preparar panel de subredes al obtener la lista de ips"+ex); 
        }
    }//GEN-LAST:event_menuGraficoRedsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InfoRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InfoRed().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JMenu itemayuda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIP;
    private javax.swing.JMenuItem menu1016;
    private javax.swing.JMenuItem menu10_2;
    private javax.swing.JMenuItem menu10_8;
    private javax.swing.JMenuItem menu16_10;
    private javax.swing.JMenuItem menu2_10;
    private javax.swing.JMenuItem menu8_10;
    private javax.swing.JMenuItem menuAcercaDe;
    private javax.swing.JMenu menuAdaptadorRed;
    private javax.swing.JMenu menuAplicacion;
    private javax.swing.JMenuItem menuBroadcast;
    private javax.swing.JMenu menuCambiarBase;
    private javax.swing.JMenuItem menuClaseRed;
    private javax.swing.JMenuItem menuDireccionRed;
    private javax.swing.JMenu menuGraficoRed;
    private javax.swing.JMenuItem menuGraficoReds;
    private javax.swing.JMenuItem menuMascaraRed;
    private javax.swing.JMenuItem menuNumHosts;
    private javax.swing.JMenu menuPreparacionRed;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuSolicitarIp;
    private javax.swing.JMenuItem menuSubredes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSalida;
    private javax.swing.JPopupMenu.Separator separadorMenu;
    private javax.swing.JTextField textIP;
    private javax.swing.JTextArea textSalida;
    // End of variables declaration//GEN-END:variables
}
