package com.example.Exceptions.test;

import java.util.Scanner;

import com.example.Exceptions.dominio.LoginInvalidoException;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
        
    }

    private static void logar() throws LoginInvalidoException{
        Scanner teclado = new Scanner(System.in);

        String usernameDB = "Goku";
        String passwordDB = "ssj";
        System.out.println("Usuário: ");
        String userDigitado = teclado.nextLine();
        System.out.println("Senha: ");
        String senhaDigitada = teclado.nextLine();
        
        if (!usernameDB.equals(userDigitado) || !passwordDB.equals(senhaDigitada)) {
            throw new LoginInvalidoException("Usuário ou senha inválido");
        }
        
        teclado.close();
        System.out.println("Usuário logado com sucesso");
    }
}
