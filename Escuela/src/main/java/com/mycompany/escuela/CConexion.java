
package com.mycompany.escuela;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class CConexion {
    
    
    Connection conectar = null;
    String usuario= "root";
    String contraseña = "(password)";
    String bd= "escuela" ;
    String ip="127.0.0.1";
    String puerto= "3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion (){
        
    try {
        
      Class.forName("com.mysql.cj.jdbc.Driver");  
      conectar=(Connection) DriverManager.getConnection(cadena,usuario,contraseña );
   //   conectar=DriverManager.getConnection(cadena,usuario,contraseña);
      JOptionPane.showMessageDialog(null,"se conecto");
    } catch(Exception e){
        JOptionPane.showMessageDialog(null, "no se conecto a bbdd"+e.toString() );
    }
        return conectar;
    }
}
