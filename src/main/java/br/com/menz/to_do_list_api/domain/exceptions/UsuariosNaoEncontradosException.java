package br.com.menz.to_do_list_api.domain.exceptions;

public class UsuariosNaoEncontradosException extends RuntimeException {
    public UsuariosNaoEncontradosException(String message) {
        super(message);
    }
}
