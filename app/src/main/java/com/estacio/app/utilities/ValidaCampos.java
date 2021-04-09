package com.estacio.app.utilities;

public class ValidaCampos {

    public static boolean NOME_COMPLETO(String nome){
        if(nome.isEmpty()){
            return false;
        }
        return true;
    }
}
