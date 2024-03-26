package com.example.demo.dto;

import java.util.List;

import lombok.Data;
@Data
public class TransactionDto {
private Integer userId;
private List<BookCartDto> books;

}
