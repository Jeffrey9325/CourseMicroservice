package com.everis.repository;

import com.everis.model.Course;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ReactiveRepository interface.
 * @author jeffrey
 * @version v1.0
 */

@Repository
public interface ReactiveRepository extends ReactiveMongoRepository<Course, Serializable> {
  /**
   * find by course identification course document.
   * @param idCourse course identification
   * @return
   */
  Flux<Course> findByIdCourse(String idCourse);
 
}
