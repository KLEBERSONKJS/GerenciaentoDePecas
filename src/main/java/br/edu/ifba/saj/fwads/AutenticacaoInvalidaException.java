package br.edu.ifba.saj.fwads;

public class AutenticacaoInvalidaException extends Exception {

    public AutenticacaoInvalidaException(String login){
        super("Usuario (" + login + ") não foi encontrado ou a Senha está errada");
    }
}
