/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unbosque.edu.co.implsimgletonconexion;

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

    }
}
