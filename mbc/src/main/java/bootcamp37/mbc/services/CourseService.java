/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Course;
import bootcamp37.mbc.repositories.CourseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class CourseService {
    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public List<Course> getAll(){
        return courseRepository.findAll();
    }
    
    public Optional<Course> getById(String id){
        Optional<Course> course = courseRepository.findById(id);
        return course;
    }
    
    public boolean updateCourse (Course course){
        Optional<Course> courseOptional = getById(course.getId());
        if(courseOptional.isPresent()){
            Course update = courseOptional.get();
            update.setName(course.getName());
            courseRepository.save(update);
            return true;
        }
        return false;
    }
    
    public Course save(Course course){
        boolean courseCheck = getById(course.getId()).isPresent();
        Course cr = null;
        try {
            return cr = courseRepository.save(course);
        } catch (Exception e) {
            System.out.println(e);
            return cr;
        }
    }
    
        public boolean delete(String id){
        try {
            Course cr = getById(id).get();
            System.out.println(cr.toString());
            courseRepository.delete(cr);
            System.out.println(getById(id).get().toString()+" ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
