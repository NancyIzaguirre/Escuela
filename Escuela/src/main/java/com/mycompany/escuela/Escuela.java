

package com.mycompany.escuela;


public class Escuela {

    public static void main(String[] args) {
        //CConexion objetoConexion= new CConexion();
        //objetoConexion.estableceConexion();
        
        
        altas altas1 =new altas();
        //visibilizar ventana altas
        altas1.setVisible(true);
        
        
          Maestros Maestros1 =new Maestros();
//        visibilizar ventana Maestros
        Maestros1.setVisible(true);
        
        Grupos Grupos1= new Grupos ();
//          visibilizar ventana Grupos
        Grupos1.setVisible(true);
        
//  visibilizar ventana Materias
          Materias Materias1= new Materias ();
        
       Materias1.setVisible(true);
        }
    }
