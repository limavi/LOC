/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dito
 */
public class ExpresionRegular {

    /*
    Metodo
     */
    public static boolean verificarExpresionRegular(String expresion, String texto) {
        Pattern pat = Pattern.compile(expresion);
        Matcher mat = pat.matcher(texto);
        return mat.find();
    }
}
