/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.persistencia.Articulo;
import edu.cecar.persistencia.OperacionArchivo;
import edu.cecar.persistencia.SitioWeb;
import edu.cecar.persistencia.Url;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author oderb
 */
public class TratamientoDatos {

    Iterator iteratorDeUrls;

    public static void guardarUrls(String dominio) {
        Url urls = new Url();
        ArrayList lecturaUrl = new ArrayList<>();
        ArrayList listaDeUrls = new ArrayList<>();
        ArrayList listaU = new ArrayList<>();
        ArrayList listSucr = new ArrayList<>();
        ArrayList listHerl = new ArrayList<>();

        lecturaUrl = OperacionArchivo.leerArchivoUrl();
        if (lecturaUrl.isEmpty()) {
            //OperacionArchivo.crearArchivoUrl(listaU);

        } else {
            if (dominio.equals("https://www.elheraldo.co/sincelejo")) {
                listHerl = Spider.busquedaUrlElHeraldo(dominio);
            } else {
                listSucr = Spider.busquedaUrlDeSucreNoticia(dominio);
            }
        }

        listaU.addAll(listHerl);
        listaU.addAll(listSucr);

        for (Iterator it = listaU.iterator(); it.hasNext();) {
            urls.setDominio(dominio);
            urls.setUrl(it.next().toString());
            listaDeUrls.add(urls);

            OperacionArchivo.AgregarEnArchivoUrl(listaDeUrls);

            listaDeUrls.clear();
        }

    }

    public static void guardarScrapping() {
        Articulo articulo = new Articulo();
        ArrayList listaScrapping = new ArrayList<>();
        ArrayList lecturaUrl = new ArrayList<>();
        ArrayList listEsp = new ArrayList<>();
        ArrayList listSem = new ArrayList<>();

        OperacionArchivo.crearArchivoArticulo(listaScrapping);
        lecturaUrl = OperacionArchivo.leerArchivoUrl();

        for (Iterator it = lecturaUrl.iterator(); it.hasNext();) {
            Url url = (Url) it.next();
            System.out.println("el dominio: " + url.getDominio() + "\n url: " + url.getUrl());
            
            if (url.getDominio() == "https://sucrenoticias.com") {
                articulo.setUrl(url.getUrl());
                articulo.setContenido(Scrapper.ScrappingArticuloSucreNoticia(url.getUrl()).getContenido());
                articulo.setTitulo(Scrapper.ScrappingArticuloSucreNoticia(url.getUrl()).getTitulo());
                articulo.setFecha(Scrapper.ScrappingArticuloSucreNoticia(url.getUrl()).getFecha());
                listEsp.add(articulo);
            } else {

                articulo.setUrl(url.getUrl());
                articulo.setContenido(Scrapper.ScrappingArticuloElHeraldo(url.getUrl().toString()).getContenido());
                articulo.setTitulo(Scrapper.ScrappingArticuloElHeraldo(url.getUrl().toString()).getTitulo());
                articulo.setFecha(Scrapper.ScrappingArticuloElHeraldo(url.getUrl().toString()).getFecha());
                listSem.add(articulo);
            }

        }

        //listaScrapping.addAll(listSem);
        //listaScrapping.addAll(listEsp);
        //OperacionArchivo.AgregarEnArchivoArticulo(listaScrapping);
    }

    public static void main(String[] args) {
        //SE DEBE PASAR AL MAIN RECORDAR QUE SE DEBE VALIDAR QUE EXISTA UN DOMINIO.
//        ArrayList lecturaListaDeSitioWeb = new ArrayList<>();
//
//        for (Iterator it = lecturaListaDeSitioWeb.iterator(); it.hasNext();) {
//            SitioWeb swlectura = (SitioWeb) it.next();
//            guardarUrls(swlectura.getSitioWeb());
//        }

        //guardarUrls("https://sucrenoticias.com");
        //guardarUrls("https://www.elheraldo.co/sincelejo");
        guardarScrapping();

    }
}
