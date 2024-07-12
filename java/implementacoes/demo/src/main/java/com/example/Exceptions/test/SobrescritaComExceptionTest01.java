package com.example.Exceptions.test;

import com.example.Exceptions.dominio.Funcionario;
import com.example.Exceptions.dominio.Pessoa;

public class SobrescritaComExceptionTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario func = new Funcionario();

        func.salvar();
    }
}
