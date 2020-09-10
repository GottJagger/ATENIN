/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author oderb
 */
public class OperacionArchivo {

    public static void crearArchivoUrl(ArrayList lista) {
        FileWriter flwriter = null;
        Url url = new Url();
        try {

            flwriter = new FileWriter("C:\\archivos\\ urls.txt");

            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Iterator it = lista.iterator(); it.hasNext();) {
                url = (Url) it.next();

                bfwriter.write(url.getUrl() + ";" + url.getDominio() + "\n");
            }

            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList leerArchivoUrl() {
        // crea el flujo para leer desde el archivo
        File file = new File("C:\\archivos\\urls.txt");
        ArrayList listaUrls = new ArrayList<>();
        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
//                SitioWeb sw = new SitioWeb();
//                sw.setSitioWeb(delimitar.toString());
                delimitar.useDelimiter("\\s*;\\s*");

                Url url = new Url();

                url.setUrl(delimitar.next());
                url.setDominio(delimitar.next());
                listaUrls.add(url);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaUrls;
    }

    public static void AgregarEnArchivoUrl(ArrayList lista) {
        FileWriter flwriter = null;

        try {
            flwriter = new FileWriter("C:\\archivos\\urls.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (Iterator it = lista.iterator(); it.hasNext();) {

                Url url = (Url) it.next();
                bfwriter.write(url.getUrl() + ";" + url.getDominio() + "\n");

            }

            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void crearArchivoSitioWeb(ArrayList lista) {
        FileWriter flwriter = null;
        SitioWeb sw = new SitioWeb();
        try {

            flwriter = new FileWriter("C:\\archivos\\SitioWeb.txt");

            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Iterator it = lista.iterator(); it.hasNext();) {
                sw = (SitioWeb) it.next();

                bfwriter.write(sw.getSitioWeb()+"\n");
            }

            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList leerArchivoSitioWeb() {
        // crea el flujo para leer desde el archivo
        File file = new File("C:\\archivos\\SitioWeb.txt");
        ArrayList listaUrls = new ArrayList<>();
        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
//                SitioWeb sw = new SitioWeb();
//                sw.setSitioWeb(delimitar.toString());
                delimitar.useDelimiter("\\s*;\\s*");

                SitioWeb sw = new SitioWeb();

                sw.setSitioWeb(delimitar.next());
                
                listaUrls.add(sw);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaUrls;
    }

    public static void AgregarEnArchivoSitioWeb(ArrayList lista) {
        FileWriter flwriter = null;

        try {
            flwriter = new FileWriter("C:\\archivos\\SitioWeb.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (Iterator it = lista.iterator(); it.hasNext();) {

                SitioWeb sw = (SitioWeb) it.next();
                bfwriter.write(sw.getSitioWeb()+ "\n");

            }

            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
