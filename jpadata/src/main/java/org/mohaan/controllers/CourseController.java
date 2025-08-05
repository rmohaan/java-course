package org.mohaan.controllers;

import java.util.List;
import org.mohaan.models.CourseDto;
import org.mohaan.services.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/")
    public CourseDto createCourse(@RequestBody CourseDto course) {
        return courseService.addCourse(course);
    }

    @PatchMapping("/{id}")
    public CourseDto updateCourse(@RequestBody CourseDto course, @PathVariable Integer id) {
        return courseService.updateCourse(course, id);
    }

    @PatchMapping("/{id}/authors")
    public CourseDto updateCourseAuthors(@RequestBody CourseDto course, @PathVariable Integer id) {
        return courseService.updateCourseAuthors(course, id);
    }

    @GetMapping("/")
    public List<CourseDto> getCourses() {
        return courseService.getAllCourses();
    }

}
