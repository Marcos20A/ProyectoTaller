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

import java.util.InputMismatchException;
import java.util.Scanner;



class Login{
  Scanner sc;
  
  String ur,pass;
  
  public Login(Scanner sc){
    this.sc=sc;
    insertDatos();
  }
  
   public void insertDatos(){
    System.out.println("Primero debes iniciar sesión para poder desplegar el menú");
    System.out.println("Ingresa el usuario:");
    ur=sc.nextLine();
    
    System.out.println("Ingresa la contraseña:");
    pass=sc.nextLine();
    validacion();
  }
   
  public void validacion(){
    if(ur.equals("admin")){
      if(pass.equals("admin")){
        Scanner sn = new Scanner(System.in);
    int opcion;
    boolean salir = false;
            
    while(!salir){
            
            System.out.println("Bienvenido a la agenda virtual!");
            System.out.println("Tus opciones son las siguientes: ");
            
            System.out.println("1.- Menú principal");
            System.out.println("0.- salir ");
         
            try{
                
                  System.out.println("Selecciona una opcion: ");
                  opcion = sn.nextInt();
                  sn.nextLine();
                  
                  switch(opcion){
                
                  case 1:
                      agenda.cargarr();
                       break;
                    
                  case 0:
                      System.out.println("Adioooos");
                         salir=true;
                      break;
                default:
                        System.out.println("Opcion no valida, ingresa un número del menú");
            }
            
            }catch(InputMismatchException e){
                
                System.out.println("Opción no valida, ingresa un número valido");
                sn.next();
                
            }
    }
        
      }else{
        System.out.println("Contraseña incorrecta, intenta de nuevo ");
        
      }
    }else{
      System.out.println("Usuario incorrecto, intenta de nuevo ");
    }
  }
}



class Login_Test{
  
  public static void main (String as[]){
    Scanner sc=new Scanner (System.in);
    Login l=new Login(sc);
  }
}
