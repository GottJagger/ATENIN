/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.main.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author oderb
 */
public class Scrapper {

    public static void ScrappingArticuloSemana(String url) {
        Document documento;
        try {
            documento = Jsoup.connect(url).get();

            Elements fechaArticulo = documento.select("span.date");
            Elements titulo = documento.select("h1.tittleArticuloOpinion");
            Elements contenidoArticulo = documento.select("div.theiaStickySidebar");

            System.out.println("Titulo: " + titulo.text()+"\n------------------");
            System.out.println("Fecha: " + fechaArticulo.text()+"\n------------------");
            System.out.println("Contenido: "+contenidoArticulo.text()+"\n------------------");

        } catch (IOException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void ScrappingArticuloTiempo(){
        
    }
}
