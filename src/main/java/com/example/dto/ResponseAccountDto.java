package com.example.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseAccountDto {
    private String id;
    private String owner;
    private String status;
}
