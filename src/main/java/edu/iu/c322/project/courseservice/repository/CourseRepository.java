package edu.iu.c322.project.courseservice.repository;

import edu.iu.c322.project.courseservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Student, Integer>{

}
