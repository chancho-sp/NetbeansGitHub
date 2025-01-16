/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto1;

/**
 *
 * @author JoseM
 */
import java.util.Scanner;
public class eval02 {

    public static boolean validaNumeroSerie(String num) {
        boolean valido=false;
        int i=0, x=0, y=0;
        if (num.length()<3){
            System.out.println("La cadena es menor de 3");
            return valido;
        }
        if (num.length()%2!=1){
            System.out.println("La cadena no es de longitud impar");
            return valido;
        }
        else {
            String parte1 = num.substring(0, num.length()/2);
            for (i=0;i<parte1.length();i++){
                x=Integer.parseInt("" + parte1.charAt(i) );
            }
            String parte2 = num.substring(num.length()/2+1, num.length());
            for (i=0;i<parte2.length();i++){
                y=Integer.parseInt("" + parte2.charAt(i) );
            }
            if (x%2!=0){
                System.out.println("La primera mitad del número no es par");
                return valido;
            }
            if (y%2==0){
                System.out.println("La segunda mitad del número no es impar");
                return valido;
            }
            else {
                valido=true;
                return valido;
            }
        }
    }
    public static boolean validaCapacidad(int cap) {
        boolean capvalida=false;
        if (cap<4){
            System.out.println("La capacidad debe ser mayor que 4");
            return capvalida;
        }
        if (cap%2!=0){
            System.out.println("La capacidad debe ser par");
            return capvalida;
        }
        else {
            capvalida=true;
            return capvalida;
        }
    }
    
    public static void hacerCompra(String[] n){
        int i=0, pos=0;
        String productos="", parte1="", parte2="", productosc="";
        boolean correcto=false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Introduzca productos separados por - y termina con -fin");
            productos=sc.nextLine();
            if (productos.indexOf("-fin")==-1){
                System.out.println("Error al introducir los productos.");
            }
            else {
                productosc=productos;
                for (i=0;i<n.length;i++){
                    pos = productosc.indexOf("-");
                    parte1 = productosc.substring(0, pos);
                    parte2 = productosc.substring(pos+1);
                    productosc=parte2;
                }
                if (productosc.length()>4){
                    System.out.println("Has introducido mas productos de los que caben");
                }   
                else  correcto=true;
            }
        } while (correcto!=true);
        if (productos.indexOf("-")==-1){
            System.out.println("Error al introducir los productos.");
        }
        else {
            for (i=0;i<n.length;i++){
                pos = productos.indexOf("-");
                parte1 = productos.substring(0, pos);
                parte2 = productos.substring(pos+1);
                n[i]=parte1;
                productos = parte2;
            }
        }
        sc.close();
    }
    public static void congelarCompra(String[] n, String[] c){
        int i=0;
        for (i=0;i<c.length;i++){
            c[i]=n[i];
            n[i]="N";
        }

    }

    public static void main(String[] args) {
        String texto=("");
        int cap=0, i=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Introduzca número de serie");
            texto=sc.nextLine();
            validaNumeroSerie(texto);
        } while (validaNumeroSerie(texto)!=true);
        if (validaNumeroSerie(texto)){
            do{
                System.out.println("Introduzca capacidad");
                cap=sc.nextInt();
            } while (validaCapacidad(cap)!=true);
            if (validaCapacidad(cap)){
                String[] nevera=new String[cap];
                for (i=0;i<cap;i++){
                    nevera[i]="N";
                }
                String[] congelador=new String[cap/2];
                for (i=0;i<cap/2;i++){
                    congelador[i]="C";
                }
                imprimirPantalla(nevera, congelador);
                hacerCompra(nevera);
                congelarCompra(nevera, congelador);
                imprimirPantalla(nevera, congelador);
            }
        }
        sc.close();
    }
}
