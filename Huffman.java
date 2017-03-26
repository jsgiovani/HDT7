/**
 * Referencias bibligráficas : René Mtz.[René Mtz].(2012,05,29).Algoritmo de Huffman[Archivo Video].Recuperado de:https://www.youtube.com/watch?v=8Gf8wutvS1w&t=207s&index=12&list=PL6X5MVAfZPXBx4WRZc1tK9gVcYcFk3gMH
 * 
 */
package hd7;

import java.util.PriorityQueue;


public class Huffman {
    
    
         
        
        
	/* Meotod para construir el arbol recibe como parametro el texto a codificar 
	 */
    public static ArbolHuffman construirArbol(int[] charFreqs) {
    	// Creamos una cola de prioridades 
    	// Se ccrea la cola de acuerdo a la frecuenci de la letra del texto ingresdado. 
        PriorityQueue<ArbolHuffman> trees = new PriorityQueue<ArbolHuffman>();
        // Crea la hoja de los arboles para cada letra 
        for (int i = 0; i < charFreqs.length; i++){
            if (charFreqs[i] > 0)
                trees.offer(new HojaHuffman(charFreqs[i], (char)i)); // Inser os elementos, n� folha, na fila de prioridade
        }
        // Recorre todos los elementos de la cola 
        // Crea el arbol binario de abajo hacia arriba 
        while (trees.size() > 1) {
            //Obitene los dos letras con menos frecuencia 
            ArbolHuffman a = trees.poll(); 
            ArbolHuffman b = trees.poll(); // Devuelve el siguietne
 
            // Crea los nodos 
            trees.offer(new NodoHuffman(a, b)); 
        }
        // Retorna el primer arbol 
        return trees.poll();
    }
 
    /* Metodo para codificar 
    */ 
    public static String codificar(ArbolHuffman tree, String encode){
    	assert tree != null;
    	
    	String codificarTexto = "";
        for (char c : encode.toCharArray()){
        	codificarTexto+=(getCodigos(tree, new StringBuffer(),c));
        }
    	return codificarTexto; // Devuelve el texto compactado 
    }
    
    
    /* Metodo para decodificar la cadena
    */
    public static String descodificar(ArbolHuffman tree, String encode) {
    	assert tree != null;
    	
    	String decodificarTexto="";
    	NodoHuffman nodo = (NodoHuffman)tree;
    	for (char code : encode.toCharArray()){
    		if (code == '0'){ //Cuando codigo es igual a 0 entonces se va para la izquierda 
    		    if (nodo.izquierda instanceof HojaHuffman) { 
    		    	decodificarTexto += ((HojaHuffman)nodo.izquierda).valor; //Devuelve el valor de la hoja n  
	                nodo = (NodoHuffman)tree; // Regresa  la raiz del arbol 
	    		}else{
	    			nodo = (NodoHuffman) nodo.izquierda; // Continua recorriendo el arbol por el lado izquierdo 
	    		}
    		}else if (code == '1'){ // Cunaod es igual a 1, entonces el derecho 
    		    if (nodo.derecha instanceof HojaHuffman) {
    		    	decodificarTexto += ((HojaHuffman)nodo.derecha).valor; //Regresa el valor de la hoja del lado derecho 
	                nodo = (NodoHuffman)tree; //Devuelve la raiz del arbol 
	    		}else{
	    			nodo = (NodoHuffman) nodo.derecha; // Se va para el lado derecho del arbol 
	    		}
    		}
    	} // Finaliza for
    	return decodificarTexto; // Retorna el texto decofificado 
    }    
    
    /* 
     * Metodo para recorrer y muestar los codigos en huffman 
     */
    public static void imprimirCodigos(ArbolHuffman tree, StringBuffer prefix) {
        assert tree != null;
        
        if (tree instanceof HojaHuffman) {
            HojaHuffman hoja = (HojaHuffman)tree;
            
            //Imprimimos una letra de la lista 
            System.out.println(hoja.valor + "\t" + hoja.frecuencia + "\t\t" + prefix);
 
        } else if (tree instanceof NodoHuffman) {
            NodoHuffman nodo = (NodoHuffman)tree;
 
            // Recorrido Izquierdo
            prefix.append('0');
            imprimirCodigos(nodo.izquierda, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // Recorrido derecho 
            prefix.append('1');
            imprimirCodigos(nodo.derecha, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    
    /* 
     * Metodo para retornar el codigo de huffman de una letra 
     */
    public static String getCodigos(ArbolHuffman tree, StringBuffer prefix, char w) {
        assert tree != null;
        
        if (tree instanceof HojaHuffman) {
            HojaHuffman hoja = (HojaHuffman)tree;
            
            // Retorna un texto codificado 
            if (hoja.valor == w ){
            	return prefix.toString();
            }
            
        } else if (tree instanceof NodoHuffman) {
            NodoHuffman nodo = (NodoHuffman)tree;
 
            //Recorrer izquierda
            prefix.append('0');
            String izquierda = getCodigos(nodo.izquierda, prefix, w);
            prefix.deleteCharAt(prefix.length()-1);
 
            // Reccorer derecha
            prefix.append('1');
            String derecha = getCodigos(nodo.derecha, prefix,w);
            prefix.deleteCharAt(prefix.length()-1);
            
            if (izquierda==null) return derecha; else return izquierda;
        }
		return null;
    }

}

    

