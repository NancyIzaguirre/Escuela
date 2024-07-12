
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

public class Materias extends JFrame{
    public JPanel panel;
    File archivo;
    JTextField id_materia = new JTextField(""); 
    JTextField materia = new JTextField(); 
    JTextField horas = new JTextField("");
    JTextField gradomat = new JTextField("");
       
    public Materias(){
        setSize(800,500);//Establecemos el tamaño de la pantalla
        setLocationRelativeTo(null);//Centrado de la pantalla
        setTitle("Materias "); // Establecemos
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
// Definicion de los botones
        
        JButton bAltas = new JButton("Materias ");
        bAltas.setBounds(50,50,100,40);
        bAltas.setEnabled(true);
        // Agregando ActionListener
        ActionListener EventoAltas = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
         //Llamado de metodos
        DefinirCajasTextos();
        Etiquetas();
        altas altas1 =new altas();
        //visibilizar ventana altas
//        Altas1.setVisible(true);
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
//        Borrar();
        //
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
//        Borrar();
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
        id_materia.setBounds(170,50,400,40);
        id_materia.setFont(new Font("arial",Font.BOLD,12));
        id_materia.setForeground(Color.black);
        
        id_materia.setBounds(170,50,400,40);
        
        materia.setBounds(170,100,400,40);
        
        horas.setBounds(170,150,400,40);
        horas.setEnabled(true); 
        
        gradomat.setBounds(170,200,400,40);
        
        // Se agregan los botones al panel
        panel.add(id_materia);
        panel.add(materia);
        panel.add(horas);
        panel.add(gradomat);
    }
    
//     private void Borrar(){
//        
//       
//        CConexion cc = new CConexion();
//        Connection con = cc.estableceConexion();
//        String Borrar="";
//        
//        
//        Borrar="DELETE FROM altas (id_alumno) VALUES (?)";
//
//                    JOptionPane.showMessageDialog(null,"Registros Borrados");
//               
//      
//
//     
//        
//     }
    private void EscribirSQL(){
        
       
        CConexion cc = new CConexion();
        Connection con = cc.estableceConexion();
        String sql="";
        JOptionPane.showMessageDialog(null,"se conecto exitosamente");
        
        sql="INSERT INTO Materias (id_materia,materia,horas,gradomat) VALUES (?,?,?,?)";
        try {
                PreparedStatement pst = con.prepareStatement(sql);
                //
                String stid_materia = (id_materia.getText());
                pst.setString(1, stid_materia);
                System.out.println(""+stid_materia);
                //
                String stmateria = (materia.getText());
                pst.setString(2, stmateria);
                System.out.println(""+stmateria);
                //
                String sthoras = (horas.getText());
                pst.setString(3, sthoras);
                System.out.println(""+sthoras);
                // 
                String stgradomat = (gradomat.getText());
                pst.setString(4, stgradomat);
                System.out.println(""+stgradomat);
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
         JLabel id_materia = new JLabel("ID Materia"); // Creamos una etiqueta
       id_materia.setBounds(600,50,100,40); // Se define el tamaño 
       //de la etiqueta
       id_materia.setHorizontalAlignment(SwingConstants.CENTER);
        //Se define la alineación del texto de la etiqueta
       id_materia.setForeground(Color.black); // Se establece el color de la 
        //etiqueta
       id_materia.setOpaque(true); // Se establece que el fondo de la 
        //etiqueta se pueda cambiar de color
       id_materia.setBackground(Color.white);// Se establece el color de fondo
        //de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       id_materia.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       
       JLabel materia = new JLabel("Materia"); // Creamos una etiqueta
       materia.setBounds(600,100,100,40); // Se define el tamaño 
       //de la etiqueta
       materia.setHorizontalAlignment(SwingConstants.CENTER);
        //Se define la alineación del texto de la etiqueta
       materia.setForeground(Color.black); // Se establece el color de la 
        //etiqueta
       materia.setOpaque(true); // Se establece que el fondo de la 
        //etiqueta se pueda cambiar de color
       materia.setBackground(Color.white);// Se establece el color de fondo
        //de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       materia.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel horas = new JLabel("Horas"); // Creamos una etiqueta
       horas.setBounds(600,150,100,40); // Se define el tamaño 
//       de la etiqueta
       horas.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       horas.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       horas.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       horas.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       horas.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel gradomat = new JLabel("grados"); // Creamos una etiqueta
       gradomat.setBounds(600,200,100,40); // Se define el tamaño 
//       de la etiqueta
       gradomat.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       gradomat.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       gradomat.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       gradomat.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       gradomat.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
     
       panel.add(id_materia);
       panel.add(materia);
       panel.add(horas);
       panel.add(gradomat);
    }
}