package com.everis.service;

import com.everis.model.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ICourseService interface.
 * @author jeffrey
 * @version v1.0
 */

public interface ICourseService {
  /**
   * search by course identification course document.
   * @param idCourse course identification
   * @return
   */

  Flux<Course> searchbyIdCourse(String idCourse);
  /**
   * create record course document.
   * @param course course
   * @return
   */
  
  Mono<Course> createCourse(Course course);
  /**
   * show all course of course document.
   * @return
   */
  
  Flux<Course> allCourse();
  /**
   * modify record course document.
   * @param course course
   * @return
   */
  
  Mono<Course> modifyCourse(Course course);
  /**
   * delete record of course document.
   * @param course course
   * @return
   */
  
  Mono<Void> deleteCourse(Course course);
  /**
   * find by id course document.
   * @param idCourse course identification
   * @return
   */
  
  Mono<Course> findbyId(String idCourse);
  
}