package com.prizma.prizma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //It handles all eception handling in all controller
public class GlobalExceptionHandler {
    // Logger is used for debugging and monitoring
    // GlobalExceptionHandler.class we have oly used for this class
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    // Exception see which exception is shown
    public String handleException(Exception exception, Model model) {
        logger.error("Error occurred: ", exception);// Tells which error occured
        model.addAttribute("errorMessage", exception.getMessage());
        return "error";
    }
}
