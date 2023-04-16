package edu.iu.c322.project.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String startTime;
    private String endTime;
    private String daysOfWeek;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", daysOfWeek='" + daysOfWeek + '\'' +
                ", course=" + course +
                '}';
    }
}
