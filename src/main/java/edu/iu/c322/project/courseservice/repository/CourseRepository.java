package edu.iu.c322.project.courseservice.repository;

import edu.iu.c322.project.courseservice.model.Course;
import edu.iu.c322.project.courseservice.model.TimeSlot;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer>{
    @EntityGraph(attributePaths = "timeSlots")
    Optional<Course> findById(int id);
}
