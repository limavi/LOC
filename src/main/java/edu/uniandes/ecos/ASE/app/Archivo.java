/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dito
 */
public class Archivo {

    /*
    Metodo
     */
    public static boolean verificarExistenciaArchivo(String ruta) {
        return new File(ruta).exists();
    }

    /*
    Metodo
     */
    public static ArrayList retornarContenidoArchivoArrayList(String ruta) {

        ArrayList al = null;
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            return al;
        }
        al = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line;
            // Se recorre el archivo y se va llenando el LinkedList
            while ((line = br.readLine()) != null) {
                al.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }

}
