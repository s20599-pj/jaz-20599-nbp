package pjatk.jaz20599nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    //400
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponseEntity<String> handleRuntimeException(RuntimeException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request :C Error:" + e.getLocalizedMessage());
    }
    //404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono wpisów :C Error: " + e.getLocalizedMessage());
    }
}
