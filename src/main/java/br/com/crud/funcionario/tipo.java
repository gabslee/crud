package br.com.crud.funcionario;

public enum tipo {

    COLABORADOR(1),
    ADMINISTRADOR(2);

    private final int tipo;

    tipo(int i) {
        this.tipo = i;
    }

    public int getTipo() {
        return tipo;
    }
    public static tipo toTipo(int i){
        switch (i){
            case 1: return COLABORADOR;
            case 2: return ADMINISTRADOR;
            default: return COLABORADOR;
        }
    }
}
