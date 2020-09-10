/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.persistencia;

/**
 *
 * @author oderb
 */
public class Url {
    private String url;
    private String dominio;
    
    
    public Url(){
        
    }

    public Url(String url, String dominio ) {
        this.url = url;
        this.dominio = dominio;
        
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }
    
}
