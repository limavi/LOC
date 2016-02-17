package edu.uniandes.ecos.ASE.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
class ArchivoIndividual {

    static String nombre;
    static int cantidad;

}

public class Principal {

    /**
     * Metodo
     *
     * @param args
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite la ruta del proyecto a verificar: ");
        String ruta = scanner.next();
        LOC loc = new LOC();
        ArrayList conteoIndividual = new ArrayList();

        String linea;
        ListaArchivos listadoArchivos = new ListaArchivos();
        final File raiz = new File(ruta);
        final String expresionRegular = "\\.java$";

        listadoArchivos.obtenerArchivosExpRegular(raiz, expresionRegular);

        List<String> archivo = listadoArchivos.getListadoArchivos();
        for (int i = 0; i < archivo.size(); i++) {
            ArrayList lineas = Archivo.retornarContenidoArchivoArrayList(archivo.get(i));
            for (int j = 0; j < lineas.size(); j++) {
                linea = (String) lineas.get(j);
                loc.contarLineas(linea);
            }
        }
        System.out.println("El número de clases en total es:" + loc.getNumeroClases());
        System.out.println("El número de items en total es:" + loc.getNumeroMetodos());
        System.out.println("El número de LOC totalales es:" + loc.getNumeroLineas());
    }
}
