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
public class SingletonConexion {

    private String url;
    private String user;
    private String pass;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
