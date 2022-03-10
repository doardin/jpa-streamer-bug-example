package com.example.core;

import com.example.domain.entity.Example;
import com.example.domain.repository.ExampleRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreateUserDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    
    private Boolean alreadySetup = false;
    private final ExampleRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        
        if (this.alreadySetup) return;

        this.createUserIfNotFound();
        
        this.alreadySetup = true;
    }

    private void createUserIfNotFound() {
        
        Example example = this.repository.findById(1L).orElse(null);
        if(example == null){
            example = new Example();
            example.setId(1L);
            example.setName("Eduardo");
            example.setActive(true);
        }

        this.repository.save(example);
    }

}
