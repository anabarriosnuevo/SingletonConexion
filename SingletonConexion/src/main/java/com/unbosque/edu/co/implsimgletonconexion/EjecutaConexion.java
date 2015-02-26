/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.unbosque.edu.co.implsimgletonconexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 1
 */
public class EjecutaConexion {
    
    public static void main(String[] args) {
        
        
        SingletonConexion conexion = SingletonConexion.getInstance("jdbc:postgresql://nuevo.aretico.com:5432/software_2", "grupo1", "jDsX9eE08DSAOWehhCnD");
        
        System.out.println(conexion.getUrl());
        
        System.out.println(conexion.getUser());
        
        System.out.println(conexion.getPass());
        
        Connection connection = null;
        try {
            connection = conexion.getConnection();
            if (connection != null) {
                System.out.println("Conexion Exitosa");
            } else {
                System.out.println("Conexion Erronea");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SingletonConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            ResultSet resultSet = conexion.executeQuery("select now()");
            if (resultSet.next()) {
                Date fechaActual = (Date) resultSet.getDate(1);
                System.out.println("La ejecucion del query resulta --> " + fechaActual);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(EjecutaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
