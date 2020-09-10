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

    public static ArrayList busquedaUrlSemana(String urlPaginaPrincipal) {
        ArrayList array  = new ArrayList<>();
        try {
            Document documento = Jsoup.connect(urlPaginaPrincipal).get();

            Elements ArticuloCol1 = documento.select("div.medium-7").select("article.article").select("a.related-news-th");
            for (int i = 0; i < ArticuloCol1.toArray().length; i++) {
                String urlArticulo1 = ArticuloCol1.get(i).attr("href");
                if (urlArticulo1.charAt(0) == '/') {
                    urlArticulo1 = "https://www.semana.com" + urlArticulo1;
                    //System.out.println(urlArticulo1);
                    array.add(urlArticulo1);
                } else {
                    if (urlArticulo1.contains("https://www.semana.com")) {
                        //System.out.println(urlArticulo1);
                        array.add(urlArticulo1);
                    }
                }
            }

            Elements ArticuloCol2 = documento.select("div.panel").select("article.article").select("header.article-header").select("a.related-news-th");

            for (int i = 0; i < ArticuloCol2.toArray().length; i++) {
                String urlArticulo2 = ArticuloCol2.get(i).attr("href");

                if (urlArticulo2.charAt(0) == '/') {
                    urlArticulo2 = "https://www.semana.com" + urlArticulo2;
                    array.add(urlArticulo2);

                } else {
                    if (urlArticulo2.contains("https://www.semana.com")) {
                        
                        array.add(urlArticulo2);
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Spider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public static void busquedaUrlElTiempo() {

    }
}
