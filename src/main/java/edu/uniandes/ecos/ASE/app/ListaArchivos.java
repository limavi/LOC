/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Dito
 */
public class ListaArchivos {
    private ArrayList<String> listadoArchivos = new ArrayList(); /*ArrayList que contendra el listado de archivos*/

    /*
    Metodo
    */
    public ArrayList<String> getListadoArchivos() {
        return listadoArchivos;
    }

    /*
    Metodo
    */
    public void setListadoArchivos(ArrayList<String> listadoArchivos) {
        listadoArchivos = listadoArchivos;
    }

    /*
    Metodo
    */
    public void obtenerArchivos(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                obtenerArchivos(file);
            } else {
                listadoArchivos.add(file.getName());
            }
        }
    }

    /*
    Metodo
    */
    public void obtenerArchivosExpRegular(File folder, String expresionRegular) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                obtenerArchivosExpRegular(file, expresionRegular);
            } else if (ExpresionRegular.verificarExpresionRegular(expresionRegular, file.getName())) {
                listadoArchivos.add(file.getPath());
            }
        }
    }

    /*
    Metodo
    */
    public void imprimirListado() {
        for (int i = 0; i < listadoArchivos.size(); i++) {
            System.out.println(listadoArchivos.get(i));
        }
    }

    /*
    Metodo
    */
    public void imprimirListadoExpRegular(String expresionRegular) {
        for (int i = 0; i < listadoArchivos.size(); i++) {
            String file = listadoArchivos.get(i);
            if (ExpresionRegular.verificarExpresionRegular(expresionRegular, file)) {
                System.out.println(file);
            }
        }
    }
}
