package com.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

/**
 * NotesMicroserviceApplication class.
 * @author jeffrey
 * @version v1.0
 */
@EnableEurekaClient
@EnableSwagger2WebFlux
@SpringBootApplication
public class CourseMicroserviceApplication {
  /**
   * main method.
   * @param args arguments.
   */

  public static void main(final String[] args) {
    SpringApplication.run(CourseMicroserviceApplication.class, args);
  }

}
