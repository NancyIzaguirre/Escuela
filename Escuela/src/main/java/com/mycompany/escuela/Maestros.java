
package com.mycompany.escuela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Maestros extends JFrame{

public JPanel panel;
    File archivo;
    JTextField id_maestro = new JTextField(""); 
    JTextField mnombre = new JTextField(); 
    JTextField mtelefono = new JTextField("");
    JTextField mdireccion = new JTextField("");
    JTextField medad = new JTextField("");
    JTextField msexo = new JTextField("");
    JTextField mprofesion = new JTextField(""); 
     
     
    public Maestros(){
        setSize(800,500);//Establecemos el tamaño de la pantalla
        setLocationRelativeTo(null);//Centrado de la pantalla
        setTitle("Maestros "); // Establecemos
        // el titulo
        panelDatos(); // Llamdo del metodo Panel
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Finalizar la ejecucion
         //del programa cuando se cierre la ventana
    }
    private void panelDatos(){
       // Llamado de metodos
       DefinirPanel();
       DefinirBotones();
       //       
    }
    
    private void DefinirPanel(){
        // Definicion del panel
        panel = new JPanel(); // Creacion del panel
        panel.setLayout(null); // Desactivando el diseño
        this.getContentPane().add(panel);// Agregar el panel a la ventana
        
    }
    
    private void DefinirBotones(){

        
        JButton bAltas = new JButton("Maestros");
        bAltas.setBounds(50,50,100,40);
        bAltas.setEnabled(true);
        // Agregando ActionListener
        ActionListener EventoAltas = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
         //Llamado de metodos
        DefinirCajasTextos();
        Etiquetas();
         Maestros Maestros1 =new Maestros();
       }
      };
        
        bAltas.addActionListener(EventoAltas);
        
       JButton bGuardar = new JButton("Guardar");
        bGuardar.setBounds(50,400,100,40);
        // Se agrega el ActionListener
        ActionListener EventoGuardar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
        EscribirSQL();
        Borrar();
        }
         };
        
        bGuardar.addActionListener(EventoGuardar);
        
        JButton bBuscar = new JButton("Buscar");
        bBuscar.setBounds(170,400,100,40);
        bBuscar.setEnabled(true);
         //Se agrega el ActionListener
        ActionListener EventoBusqueda = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
        
        JOptionPane.showMessageDialog(null, "La búsqueda no fue exitosa.");
        }
         };
        
        bBuscar.addActionListener(EventoBusqueda);
        
        JButton bSalir2 = new JButton("Borrar");
        bSalir2.setBounds(290,400,100,40);
        bSalir2.setEnabled(true); 
         //Agragando el ActionListener
        ActionListener EventoSalir2 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
        
        JOptionPane.showMessageDialog(null, "Está seguro de borrar el formulario, y el nombre del estudiante.");
        }
         };
        
        bSalir2.addActionListener(EventoSalir2);
         //Se agregan los botones al panel

          panel.add(bAltas);
          panel.add(bGuardar);
          panel.add(bBuscar);
          panel.add(bSalir2);
    }
    private void DefinirCajasTextos(){
        // Creacion de botones y asignación de texto
        mnombre.setBounds(170,100,400,40);
        mnombre.setFont(new Font("arial",Font.BOLD,12));
        mnombre.setForeground(Color.black);
        
        id_maestro.setBounds(170,50,400,40);
        
        mtelefono.setBounds(170,150,400,40);
        
        mdireccion.setBounds(170,200,400,40);
        mdireccion.setEnabled(true); 
        
        medad.setBounds(170,250,400,40);
        
        msexo.setBounds(170,300,400,40);
        
        
        mprofesion.setBounds(170,350,400,40);
        // Se agregan los botones al panel
        panel.add(id_maestro);
        panel.add(mnombre);
        panel.add(mtelefono);
        panel.add(mdireccion);
        panel.add(medad);
        panel.add(msexo);
        panel.add(mprofesion);
    }

    
     private void EscribirSQL(){
        
       
        CConexion cc = new CConexion();
        Connection con = cc.estableceConexion();
        String sql="";
        JOptionPane.showMessageDialog(null,"se conecto exitosamente");
        
        sql="INSERT INTO Maestros (id_maestro,mnombre,mtelefono,mdireccion, medad, msexo,mprofesion) VALUES (?,?,?,?,?,?,?)";
        try {
                PreparedStatement pst = con.prepareStatement(sql);
                //
                String stid_maestro = (id_maestro.getText());
                pst.setString(1, stid_maestro);
                System.out.println(""+stid_maestro);
                //
                String stmnombre = (mnombre.getText());
                pst.setString(2, stmnombre);
                System.out.println(""+stmnombre);
                //
                String stmtelefono = (mtelefono.getText());
                pst.setString(3, stmtelefono);
                System.out.println(""+stmtelefono);
                // 
                String stmdireccion = (mdireccion.getText());
                pst.setString(4, stmdireccion);
                System.out.println(""+stmdireccion);
                //
                String stmedad = (medad.getText());
                pst.setString(5, stmedad);
                System.out.println(""+stmedad);
                //
                String stmsexo = (msexo.getText());
                pst.setString(6, stmsexo);
                System.out.println(""+stmsexo);
                //
                String stmprofesion = (mprofesion.getText());
                pst.setString(7, stmprofesion);
                System.out.println(""+stmprofesion);
                //
                int num1 = pst.executeUpdate();
                if (num1>0){
                    JOptionPane.showMessageDialog(null,"Registros Guardados");
                    System.out.println("Texto añadido");
                }
                //
        } catch (SQLException ex) {
                Logger.getLogger(altas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Registros No Guardados");
                System.out.println("Texto No añadido");
        }
             
    } 
        
    private void Etiquetas (){
         JLabel id_maestro = new JLabel("Maestro"); // Creamos una etiqueta
       id_maestro.setBounds(600,50,100,40); // Se define el tamaño 
       //de la etiqueta
       id_maestro.setHorizontalAlignment(SwingConstants.CENTER);
        //Se define la alineación del texto de la etiqueta
       id_maestro.setForeground(Color.black); // Se establece el color de la 
        //etiqueta
       id_maestro.setOpaque(true); // Se establece que el fondo de la 
        //etiqueta se pueda cambiar de color
       id_maestro.setBackground(Color.white);// Se establece el color de fondo
        //de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       id_maestro.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       
       JLabel mnombre = new JLabel("Nombre"); // Creamos una etiqueta
       mnombre.setBounds(600,100,100,40); // Se define el tamaño 
       //de la etiqueta
       mnombre.setHorizontalAlignment(SwingConstants.CENTER);
        //Se define la alineación del texto de la etiqueta
       mnombre.setForeground(Color.black); // Se establece el color de la 
        //etiqueta
       mnombre.setOpaque(true); // Se establece que el fondo de la 
        //etiqueta se pueda cambiar de color
       mnombre.setBackground(Color.white);// Se establece el color de fondo
        //de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       mnombre.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel mtelefono = new JLabel("Telefono"); // Creamos una etiqueta
       mtelefono.setBounds(600,150,100,40); // Se define el tamaño 
//       de la etiqueta
       mtelefono.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       mtelefono.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       mtelefono.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       mtelefono.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       mtelefono.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel mdireccion = new JLabel("Direccion"); // Creamos una etiqueta
       mdireccion.setBounds(600,200,100,40); // Se define el tamaño 
//       de la etiqueta
       mdireccion.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       mdireccion.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       mdireccion.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       mdireccion.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       mdireccion.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel medad = new JLabel("Edad"); // Creamos una etiqueta
       medad.setBounds(600,250,100,40); // Se define el tamaño 
//       de la etiqueta
       medad.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       medad.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       medad.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       medad.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       medad.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel msexo = new JLabel("sexo"); // Creamos una etiqueta
       msexo.setBounds(600,300,100,40); // Se define el tamaño 
//       de la etiqueta
       msexo.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       msexo.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       msexo.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       msexo.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       msexo.setFont(new Font("arial",Font.BOLD,12));
//        Se agregan etiquetas al panel

       JLabel mprofesion = new JLabel("Profesion"); // Creamos una etiqueta
       mprofesion.setBounds(600,350,100,40); // Se define el tamaño 
//       de la etiqueta
       mprofesion.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       mprofesion.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       mprofesion.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       mprofesion.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       mprofesion.setFont(new Font("arial",Font.BOLD,12));
//        Se agregan etiquetas al panel



       panel.add(id_maestro);
       panel.add(mnombre);
       panel.add(mtelefono);
       panel.add(mdireccion);
       panel.add(medad);
       panel.add(msexo);
       panel.add(mprofesion);
    }
         private void Borrar(){
        
       
        CConexion cc = new CConexion();
        Connection con = cc.estableceConexion();
        String Borrar="";
        
        
        Borrar="DELETE FROM altas (id_alumno) VALUES (?)";

                    JOptionPane.showMessageDialog(null,"Registros Borrados");
               
      

     
        
     }
}    


    
