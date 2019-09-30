package com.everis.service;

import com.everis.model.Course;
import com.everis.repository.ReactiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * NotesServiceImpl class.
 * @author jeffrey
 * @version v1.0
 */

@Service
public class CourseServiceImpl implements ICourseService {
  /**
   * Reactive Repository.
   */
  @Autowired
  private ReactiveRepository repository;
  
  @Override
  public Flux<Course> searchbyIdCourse(final String idCourse) {
    return repository.findByIdCourse(idCourse);
  }
 
  @Override
  public Mono<Course> createCourse(final Course course) {
    return repository.save(course);
  }

  @Override
  public Flux<Course> allCourse() {
    return repository.findAll();
  }

  @Override
  public Mono<Course> modifyCourse(final Course course) {
    return repository.save(course);
  }

  @Override
  public Mono<Void> deleteCourse(final Course course) {
    return repository.delete(course);
  }

  @Override
  public Mono<Course> findbyId(String idCourse) {
    return repository.findById(idCourse);
  }

}
