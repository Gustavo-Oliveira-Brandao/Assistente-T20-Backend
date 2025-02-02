package ob.gustavo.assistentet20spring.controllers;

import ob.gustavo.assistentet20spring.exceptions.RegistroNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegistroNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RegistroNaoEncontrado exception){
        return exception.getMessage();
    }
}
