package com.example.core;

import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.domain.entity.Account;
import com.example.domain.entity.Status;
import com.example.domain.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreateUserDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;
    private final AccountRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        this.createAccount();

        this.alreadySetup = true;
    }

    public void createAccount() {
        var account = Account.builder()
                .id(UUID.randomUUID().toString())
                .owner("John Doe")
                .status(Status.builder()
                        .id(UUID.randomUUID().toString())
                        .name("ACTIVE")
                        .build())
                .build();

        this.repository.save(account);
    }

}
