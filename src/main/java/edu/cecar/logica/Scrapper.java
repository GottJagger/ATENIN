/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.main.CRUD;
import edu.cecar.persistencia.Articulo;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static Articulo ScrappingArticuloElHeraldo(String url) {
        Document documento;
        Articulo articulo = new Articulo();

        try {
            documento = Jsoup.connect(url).get();

            Elements fechaArticulo = documento.select("div.datos.view-desktop").select("time");
            Elements tituloArticulo = documento.select("h1.article-title.node-title");
            Elements contenidoArticulo = documento.select("div.content-article.size-m").select("p");

            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("MM-dd-yyyy");

            String fecha = fechaArticulo.attr("datetime");

            Date fechaDelArticulo = formatoDeFecha.parse(fecha);

            fecha = fechaDelArticulo.toString();

            articulo.setContenido(contenidoArticulo.text());
            articulo.setTitulo(tituloArticulo.text());
            articulo.setFecha(fecha);

        } catch (IOException ex) {

            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Scrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulo;
    }

    public static Articulo ScrappingArticuloMagangueHoy(String url) {
        Articulo articulo = new Articulo();
        Document documento;
        try {

            documento = Jsoup.connect(url).get();
            Elements fechaArticulo = documento.select("time.entry-date.published");
            Elements titulo = documento.select("h1.entry-title");
            Elements contenidoArticulo = documento.select("div.entry-content").select("p");

            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("MM-dd-yyyy");
            String fecha = fechaArticulo.attr("datetime");

            Date fechaDelArticulo = formatoDeFecha.parse(fecha);

            fecha = fechaDelArticulo.toString();

            articulo.setContenido(contenidoArticulo.text());
            articulo.setTitulo(titulo.text());
            articulo.setFecha(fecha);

        } catch (IOException ex) {
            Logger.getLogger(Scrapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Scrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulo;
    }

    public static void main(String[] args) {
        
    }
}
