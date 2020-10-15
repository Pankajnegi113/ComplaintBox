package com.spring.boot.complaint.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public  final class ResponseHandler {
    private  ResponseHandler() {
    }

    @SuppressWarnings("rawtypes")
	public static ResponseEntity<ResponseDTO> generateResponse (HttpStatus status ,boolean isSuccess ,ResponseDTO responseObj,String message) {
		ResponseDTO responseDTO = new ResponseDTO(status.value(),isSuccess,responseObj,message);
        return  new ResponseEntity<>(responseDTO,status);
    }

}
