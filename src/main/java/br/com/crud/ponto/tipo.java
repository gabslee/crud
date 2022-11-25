package br.com.crud.ponto;

public enum tipo {

    ENTRADA(1),
    SAIDA(2);

    private final int tipo;

    tipo(int i) {
        this.tipo = i;
    }

    public int getTipo() {
        return tipo;
    }
    public static tipo toTipo(int i){
        switch (i){
            case 1: return ENTRADA;
            case 2: return SAIDA;
            default: return ENTRADA;
        }
    }

}
