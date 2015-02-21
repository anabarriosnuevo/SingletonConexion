/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unbosque.edu.co.implsimgletonconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 1
 */
public class SingletonConexion {

    private final String url;
    private final String user;
    private final String pass;
    private static SingletonConexion miconfigurador;

    private SingletonConexion(String url, String user, String pass) {

        this.url = url;
        this.user = user;
        this.pass = pass;

    }

    public static SingletonConexion getInstance(String url, String user, String pass) {

        if (miconfigurador == null) {

            miconfigurador = new SingletonConexion(url, user, pass);
        }
        return miconfigurador;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }


    public String getPass() {
        return pass;
    }

    
    public Connection getConnection() throws Exception {
        
        Connection connection = null;
        
        try {
            
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SingletonConexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage(), ex);
        }
        
        return connection;
    }

}
