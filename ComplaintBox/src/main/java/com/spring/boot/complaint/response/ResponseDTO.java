package com.spring.boot.complaint.response;
import java.time.LocalDate;
import java.util.List;

import com.spring.boot.complaint.dto.AdminCompDTO;

public class ResponseDTO <T> {
    private int status;
    private boolean success;
    private  T data;
    private LocalDate timeStamp = LocalDate.now();
    private String message;

    public ResponseDTO()
    {
    	
    }
    public ResponseDTO (int status ,boolean success,T data, String message) {
        this.status =status;
        this.success = success;
        this.data = data;
        this.message = message;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
