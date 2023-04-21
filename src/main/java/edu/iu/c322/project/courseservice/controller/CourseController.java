package edu.iu.c322.project.courseservice.controller;

import edu.iu.c322.project.courseservice.model.Course;
import edu.iu.c322.project.courseservice.model.TimeSlot;
import edu.iu.c322.project.courseservice.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/course")
    public List<Course> findAll(){
        return repository.findAll();
    }

    @GetMapping("/course/{courseId}")
    public Course find(@PathVariable int courseId){
        return repository.findById(courseId).orElse(null);
    }


    @PostMapping("/course")
    public int addCourse(@RequestBody Course course){
        for(int i = 0; i < course.getTimeSlots().size(); i++){
            TimeSlot timeSlot = course.getTimeSlots().get(i);
            timeSlot.setCourse(course);
        }

        Course newCourse = repository.save(course);
        return newCourse.getId();
    }


    @PutMapping("/course/{courseId}")
    public void updateCourse(@PathVariable int courseId, @RequestBody Course course){
        course.setId(courseId);
        repository.save(course);
    }

    @DeleteMapping("/course/{courseId}")
    public void delete(@PathVariable int courseId){
        Course course = new Course();
        course.setId(courseId);
        repository.delete(course);
    }



}
