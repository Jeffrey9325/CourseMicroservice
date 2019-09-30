package com.everis.service;

import com.everis.model.Course;
import com.everis.model.Teacher;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TeacherMicroservice")
public interface TeacherClientRest {

  @GetMapping("/names/{fullName}")
  public List<Teacher> searchbyName(@PathVariable final String fullName);
  
  @GetMapping("/documents/{document}")
  public Teacher searchbyDocument(@PathVariable final String document);
  
  @GetMapping("/dates/{fromDate}/{toDate}")
  public List<Teacher> searchbyrankdateofBirth(
      @PathVariable @DateTimeFormat(iso = ISO.DATE) final Date fromDate,
      @PathVariable  @DateTimeFormat(iso = ISO.DATE)  final Date toDate);
  
  @PostMapping("/")
  public Teacher createTeacher(@Valid @RequestBody final Teacher teacher);

  @GetMapping("/")
  public Teacher allTeachers();

  @PutMapping("/{id}")
  public Teacher modifyTeacher(@PathVariable final String id,
      @Valid @RequestBody final Course course); 

  @DeleteMapping("/{id}")
  public void deleteTeacher(@PathVariable final String id);

}
