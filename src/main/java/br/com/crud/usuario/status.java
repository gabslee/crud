package br.com.crud.usuario;

import java.util.Optional;

public enum status {
    ATIVO(1),
    INATIVO(2);

    private int status;
    status(int i) {
        this.status = i;
    }


    public int getStatus() {
        return this.status;
    }

    public static status toStatus(int i) {
        switch (i){
            case 1: return ATIVO;
            case 2: return INATIVO;
            default: return ATIVO;

        }
    }



}
