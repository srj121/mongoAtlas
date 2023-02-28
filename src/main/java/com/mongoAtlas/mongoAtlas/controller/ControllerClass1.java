package com.mongoAtlas.mongoAtlas.controller;

import com.mongoAtlas.mongoAtlas.entity.Employees;
import com.mongoAtlas.mongoAtlas.service.ServiceLayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class ControllerClass1 {
    private static final Logger logger = LoggerFactory.getLogger(ControllerClass1.class);
    private static final String page = "list-employees";
    private final ServiceLayer serviceLayer;
     ControllerClass1(ServiceLayer serviceLayer)
     {this.serviceLayer = serviceLayer;}

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");        //***Index Page
        return mav;
    }
    //..................................................................................................................

    @GetMapping("/getall")
    public ModelAndView getEmp(){
        ModelAndView mav = new ModelAndView(page);
        mav.addObject("emp", serviceLayer.getEmpService());  //**Get All API
        return mav;
    }
    //..................................................................................................................
    @GetMapping("/getEmpByName")
    public ModelAndView getEmpByName(@RequestParam String name){
    logger.info(name);
        ModelAndView mav = new ModelAndView(page);                      //** get by Name
        mav.addObject("emp",serviceLayer.getbyName(name));
        return mav;
    }
    //..................................................................................................................
    @GetMapping("/deleteEmpById")
    public ModelAndView  deleteById( @RequestParam String id){
        logger.info(id);
        ModelAndView mav = new ModelAndView(page);                      //** Delete By Id
        mav.addObject("emp", serviceLayer.deleteById(id));
        return mav;
    }
    //..................................................................................................................

    @GetMapping("/getEmpById")
    public ModelAndView getEmpById(@RequestParam String id){
        logger.info(id);
        ModelAndView mav = new ModelAndView(page);                      //**Get By ID API
        mav.addObject("emp",serviceLayer.getById(id));
        return mav;
    }
    //..................................................................................................................
    @GetMapping("/addEmp")
    public ModelAndView addEmp(@RequestParam String id,@RequestParam String name, @RequestParam String address){
        ModelAndView mav = new ModelAndView(page);
        Employees emp = new Employees(id,name,address);
        logger.info("{}",emp);                                              //**Post API
        mav.addObject("emp",emp);
        serviceLayer.saveEmp(emp);
        return mav;
    }
//......................................................................................................................

}
