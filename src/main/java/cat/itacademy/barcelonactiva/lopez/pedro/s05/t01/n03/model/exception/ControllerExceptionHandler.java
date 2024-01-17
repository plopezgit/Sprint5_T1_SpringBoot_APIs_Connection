package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.model.exception;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.util.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiMessage> httpClientErrorExceptionHandler(HttpClientErrorException exception) {

        return new ResponseEntity<>(new ApiMessage(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<List<ApiMessage>> validationExceptionHandler(MethodArgumentNotValidException exception) {

        List<ApiMessage> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(error ->
                errors.add(new ApiMessage(HttpStatus.NOT_ACCEPTABLE.value(), error.getDefaultMessage(), new Date())));

        return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiMessage> restClientExceptionHandler(RestClientException exception) {

        return new ResponseEntity<>(new ApiMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpServerErrorException.GatewayTimeout.class)
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    public String gatewayTimeout() {
        return "errors/error-timeout";
    }

}

