package com.mongoAtlas.mongoAtlas.controller;

import com.mongoAtlas.mongoAtlas.entity.Employees;
import com.mongoAtlas.mongoAtlas.service.ServiceLayer;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController
@Api(value = "myController", description = "APi in controller")
public class ControllerClass1 {
    private static final Logger logger = LoggerFactory.getLogger(ControllerClass1.class);
    private static final String page = "list-employees";
    private final ServiceLayer serviceLayer;
     ControllerClass1(ServiceLayer serviceLayer)
     {this.serviceLayer = serviceLayer;}


    //..................................................................................................................

    @ApiOperation(value = "Get All the employees", response = Employees.class, responseContainer = "List")
    @GetMapping("/getall")
    public ModelAndView getEmp(){
        ModelAndView mav = new ModelAndView(page);
        mav.addObject("emp", serviceLayer.getEmpService());  //**Get All
        return mav;
    }
    //..................................................................................................................
    @ApiOperation(value = "Get employees by name", response = Employees.class, responseContainer = "List")
    @GetMapping("/getEmpByName")
    public ModelAndView getEmpByName(@RequestParam String name) {
    logger.info(name);
        ModelAndView mav = new ModelAndView(page);                      //** get by Name
        mav.addObject("emp",serviceLayer.getbyName(name));
        return mav;
    }
    //..................................................................................................................
    @ApiOperation(value = "Delete employees by Id", response = Employees.class)
    @GetMapping("/deleteEmpById")
    public ModelAndView  deleteById( @RequestParam String id) {
        logger.info(id);
        ModelAndView mav = new ModelAndView(page);                      //** Delete By Id
        mav.addObject("emp", serviceLayer.deleteById(id));
        return mav ;
    }
    //..................................................................................................................

    @ApiOperation(value = "Get employees by Id", response = Employees.class, responseContainer = "List")
    @GetMapping("/getEmpById")
    public ModelAndView getEmpById(@RequestParam String id) {
        logger.info(id);
        ModelAndView mav = new ModelAndView(page);                      //**Get By ID
        mav.addObject("emp",serviceLayer.getById(id));
        return mav;
    }
    //..................................................................................................................
    @ApiOperation(value = "Add employee ", response = Employees.class, responseContainer = "List")
    @GetMapping("/addEmp")
    public ModelAndView addEmp(@Validated @RequestParam String id, @RequestParam String name, @RequestParam String address) {
        ModelAndView mav = new ModelAndView(page);
        Employees emp = new Employees(id,name,address);
        logger.info("{}",emp);                                              //**Post API
        mav.addObject("emp",emp);
        serviceLayer.saveEmp(emp);
        return mav;
    }
//......................................................................................................................

}
