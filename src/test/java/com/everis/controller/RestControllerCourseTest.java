package com.everis.controller;

import com.everis.model.Course;
import com.everis.repository.ReactiveRepository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RestControllerCourseTest {

  @Autowired
  private ApplicationContext applicationContext;
  @Autowired
  private ReactiveRepository repository;
  
  private WebTestClient client;
  private List<Course> expectedProducts;

  
  /**
   * setup.
   */
//  @BeforeEach
//  public void setUp() {
//    client = WebTestClient
//      .bindToApplicationContext(applicationContext)
//      .configureClient()
//      .baseUrl("/Course/v1.0/")
//      .build();
//
//    Flux<Course> initData = repository.deleteAll()
//        .thenMany(Flux.just(
//        Course.builder()
//        .idNotes("14").idCourse("c1").idTeacher("t1").idStudent("s2")
//        .noteone(14).notetwo(14).notethree(14).average(14).build(),
//        Course.builder()
//        .idNotes("15").idCourse("c1").idTeacher("t1").idStudent("s2")
//        .noteone(15).notetwo(15).notethree(15).average(15).build())
//        .flatMap(repository::save))
//        .thenMany(repository.findAll());
//
//    expectedProducts = initData.collectList().block();
//  }

  @Test
  public void searchbyIdCourse() {

    String idCourse = "c1";
    client.get().uri("/course/{idCourse}", idCourse).exchange()
    .expectStatus().isOk();

  }

  @Test
  public void createNotes() {

    Course expectedProduct = expectedProducts.get(0);

    client.post().uri("/").body(Mono.just(expectedProduct), Course.class).exchange()
    .expectStatus().isCreated();

  }

  @Test
  public void allNotes() {

    client.get().uri("/").exchange()
    .expectStatus().isOk();
  }

  @Test
  public void modifyNotes() {

    Course expectedProduct = expectedProducts.get(0);

    client.put().uri("/{idNotes}", expectedProduct.getIdCourse())
    .body(Mono.just(expectedProduct), Course.class).exchange()
    .expectStatus().isOk();
    
  }

  @Test
  public void deleteNotes() {

    Course productToDelete = expectedProducts.get(0);
    client.delete().uri("/{idNotes}", productToDelete.getIdCourse()).exchange()
    .expectStatus().isNoContent();
  }  
}
