package edu.iu.c322.project.courseservice.repository;

import edu.iu.c322.project.courseservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
