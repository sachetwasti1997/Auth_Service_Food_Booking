package com.sachet.AuthService.exception;


import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

//@Component
//@Order(-2)
//public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {
//
//
//  public GlobalExceptionHandler(ErrorAttributes errorAttributes,
//                                WebProperties.Resources resources,
//                                ApplicationContext applicationContext,
//                                ServerCodecConfigurer configurer) {
//    super(errorAttributes, resources, applicationContext);
//    this.setMessageReaders(configurer.getReaders());
//    this.setMessageWriters(configurer.getWriters());
//  }
//
//  @Override
//  protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//    System.out.println(errorAttributes);
//    return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
//  }
//
//  private Mono<ServerResponse> formatErrorResponse(ServerRequest request) {
//    Throwable error = getError(request);
//    Map<String, Object> errorAttributesMap = new HashMap<>();
//    errorAttributesMap.put("status", 500);
//    if (error instanceof EmailAlreadyInUse emailAlreadyInUse) {
//      errorAttributesMap.put("error", emailAlreadyInUse.getMessage());
//      errorAttributesMap.put("url", request.path());
//      errorAttributesMap.put("status", emailAlreadyInUse.getStatus());
//    } else if (error instanceof MethodArgumentNotValidException validationException){
//      errorAttributesMap.put("error", validationException.getMessage());
//      errorAttributesMap.put("url", request.path());
//      errorAttributesMap.put("status", 400);
//    }
//
//    return ServerResponse
//        .status(HttpStatusCode.valueOf((Integer) errorAttributesMap.get("status")))
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(BodyInserters.fromValue(errorAttributesMap));
//  }
//}
//@RestControllerAdvice
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
//public class GlobalExceptionHandler{
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public void handleArgumentException(MethodArgumentNotValidException ex) {
//    System.out.println(ex.getMessage());
//    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
//  }
//
//  @ExceptionHandler(EmailAlreadyInUse.class)
//  public void handleEmailAlreadyException(EmailAlreadyInUse ex) {
//    System.out.println(ex.getMessage());
//    var exc = new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getErrorMessage());
//    exc.setDetail(ex.getErrorMessage());
//    throw exc;
//  }
//}