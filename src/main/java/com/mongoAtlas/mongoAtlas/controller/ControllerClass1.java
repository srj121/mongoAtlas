package com.mongoAtlas.mongoAtlas.controller;

import com.mongoAtlas.mongoAtlas.entity.Employees;
import com.mongoAtlas.mongoAtlas.service.ServiceLayer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RestController
public class ControllerClass1 {

    private final ServiceLayer serviceLayer;
     ControllerClass1(ServiceLayer serviceLayer)
     {this.serviceLayer = serviceLayer;}


    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();     //***Index view Page
        mav.setViewName("index");
        return mav;
    }
//..................................................................................................................


    @PostMapping("/main")
    public ModelAndView getMapping(@ModelAttribute Employees emp ) {
        System.out.println(emp);
        ModelAndView mav = new ModelAndView();          //***Index view Page
        mav.setViewName("view");
        mav.addObject("emp",emp);
        return mav;
    }

    //..................................................................................................................

    @GetMapping("/getEmp")
    public List<Employees> getEmp(){
        return serviceLayer.getEmpService();
    }

    @GetMapping("/getEmpresponse")
    public ResponseEntity<Employees> getEmpandresponse(){

        Employees emp = new Employees();
        emp.setId("id123");
        emp.setName("rahul");
        emp.setAddress("nagpur");

        serviceLayer.getEmpService();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }


    @GetMapping("/getEmpByName/{name}")
    public List<Employees> getEmpByName(@ModelAttribute Employees emp, @PathVariable ("name") String name){

         ModelAndView mav = new ModelAndView();
         mav.setViewName("view");
        mav.addObject("emp",emp);

        return  serviceLayer.getbyName(name);

    }

    @GetMapping("/getEmpById/{id}")
    public Employees getEmpById(@PathVariable ("id") String id, @ModelAttribute Employees emp){
        System.out.println(id);
        System.out.println("from the class " + emp.getId());

        return serviceLayer.getById(id);
    }

    @DeleteMapping("/deleteEmpById/{id}")
    public String deleteById( @PathVariable ("id") String id){
        serviceLayer.deleteById(id);
        return "Employee is Deleted";
    }

    @PostMapping("/addEmp")
    public Employees addEmp(@RequestBody Employees employ){
        serviceLayer.saveEmp(employ);

        return employ;
    }

}
