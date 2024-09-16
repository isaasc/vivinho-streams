package com.vivo.vivinho_streams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class VivinhoStreamsApplication {
	public static void main(String[] args) {
		SpringApplication.run(VivinhoStreamsApplication.class, args);
	}
}
