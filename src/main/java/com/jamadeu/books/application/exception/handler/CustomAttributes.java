package com.jamadeu.books.application.exception.handler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Component
public class CustomAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options);
        Throwable exception = getError(request);
        if(exception instanceof ResponseStatusException){
            errorAttributes.put("message", exception.getMessage());
            errorAttributes.put("developerMessage", "A ResponseStatusException Happened");
            return errorAttributes;
        }
        return errorAttributes;
    }
}
