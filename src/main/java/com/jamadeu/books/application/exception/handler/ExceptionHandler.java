package com.jamadeu.books.application.exception.handler;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@Order(-2)
public class ExceptionHandler extends AbstractErrorWebExceptionHandler {
    ErrorAttributes errorAttributes;
    Resources resources;
    ApplicationContext applicationContext;
    ServerCodecConfigurer codecConfigurer;

    public ExceptionHandler(ErrorAttributes errorAttributes, Resources resources, ApplicationContext applicationContext) {
        super(errorAttributes, resources, applicationContext);
        this.errorAttributes = errorAttributes;
        this.resources = resources;
        this.applicationContext = applicationContext;
        this.setMessageWriters(this.codecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
    }

    private Mono<ServerResponse> formatErrorResponse(ServerRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        int status = (int) errorAttributes.getOrDefault("status", 500);
        return ServerResponse.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorAttributes));
    }
}
