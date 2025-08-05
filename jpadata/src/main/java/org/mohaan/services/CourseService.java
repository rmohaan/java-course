package org.mohaan.services;

import org.mohaan.entities.Course;
import org.mohaan.mappers.CourseMapper;
import org.mohaan.models.CourseDto;
import org.mohaan.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseDto addCourse(CourseDto course) {
        var savedEntity = courseRepository.save(courseMapper.toEntity(course));
        return courseMapper.toModel(savedEntity);
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toModel)
                .toList();
    }

    public CourseDto updateCourse(CourseDto courseModel, Integer id) {
        var course = courseMapper.toEntity(courseModel);
        var success = courseRepository.updateCourseById(course.getName(), course.getDescription(), id);
        if (success == 1) {
            var updatedCourse= courseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
            return  courseMapper.toModel(updatedCourse);
        }
        return null;
    }

    public CourseDto updateCourseAuthors(CourseDto courseModel, Integer id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        course.setAuthors(courseModel.getAuthors());
        var updatedCourse = courseRepository.save(course);
        return courseMapper.toModel(updatedCourse);
    }
}
