/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.persistencia;

import java.util.Date;

/**
 *
 * @author oderb
 */
public class Articulo {

    String titulo;
    String fecha;
    String contenido;
    String Url;

    public Articulo() {
    }

    public Articulo(String titulo, String fecha, String contenido, String Url) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.contenido = contenido;
        this.Url = Url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
     
}
