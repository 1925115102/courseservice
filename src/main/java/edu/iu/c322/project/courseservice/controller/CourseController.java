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

    @GetMapping
    public List<Course> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Course find(@PathVariable int id){
        return repository.findById(id).orElse(null);
    }


    @PostMapping
    public int addCourse(@RequestBody Course course){
        for(int i = 0; i < course.getTimeSlots().size(); i++){
            TimeSlot timeSlot = course.getTimeSlots().get(i);
            timeSlot.setCourse(course);
        }

        Course newCourse = repository.save(course);
        return newCourse.getId();
    }


    @PutMapping("/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody Course course){
        course.setId(id);
        repository.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Course course = new Course();
        course.setId(id);
        repository.delete(course);
    }



}
