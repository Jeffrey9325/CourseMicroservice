package com.everis.controller;

import com.everis.model.Course;
import com.everis.service.CourseServiceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * RestControllerCourse class.
 * @author jeffrey
 * @version v1.0
 */
@RestController
@RequestMapping("/Course/v1.0")
public class RestControllerCourse {

  /**
   * Student Service Implement.
   */
  @Autowired
  public CourseServiceImpl repository;
  /**
   * search by course identification course document.
   * @param idCourse course identification
   * @return
   */
  
  @GetMapping("/course/{idCourse}")
  public Flux<Course> searchbyIdCourse(@PathVariable final String idCourse) {
    return repository.searchbyIdCourse(idCourse);
  }
  /**
   * create record notes document.
   * @param course notes
   * @return
   */
  
  @PostMapping("/")
  public Mono<ResponseEntity<Course>> createCourse(@Valid @RequestBody final Course course) {
    double noteStudent = (course.getNoteone() + course.getNotetwo() + course.getNotethree()) / 3;
    course.setAverage(noteStudent);
    return repository.createCourse(course)
    .then(Mono.just(new ResponseEntity<Course>(HttpStatus.CREATED)))
    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  /**
   * show all record of notes document.
   * @return
   */
  
  @GetMapping("/")
  public Flux<Course> allCourse() {  
    return repository.allCourse();
  }
  /**
   * modify record of course document.
   * @param idCourse course identification
   * @param course course
   * @return
   */
  
  @PutMapping("/{idNotes}")
  public Mono<ResponseEntity<Course>> modifyNotes(@PathVariable final String idCourse,
      @Valid @RequestBody final Course course) {
    double noteStudent = (course.getNoteone() + course.getNotetwo() + course.getNotethree()) / 3;
    return repository.findbyId(idCourse)
    .flatMap(people -> {
      people.setIdCourse(idCourse);
      people.setFullName(course.getFullName());
      people.setStatus(course.getStatus());
      people.setMaximumQuantity(course.getMaximumQuantity());
      people.setMinimumquantity(course.getMinimumquantity());
      people.setNoteone(course.getNoteone());
      people.setNotetwo(course.getNotetwo());
      people.setNotethree(course.getNotethree());
      people.setAverage(noteStudent);
      return repository.modifyCourse(people);
    })
    .map(update -> new ResponseEntity<>(update, HttpStatus.OK))
    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  /**
   * delete record in course document.
   * @param idCourse course identification
   * @return
   */
 
  @DeleteMapping("/{idNotes}")
  public Mono<ResponseEntity<Void>> deleteNotes(@PathVariable final String idCourse) {
    return repository.findbyId(idCourse)
    .flatMap(notes ->
    repository.deleteCourse(notes)
    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))  
    )
    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
   
}
