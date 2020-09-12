/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Arrays;

/**
 *
 * @author oderb
 */
public class Spider {

    public static ArrayList busquedaUrlElHeraldo(String urlPaginaPrincipal) {
        ArrayList array = new ArrayList<>();
        try {
            Document documento = Jsoup.connect(urlPaginaPrincipal).get();

            Elements ArticuloCol1 = documento.select("h1").select("a");

            for (int i = 1; i < ArticuloCol1.toArray().length; i++) {

                String urlArticulo1 = ArticuloCol1.get(i).attr("href");

                
                if (urlArticulo1.charAt(0) == '/') {
                    urlArticulo1 = "https://www.elheraldo.co" + urlArticulo1;
                    //System.out.println(urlArticulo1);
                    array.add(urlArticulo1);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Spider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public static ArrayList busquedaUrlDeMagangueHoy(String urlPaginaPrincipal) {
        ArrayList array = new ArrayList<>();
        try {

            Document documento = Jsoup.connect(urlPaginaPrincipal).get();

            Elements Articulo1 = documento.select("div.acme-col-3").select("figure.widget-image").select("a");
            //System.out.println(Articulo1.attr("href"));
            for (int i = 0; i < Articulo1.toArray().length; i++) {
                
                
                String urlArticulo1 = Articulo1.get(i).attr("href");
                array.add(urlArticulo1);
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Spider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
    
    
    
    
    
    
    
            
    public static void main(String[] args) {
        busquedaUrlDeMagangueHoy("https://maganguehoy.co/news/");
    }

}
