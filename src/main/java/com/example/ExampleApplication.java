package com.example;

import com.example.domain.entity.Example;
import com.example.domain.entity.Example$;
import com.speedment.jpastreamer.application.JPAStreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class ExampleApplication {

	private final JPAStreamer streamer;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@GetMapping("/example")
	public ResponseEntity<Example> getExample(){
		Example example = new Example();
		example = streamer.stream(Example.class).filter(Example$.id.equal(1L)).findFirst().orElse(null);
		return ResponseEntity.ok(example);
	}

}
