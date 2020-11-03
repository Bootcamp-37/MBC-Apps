/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.controllers;

import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.entities.Course;
import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.entities.Kelas;
import bootcamp37.mbc.services.BatchServices;
import bootcamp37.mbc.services.CourseServices;
import bootcamp37.mbc.services.KelasServices;
import bootcamp37.mbc.viewmodel.BatchVM;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Deo Lahara
 */
@ResponseBody
@RequestMapping("/class")
@Controller
public class KelasController {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat StringFormat = new SimpleDateFormat("yyyy-MM-dd");
    CourseServices courseServices;
    BatchServices batchServices;
    KelasServices kelasServices;
    
    @Autowired
    public KelasController(CourseServices courseServices, BatchServices batchServices, KelasServices kelasServices) {
        this.courseServices = courseServices;
        this.batchServices = batchServices;
        this.kelasServices = kelasServices;
    }
/////////////////////////////////////////KELAS//////////////////////////////////////////
    //Read
    //GetAll
    @ResponseBody
    @GetMapping("/")
    public List<Kelas> getAllKelas() {
        return kelasServices.getAllKelas();
    }

    //GetByID
    @ResponseBody
    @GetMapping("/ID/{idkelas}")
    public Kelas getByIdKelas(@PathVariable String idkelas) {
        return kelasServices.getByIdKelas(idkelas).get();
    }

    //CRUD
    //Insert Kelas By Json
    @PostMapping("")
    public Kelas insertKelasJson(@RequestBody Kelas kelas) {
        kelas.setId(" ");
        Kelas result = kelasServices.save(kelas);
        return result;
    }

    //Insert Kelas By Netbeans
    @ResponseBody
    @GetMapping("/insertkelas")
    public String insertKelas() {
        Kelas kelas = null;
        try {
            String id = " ";
            String employee = "E005";
            Employee emp = new Employee(employee);
            String batch = "BC001";
            Batch bc = new Batch(batch);
            String Status = "Graduated";
            kelas = new Kelas(id, Status, bc, emp);
            Kelas cr = kelasServices.save(kelas);
            return "kelas: " + cr.toString();
        } catch (Exception ex) {
            return "failed";
        }
    }

    //Update Kelas
    @ResponseBody
    @PutMapping("/{idbatch}/{idemployee}")
    public boolean updateKelas(@RequestBody Kelas kelas, @PathVariable String idbatch, @PathVariable String idemployee ) {
        kelas.setBatch(new Batch(idbatch));
        kelas.setEmployee(new Employee(idemployee));
        return kelasServices.updateKelas(kelas);
    }

    //Delete Kelas Method DeleteMapping
    @ResponseBody
    @DeleteMapping("{idkelas}")
    public Map<String, String> deleteKelas(@PathVariable String idkelas) {
        boolean isSuccess = kelasServices.deleteMapping(idkelas);
        Map<String, String> status = new HashMap<>();
        if (isSuccess) {
            status.put("status", "200");
            return status;
        } else {
            return status;
        }
    }
    
    //Delete Kelas Method GetMapping
    @ResponseBody
    @GetMapping("/delete/{idkelas}")
    public String kelasDelete(@PathVariable String idkelas) {
        System.out.println(idkelas);
        return kelasServices.deleteNetbeans(idkelas);
    }
    
/////////////////////////////////////////COURSE//////////////////////////////////////////
    //Read
    //GetAll
    @ResponseBody
    @GetMapping("/course")
    public List<Course> getAllCourse() {
        return courseServices.getAllCourse();
    }

    //GetByID
    @ResponseBody
    @GetMapping("/course/{idcourse}")
    public Course getByIdCourse(@PathVariable String idcourse) {
        return courseServices.getByIdCourse(idcourse).get();
    }

    //CRUD
    //Insert Course By Json
    @PostMapping("/course")
    public Course insertCourseJson(@RequestBody Course course) {
        course.setId(" ");
        Course result = courseServices.save(course);
        return result;
    }

    //Insert Course By Netbeans
    @ResponseBody
    @GetMapping("/course/insertcourse")
    public String insertCourse() {
        Course course = null;
        try {
            String id = " ";
            String name = "Test";

            course = new Course(id, name);
            Course cr = courseServices.save(course);
            return "course: " + cr.toString();
        } catch (Exception ex) {
            return "failed";
        }
    }

    //Update Course
    @PutMapping("/course")
    public boolean updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }

    //Delete Course Method DeleteMapping
    @DeleteMapping("/course/{idcourse}")
    public Map<String, String> deleteCourse(@PathVariable String idcourse) {
        boolean isSuccess = courseServices.deleteMapping(idcourse);
        Map<String, String> status = new HashMap<>();
        if (isSuccess) {
            status.put("status", "200");
            return status;
        } else {
            return status;
        }
    }

    //Delete Course Method GetMapping
    @ResponseBody
    @GetMapping("/course/delete/{idcourse}")
    public String courseDelete(@PathVariable String idcourse) {
        return courseServices.deleteNetbeans(idcourse);
    }

/////////////////////////////////////////BATCH//////////////////////////////////////////
    //Read
    //GetAll
    @GetMapping("/batch")
    public List<BatchVM> getAllBatch() {
//        batchServices.saveAll();
        System.out.println(batchServices.getAllBatch());
        return batchServices.getAllBatch();
    }

    //GetById
    @ResponseBody
    @GetMapping("/batch/id/{idbatch}")
    public BatchVM getByIdBatch(@PathVariable String idbatch) {
        System.out.println(idbatch);
        Batch batch = batchServices.getByIdBatch(idbatch).get();
        String startDate = dateFormat.format(batch.getStartDate());
        String endDate = dateFormat.format(batch.getEndDate());
        BatchVM v = new BatchVM(batch.getId(), batch.getName(), startDate, endDate, batch.getCourse().getId(), batch.getEmployee().getId());
        return v;
    }

    //CRUD
    //Insert Batch By Json
    @PostMapping("/batch")
    public Batch insertBatchJson(@RequestBody Batch batch) {
        batch.setId(" ");
        Batch result = batchServices.save(batch);
        return result;
    }
    
    //Insert Course By Netbeans
    @ResponseBody
    @GetMapping("/batch/insertbatch")
    public String insertBatch() {
        Batch batch = null;
        try {
            String id = " ";
            String name = "Test Netbeans";
            String startDate = "2020-11-01 12:00:00";
            String endDate = "2020-11-01 12:00:00";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = formatter.parse(startDate);
            Date end = formatter.parse(endDate);
            String course = "CR001";
            Course cs = new Course(course);
            String employee = "E007";
            Employee emp = new Employee(employee);
            

            batch = new Batch(id, name, start, end, cs, emp);
            Batch bc = batchServices.save(batch);
            return "batch: " + batch.toString();
        } catch (Exception ex) {
            return "failed";
        }
    }
    
    //Update Course
    @PutMapping("/batch")
    public boolean updateBatch(@RequestBody Batch batch) {
        return batchServices.updateBatch(batch);
    }

    //Delete Course Method DeleteMapping
    @DeleteMapping("/batch/{batch}")
    public Map<String, String> deleteBatch(@PathVariable String idbatch) {
        boolean isSuccess = batchServices.deleteMapping(idbatch);
        Map<String, String> status = new HashMap<>();
        if (isSuccess) {
            status.put("status", "200");
            return status;
        } else {
            return status;
        }
    }

    //Delete Course Method GetMapping
    @ResponseBody
    @GetMapping("/batch/delete/{idbatch}")
    public String batchDelete(@PathVariable String idbatch) {
        return batchServices.deleteNetbeans(idbatch);
    }

}
