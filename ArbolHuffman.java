
package hd7;



abstract class ArbolHuffman implements Comparable<ArbolHuffman> {
    public final int frecuencia; // Fecuencia de las letras 
    //
    public ArbolHuffman(int frecuencia) { 
    	this.frecuencia = frecuencia; 
    }
    
    // Se implementa la iinterfaz para poder comparar 
    public int compareTo(ArbolHuffman tree) {
        return frecuencia - tree.frecuencia;
    }
} 