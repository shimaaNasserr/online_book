package com.example.demo.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
private final int statusCode;
private final String message;
private final String error;

public ErrorResponse() {
	this.statusCode=HttpStatus.OK.value();
	this.message = "";
	this.error="";
}
}
