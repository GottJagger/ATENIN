/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.logica;

import edu.cecar.persistencia.OperacionArchivo;
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
        ArrayList listaDeUrls = new ArrayList<>();
        ArrayList lista = new ArrayList<>();

        OperacionArchivo.crearArchivoUrl(lista);

        lista = Spider.busquedaUrlSemana(dominio);
        
        for (int i = 0; i < lista.size(); i++) {

            System.out.println(lista.get(i));
            urls.setDominio(dominio);
            urls.setUrl(lista.get(i).toString());
            listaDeUrls.add(urls);
            
        }
        OperacionArchivo.AgregarEnArchivoUrl(listaDeUrls);

    }
}
