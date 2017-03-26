/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hd7;

/**
 *
 * @Juan Carlos Solís Cruz 
 */
class NodoHuffman extends ArbolHuffman {
    public final ArbolHuffman izquierda,derecha; // sub-�rvores
 
    public NodoHuffman(ArbolHuffman l, ArbolHuffman r) {
        super(l.frecuencia + r.frecuencia);
        izquierda = l;
        derecha = r;
    }
}