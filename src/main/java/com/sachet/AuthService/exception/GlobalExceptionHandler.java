package com.sachet.AuthService.exception;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
@Order(-2)
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {


  public GlobalExceptionHandler(ErrorAttributes errorAttributes,
                                WebProperties.Resources resources,
                                ApplicationContext applicationContext,
                                ServerCodecConfigurer configurer) {
    super(errorAttributes, resources, applicationContext);
    this.setMessageReaders(configurer.getReaders());
    this.setMessageWriters(configurer.getWriters());
  }

  @Override
  protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
    System.out.println(errorAttributes);
    return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
  }

  private Mono<ServerResponse> formatErrorResponse(ServerRequest request) {
    Throwable error = getError(request);
    Map<String, Object> errorAttributesMap = new HashMap<>();
    errorAttributesMap.put("status", 500);
    if (error instanceof EmailAlreadyInUse emailAlreadyInUse) {
      errorAttributesMap.put("error", emailAlreadyInUse.getMessage());
      errorAttributesMap.put("url", request.path());
      errorAttributesMap.put("status", emailAlreadyInUse.getStatus());
    }

    return ServerResponse
        .status((HttpStatusCode) errorAttributesMap.get("status"))
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(errorAttributesMap));
  }
}
