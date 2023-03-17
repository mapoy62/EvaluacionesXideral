package com.xideral.storetracker.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerErrorResponse {
	
	private int status;
    private String message;
    private long timeStamp;

}
