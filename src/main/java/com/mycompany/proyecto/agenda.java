/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

/**
 *
 * @author marco
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class agenda {
    
    
    static HashMap<String, String> programaPrn = new HashMap<String, String>();

    static Scanner sn = new Scanner(System.in);

    static File archivo = null;
    static FileReader leer = null;
    static BufferedReader datos = null;
    static FileWriter escribir = null;
    static PrintWriter linea = null;

    static String nombre = "";
    static String tel = "";
    static String registro = "";
    static final String COMA = ",";
    static int opcion = 0;
    static String user = "user";
    static String couser = "user";
    
    
    public static void cargarr(){
        
        load();
        
            System.out.println("Cargando sistema....");
        
        do {
            
            System.out.println("Hola!");
            System.out.println("Tus opciones son las siguientes: ");
            System.out.println("1.- Ver contactos registrados");
            System.out.println("2.- Registrar contacto");
            System.out.println("3.- Borrar contacto");
            System.out.println("0.- Volver al menú principal");
            
            opcion = Integer.parseInt(sn.nextLine());

            switch (opcion) {
                case 1:
                          if(programaPrn.entrySet().isEmpty()){
                            System.out.println("No hay contactos registrados");
                        }else{
                            lista();
                          }
                    break;
                case 2:
                    crearC();
                    guardar();
                    break;
                case 3:
                    borrar();
                    guardar();
                    break;
            }
            
            } while (opcion != 0);
            
    }
            
        
    public static void load() {

        archivo = new File("agenda.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();

            } catch (IOException ex) {
                Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {

                load2();
                leer = new FileReader(archivo);
                datos = new BufferedReader(leer);

            } catch (IOException ex) {
                Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void load2() {
        registro = "";

        try {

            leer = new FileReader(archivo);
            datos = new BufferedReader(leer);

            while (registro != null) {
                try {

                    registro = datos.readLine();

                    if (registro != null) {
                        String[] fields = registro.split(COMA);

                        tel = fields[0];
                        nombre = fields[1];                  
                        programaPrn.put(tel, nombre);

                    }

                } catch (IOException ex) {
                    Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            leer.close();
            datos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void guardar() {

        try {
            resetArchivo();
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);

            for (Map.Entry<String, String> entry : programaPrn.entrySet()) {
                linea.println(entry.getKey() + "," + entry.getValue());
            }

            linea.close();
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void lista() {
        
        

        System.out.println("Registro:");
        for (Map.Entry<String, String> entry : programaPrn.entrySet()) {
            System.out.println("Teléfono: " + entry.getKey() + " Nombre: " + entry.getValue());
        }

        System.out.println();
    }
      
    public static void crearC() {

        System.out.println("Nombre");
        nombre = sn.nextLine();

        System.out.println("Teléfono");
        tel = sn.nextLine();

        programaPrn.put(tel, nombre);

        try {

            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            linea.println(tel + nombre);

            linea.close();
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println();
    }
    

    public static void borrar() {
        System.out.println("Borrador de contactos");
        System.out.println("Para eliminar un contacto, debes ingresar el número de teléfono");
        tel = sn.nextLine();
        programaPrn.remove(tel);
        System.out.println("Ha sido eliminado con éxito");
    }

    public static void resetArchivo() {
        try {

            BufferedWriter writer = null;
            escribir = new FileWriter(archivo);
            writer = new BufferedWriter(escribir);
            PrintWriter escribir1 = new PrintWriter(escribir);

            writer.write("");

            escribir1.close();
            writer.close();
            escribir.close();

        } catch (IOException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
