
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

public class altas extends JFrame{
    public JPanel panel;
    File archivo;
    JTextField id_alumno = new JTextField(""); 
    JTextField nombre = new JTextField(); 
    JTextField telefono = new JTextField("");
    JTextField direccion = new JTextField("");
    JTextField edad = new JTextField("");
    JTextField sexo = new JTextField("");
    JTextField ciclo = new JTextField(""); 
     
     
    public altas(){
        setSize(800,500);//Establecemos el tamaño de la pantalla
        setLocationRelativeTo(null);//Centrado de la pantalla
        setTitle("Alumnos "); // Establecemos
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
        
        JButton bAltas = new JButton("Alumnos");
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
        Borrar();
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
        Borrar();
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
        nombre.setBounds(170,100,400,40);
        nombre.setFont(new Font("arial",Font.BOLD,12));
        nombre.setForeground(Color.black);
        
        id_alumno.setBounds(170,50,400,40);
        
        telefono.setBounds(170,150,400,40);
        
        direccion.setBounds(170,200,400,40);
        direccion.setEnabled(true); 
        
        edad.setBounds(170,250,400,40);
        
        sexo.setBounds(170,300,400,40);
        
        
        ciclo.setBounds(170,350,400,40);
        // Se agregan los botones al panel
        panel.add(id_alumno);
        panel.add(nombre);
        panel.add(telefono);
        panel.add(direccion);
        panel.add(edad);
        panel.add(sexo);
        panel.add(ciclo);
    }
    
     private void Borrar(){
        
       
        CConexion cc = new CConexion();
        Connection con = cc.estableceConexion();
        String Borrar="";
        
        
        Borrar="DELETE FROM altas (id_alumno) VALUES (?)";

                    JOptionPane.showMessageDialog(null,"Registros Borrados");
               
      

     
        
     }
    private void EscribirSQL(){
        
       
        CConexion cc = new CConexion();
        Connection con = cc.estableceConexion();
        String sql="";
        JOptionPane.showMessageDialog(null,"se conecto exitosamente");
        
        sql="INSERT INTO altas (id_alumno,nombre,telefono,direccion, edad, sexo, ciclo) VALUES (?,?,?,?,?,?,?)";
        try {
                PreparedStatement pst = con.prepareStatement(sql);
                //
                String stid_alumno = (id_alumno.getText());
                pst.setString(1, stid_alumno);
                System.out.println(""+stid_alumno);
                //
                String stnombre = (nombre.getText());
                pst.setString(2, stnombre);
                System.out.println(""+stnombre);
                //
                String sttelefono = (telefono.getText());
                pst.setString(3, sttelefono);
                System.out.println(""+sttelefono);
                // 
                String stdireccion = (direccion.getText());
                pst.setString(4, stdireccion);
                System.out.println(""+stdireccion);
                //
                String stedad = (edad.getText());
                pst.setString(5, stedad);
                System.out.println(""+stedad);
                //
                String stsexo = (sexo.getText());
                pst.setString(6, stsexo);
                System.out.println(""+stsexo);
                //
                String stciclo = (ciclo.getText());
                pst.setString(7, stciclo);
                System.out.println(""+stciclo);
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
         JLabel id_alumno = new JLabel("Alumno"); // Creamos una etiqueta
       id_alumno.setBounds(600,50,100,40); // Se define el tamaño 
       //de la etiqueta
       id_alumno.setHorizontalAlignment(SwingConstants.CENTER);
        //Se define la alineación del texto de la etiqueta
       id_alumno.setForeground(Color.black); // Se establece el color de la 
        //etiqueta
       id_alumno.setOpaque(true); // Se establece que el fondo de la 
        //etiqueta se pueda cambiar de color
       id_alumno.setBackground(Color.white);// Se establece el color de fondo
        //de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       id_alumno.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       
       JLabel nombre = new JLabel("Nombre"); // Creamos una etiqueta
       nombre.setBounds(600,100,100,40); // Se define el tamaño 
       //de la etiqueta
       nombre.setHorizontalAlignment(SwingConstants.CENTER);
        //Se define la alineación del texto de la etiqueta
       nombre.setForeground(Color.black); // Se establece el color de la 
        //etiqueta
       nombre.setOpaque(true); // Se establece que el fondo de la 
        //etiqueta se pueda cambiar de color
       nombre.setBackground(Color.white);// Se establece el color de fondo
        //de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       nombre.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel telefono = new JLabel("Telefono"); // Creamos una etiqueta
       telefono.setBounds(600,150,100,40); // Se define el tamaño 
//       de la etiqueta
       telefono.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       telefono.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       telefono.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       telefono.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       telefono.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel direccion = new JLabel("Direccion"); // Creamos una etiqueta
       direccion.setBounds(600,200,100,40); // Se define el tamaño 
//       de la etiqueta
       direccion.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       direccion.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       direccion.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       direccion.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       direccion.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel edad = new JLabel("Edad"); // Creamos una etiqueta
       edad.setBounds(600,250,100,40); // Se define el tamaño 
//       de la etiqueta
       edad.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       edad.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       edad.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       edad.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       edad.setFont(new Font("arial",Font.BOLD,12));
//       Se asigna fuente, tipo tamaño de letra
       JLabel sexo = new JLabel("sexo"); // Creamos una etiqueta
       sexo.setBounds(600,300,100,40); // Se define el tamaño 
//       de la etiqueta
       sexo.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       sexo.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       sexo.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       sexo.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       sexo.setFont(new Font("arial",Font.BOLD,12));
//        Se agregan etiquetas al panel

       JLabel ciclo = new JLabel("ciclo"); // Creamos una etiqueta
       ciclo.setBounds(600,350,100,40); // Se define el tamaño 
//       de la etiqueta
       ciclo.setHorizontalAlignment(SwingConstants.CENTER);
//        Se define la alineación del texto de la etiqueta
       ciclo.setForeground(Color.black); // Se establece el color de la 
//        etiqueta
       ciclo.setOpaque(true); // Se establece que el fondo de la 
//        etiqueta se pueda cambiar de color
       ciclo.setBackground(Color.white);// Se establece el color de fondo
//        de la etiqueta 
       panel.setBackground(Color.blue); // Asignando color al panel
       ciclo.setFont(new Font("arial",Font.BOLD,12));
//        Se agregan etiquetas al panel
       panel.add(id_alumno);
       panel.add(nombre);
       panel.add(telefono);
       panel.add(direccion);
       panel.add(edad);
       panel.add(sexo);
       panel.add(ciclo);
    }
        
}    

