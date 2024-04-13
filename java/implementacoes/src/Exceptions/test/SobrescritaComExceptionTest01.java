package Exceptions.test;

import Exceptions.dominio.Funcionario;
import Exceptions.dominio.Pessoa;

public class SobrescritaComExceptionTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario func = new Funcionario();

        func.salvar();
    }
}
