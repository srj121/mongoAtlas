package com.mongoAtlas.mongoAtlas.controller;

import com.mongoAtlas.mongoAtlas.entity.Employees;
import com.mongoAtlas.mongoAtlas.service.ServiceLayer;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class ControllerClass1 {
    private static final Logger logger = LoggerFactory.getLogger(ControllerClass1.class);
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
       logger.info("{}",emp);
        ModelAndView mav = new ModelAndView();          //***Index view Page
        mav.setViewName("view");
        mav.addObject("emp",emp);
        return mav;
    }
    //..................................................................................................................

    @GetMapping("/getall")
    public ModelAndView getEmp(){
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("emp", serviceLayer.getEmpService());
        serviceLayer.getEmpService();
        return mav;
    }
    @GetMapping("/getEmpByName/{name}")
    public ModelAndView getEmpByName(@PathVariable ("name") String name){

        ModelAndView mav = new ModelAndView("view");
        mav.addObject("emp",serviceLayer.getbyName(name));
        serviceLayer.getbyName(name);
        return mav;

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


    @GetMapping("/getEmpById/{id}")
    public Employees getEmpById(@PathVariable ("id") String id, @ModelAttribute Employees emp){
        logger.info(id);

        System.out.println("from the class " + emp.getId());
        return serviceLayer.getById(id);
    }

    @DeleteMapping("/deleteEmpById/{id}")
    public ModelAndView  deleteById( @PathVariable ("id") String id){
        ModelAndView mav = new ModelAndView("view");
        mav.addObject("emp", serviceLayer.deleteById(id));
        serviceLayer.deleteById(id);                                          //*** Delete API
        return mav;
    }

    @RequestMapping("/post")
        public ModelAndView postPage(){
         ModelAndView mav = new ModelAndView("post");
         return mav;
        }

    @PostMapping("/addEmp")
    public ModelAndView addEmp(@RequestBody Employees employ){
         ModelAndView mav = new ModelAndView("view");
        System.out.println(employ);
         mav.addObject("emp", serviceLayer.saveEmp(employ));
        serviceLayer.saveEmp(employ);                                          //Post API

        return mav;
    }
}
