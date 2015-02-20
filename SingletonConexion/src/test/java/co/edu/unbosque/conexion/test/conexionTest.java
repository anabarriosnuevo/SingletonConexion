/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.conexion.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Grupo 1
 */
public class conexionTest {

    @Test
    public void pruebaConexion() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://nuevo.aretico.com:5432/software_2";
            Connection con = DriverManager.getConnection(url, "grupo1", "jDsX9eE08DSAOWehhCnD");
            Statement s = con.createStatement();

            s.execute("select now()");

            s.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(conexionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertTrue(true);
    }

}
