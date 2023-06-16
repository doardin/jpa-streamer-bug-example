package com.example;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entity.Account;
import com.example.dto.ResponseAccountDto;
import com.speedment.jpastreamer.application.JPAStreamer;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class ExampleApplication {

    private final JPAStreamer streamer;

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    private ResponseAccountDto mapToDto(Account account) {
        return ResponseAccountDto.builder()
                .id(account.getId())
                .owner(account.getOwner())
                .status(account.getStatus().getName())
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<ResponseAccountDto> helloWord() {
        return streamer.stream(Account.class).map(this::mapToDto).collect(Collectors.toList());
    }

}
