/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.controllers;

import bootcamp37.mbc.entities.Course;
import bootcamp37.mbc.services.CourseServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Deo Lahara
 */

@RequestMapping("Class")
@RestController
public class CourseController {
    
    CourseServices courseServices;

    @Autowired
    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }
    
    @GetMapping("")
    public List<Course> getAll() {
        return courseServices.getAll();
    }

    @GetMapping("{id}")
    public Course getById(@PathVariable String id) {
        return courseServices.getById(id).get();
    }


    @PostMapping("")
    public Course insert(@RequestBody Course course) {
        course.setId(" ");
        Course result = courseServices.save(course);
        return result;
    }
    
    @PutMapping("")
    public boolean update(@RequestBody Course course){
        return courseServices.updateCourse(course);
    }
    
    @DeleteMapping("{id}")
    public Map<String,String> delete(@PathVariable String id){
        boolean isSuccess = courseServices.delete(id);
        Map<String, String> status = new HashMap<>();
        if (isSuccess) {
            status.put("status", "200");
            return status;
        }else{
            return status;
        }
    }
    
//    @ResponseBody
//    @GetMapping("/insertall")
//    public List<Course> saveAll(){
//        Course course = new Course();
//        courseServices.saveAll();
//        System.out.println(courseServices.getAll().toString());
//    return courseServices.saveAll();
//}
    
    
}
