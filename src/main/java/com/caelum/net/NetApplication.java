package com.caelum.net;

import com.caelum.net.unique.SecondUniversalClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetApplication {
	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			System.out.println(SecondUniversalClass.fizzBuzz(i));
		}

		SpringApplication.run(NetApplication.class, args);
	}

}
