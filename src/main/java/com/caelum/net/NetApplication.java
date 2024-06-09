package com.caelum.net;

import com.caelum.net.unique.SecondUniversalClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetApplication {
	public static void main(String[] args) {
		SecondUniversalClass secondUniversalClass = new SecondUniversalClass();
		secondUniversalClass.run();
		SecondUniversalClass.FileExample();
		SpringApplication.run(NetApplication.class, args);
	}

}
