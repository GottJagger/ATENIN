/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.main;

import edu.cecar.logica.Scrapper;
import edu.cecar.logica.TratamientoDatos;
import edu.cecar.persistencia.OperacionArchivo;
import edu.cecar.persistencia.SitioWeb;
import edu.cecar.persistencia.Url;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.io.File;

/**
 *
 * @author oderb
 */
public class Main {

    public static void main(String[] args) {

        //ArrayList listaUlrs = new ArrayList<>();
        //OperacionArchivo.crearArchivoUrl(listaUlrs);
        ArrayList listaSitioWeb = new ArrayList<>();
        ArrayList lecturaSitioWeb = new ArrayList<>();

        OperacionArchivo.crearArchivoSitioWeb(listaSitioWeb);
        while (true) {
            lecturaSitioWeb = OperacionArchivo.leerArchivoSitioWeb();
            switch (JOptionPane.showInputDialog("OPCION:\na.agregar Sitio Web.\nb.modificar sitio Web\nc.borrar\nd.mostrar")) {
                case "a":

                    SitioWeb sw = new SitioWeb();

                    sw.setSitioWeb(JOptionPane.showInputDialog("digite el sitio web"));

                    lecturaSitioWeb = OperacionArchivo.leerArchivoSitioWeb();
                    if (lecturaSitioWeb.isEmpty()) {
                        System.out.println("Esta vacio");
                        listaSitioWeb.add(sw);
                        OperacionArchivo.AgregarEnArchivoSitioWeb(listaSitioWeb);
                    } else {

                        for (Iterator it = lecturaSitioWeb.iterator(); it.hasNext();) {
                            SitioWeb swlectura = (SitioWeb) it.next();

                            if (sw.getSitioWeb().equalsIgnoreCase(swlectura.getSitioWeb())) {
                                System.out.println("el sitio web ya existe");
                                break;
                            } else {
                                listaSitioWeb.add(sw);
                                OperacionArchivo.AgregarEnArchivoSitioWeb(listaSitioWeb);
                                break;
                            }
                        }
                    }

                    lecturaSitioWeb.clear();
                    listaSitioWeb.clear();
                    sw.setSitioWeb(null);

                    break;

                case "b":

                    boolean flag = false;
                    boolean flag1 = false;
                    lecturaSitioWeb = OperacionArchivo.leerArchivoSitioWeb();
                    if (lecturaSitioWeb.isEmpty()) {
                        System.out.println("NO SE A GUARDADO NINGUN SITIO WEB");
                        break;
                    } else {
                        for (Iterator it = lecturaSitioWeb.iterator(); it.hasNext();) {
                            SitioWeb swlectura = (SitioWeb) it.next();
                            System.out.println(swlectura.getSitioWeb());
                        }
                        lecturaSitioWeb.clear();
                        String swSelecionado = JOptionPane.showInputDialog("Porfavor escoja alguna url que muestra en pantalla");

                        lecturaSitioWeb = OperacionArchivo.leerArchivoSitioWeb();

                        for (Iterator it = lecturaSitioWeb.iterator(); it.hasNext();) {

                            SitioWeb swlectura = (SitioWeb) it.next();

                            if (flag == false) {
                                if (swSelecionado.equalsIgnoreCase(swlectura.getSitioWeb())) {
                                    swlectura.setSitioWeb(JOptionPane.showInputDialog("Digite el sitio web corregido:"));
                                    flag = true;
                                    flag1 = true;
                                }
                            } else {
                                System.out.println("ERROR, copio mal la URL del sitio web, vuelva intertarlo.");
                            }

                        }
                        if (flag1 == false) {
                            System.out.println("NO EXISTE EL SITIO WEB QUE QUIERE MODIFICAR");
                        }
                        OperacionArchivo.crearArchivoSitioWeb(lecturaSitioWeb);
                    }

                    lecturaSitioWeb.clear();

                    break;
                case "c":
                    flag = false;
                    flag1 = false;
                    for (Iterator it = lecturaSitioWeb.iterator(); it.hasNext();) {
                        SitioWeb swlectura = (SitioWeb) it.next();
                        System.out.println(swlectura.getSitioWeb());
                    }
                    lecturaSitioWeb.clear();
                    String swSelecionado = JOptionPane.showInputDialog("Porfavor escoja alguna url que muestra en pantalla");
                    int i = 0;
                    lecturaSitioWeb = OperacionArchivo.leerArchivoSitioWeb();
                    for (Iterator it = lecturaSitioWeb.iterator(); it.hasNext();) {

                        SitioWeb swlectura = (SitioWeb) it.next();
                        if (flag == false) {
                            if (swSelecionado.equalsIgnoreCase(swlectura.getSitioWeb())) {
                                lecturaSitioWeb.remove(i);
                                flag = true;
                                flag1 = true;
                                break;
                            }
                        }
                        i++;
                    }
                    if (flag1 == false) {
                        System.out.println("NO SE ENCUENTRA LA URL");

                    }

                    OperacionArchivo.crearArchivoSitioWeb(lecturaSitioWeb);
                    break;

                case "d":
                    if (lecturaSitioWeb.isEmpty()) {
                        System.out.println("EL ARCHIVO SE ENCUENTRA VACIO");
                    }
                    for (Iterator it = lecturaSitioWeb.iterator(); it.hasNext();) {
                        SitioWeb swlectura = (SitioWeb) it.next();
                        System.out.println(swlectura.getSitioWeb());

                    }
                    lecturaSitioWeb.clear();
                    break;
            }
        }
    }
}
