/**
 * Universidad del Valle de Guatemala
 * Estructura de Datos, ciclo 1 ,2017
 * Programa que simula el algoritmo de huffman. Se le ingresa un texto y lo codifica  ceros y una de acuerdo al algoritmo de Huffman 
 * Juan Carlos Solis Cruz-15564
 * Giovani Velazquez 
 */
package hd7;

import java.util.*;


import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
            
        Huffman huffman = new Huffman(); //Objeto para los metoso del arbol de huffman 
      
        Scanner teclado = new Scanner(System.in);
        
        //Pedemos el texto a codificar 
        String inputTexto; 
        
       System.out.println("\n Ingrese el texto a Codificar:");
       inputTexto=teclado.next();
 
      
        //Recorremos el texto 
        int[] charFreqs = new int[256];
        for (char c : inputTexto.toCharArray())
            charFreqs[c]++;
       
        ArbolHuffman tree = huffman.construirArbol(charFreqs);
        
        //Inidcamos lo que vamos a codificar 
         System.out.println("LA FRECUENCIA MAYOR  ES MI PRIORIDAD  ");
        System.out.println("Tabla de Codigos");
        System.out.println("Simbolo\tCANTIDAD\tCODIGO HUFFMAN ");
        huffman.imprimirCodigos(tree, new StringBuffer());
        
        // Codificamos texto 
        String codificar = huffman.codificar(tree,inputTexto);
        // Mostramoos el texto en codigo de huffman 
        System.out.println("\nTEXTO EN CODIGO HUFFMAN ");
        System.out.println(codificar); 
        
        // Decodificaos el texto 
        System.out.println("\n\nTEXTO LEIDO DEL CODIGO HUFFMAN ");
        System.out.println(huffman.descodificar(tree,codificar));
        
        }

    }

        
   