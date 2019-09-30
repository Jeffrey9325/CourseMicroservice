package com.everis.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Notes class.
 * @author jeffrey
 * @version v1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "courses")
@JsonPropertyOrder({"idCourse", "fullName", "status", "maximumQuantity", "minimumquantity",
    "idCourse", "idTeacher", "idStudent", "noteone", "notetwo", "notethree", "average"})
public class Course {

  /**
   * course identification.
   */
  @Id
   private String idCourse;
  /**
   * full name.
   */
  @NotEmpty(message = "should not be empty")
  private String fullName;
  /**
   * status.
   */
  @NotEmpty(message = "should not be empty")
  private String status;
  /**
   * maximum Quantity.
   */
  @NotEmpty(message = "should not be empty")
  private String maximumQuantity;
  /**
   * minimum quantity.
   */
  @NotEmpty(message = "should not be empty")
  private String minimumquantity;
  /**
   * teacher identification.
   */
  @NotEmpty(message = "should not be empty")
  private String idTeacher;
  
  /**
   *student identification.
   */
  @NotEmpty(message = "should not be empty")
  private String idStudent;
  /**
   * note one.
   */
  private int noteone;
  /**
   * note two.
   */
  private int notetwo;
  /**
   * note three.
   */
  private int notethree;
  /**
   * average.
   */
  private double average;
  
  
//  /**
//   *  Notes. 
//   * @param noteone note one
//   * @param notetwo note two
//   * @param notethree note three
//   */
//  
//  public Notes(int noteone, int notetwo, int notethree) {
//      
//    this.average = (noteone + notetwo + notethree) / 3;
//    this.setAverage(this.average);
//      
//  }
    
}