package cn.com.vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties
@ComponentScan("cn.com.vector.play")
@SpringBootApplication
public class VectorPlayApplication {
	public static void main(String[] args) {
		SpringApplication.run(VectorPlayApplication.class, args);
	}
}
