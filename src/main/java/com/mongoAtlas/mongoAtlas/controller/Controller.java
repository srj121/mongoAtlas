package com.mongoAtlas.mongoAtlas.controller;

import com.mongoAtlas.mongoAtlas.entity.Employees;
import com.mongoAtlas.mongoAtlas.service.ServiceLayer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final ServiceLayer serviceLayer;
     Controller(ServiceLayer serviceLayer){this.serviceLayer = serviceLayer;}

    @GetMapping("/getemp")
    public List<Employees> getEmp(){
        return serviceLayer.getempService();
    }
    @GetMapping("/addempbyid/{name}")
    public Employees getEmp(@PathVariable ("name") @RequestBody Employees employ, String name){

         return serviceLayer.getbyname(name);

    }
    @PostMapping("/addemp")
    public String addEmp(@RequestBody Employees employ, String name){
         return serviceLayer.saveEmp(name);
    }
}
