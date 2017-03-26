package hd7;

class HojaHuffman extends ArbolHuffman {
    public final char valor; 
    public HojaHuffman(int frecuencia, char valor) {
        super(frecuencia);
        this.valor = valor;
    }
}