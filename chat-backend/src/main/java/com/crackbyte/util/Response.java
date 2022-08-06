package com.crackbyte.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class Response {
    private Object data;
    private String errorMessage;
    private String errorCode;

    public static ResponseEntity<Response>  build(Object data){
        return ResponseEntity.ok(Response.builder().data(data).build());
    }
}
