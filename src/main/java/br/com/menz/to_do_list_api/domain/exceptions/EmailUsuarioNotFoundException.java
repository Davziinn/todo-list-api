package br.com.menz.to_do_list_api.domain.exceptions;

public class EmailUsuarioNotFoundException extends RuntimeException {
    public EmailUsuarioNotFoundException(String message) {
        super(message);
    }
}
