package puj.desarrolloweb.proyecto.exceptions;

import java.util.NoSuchElementException;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice 
public class MyCustomErrorController {

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNotFound(NoSuchElementException exception) {
        ModelAndView errorView = new ModelAndView("pagina-error");
        errorView.addObject("exceptionText", exception.toString());
        return errorView;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleErrorNoParam(MissingServletRequestParameterException exception) {
        ModelAndView errorView = new ModelAndView("pagina-error");
        errorView.addObject("exceptionText", exception.toString());
        return errorView;
    }

}