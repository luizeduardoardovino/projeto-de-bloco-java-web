package br.edu.infnet.appAgricola.model.exceptions;

public class UsuarioJaExisteException extends Exception{
    public UsuarioJaExisteException(String mensagem) {
        super(mensagem);
    }

}
