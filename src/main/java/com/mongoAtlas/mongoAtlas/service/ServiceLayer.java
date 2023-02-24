package com.mongoAtlas.mongoAtlas.service;

import com.mongoAtlas.mongoAtlas.entity.Employees;
import com.mongoAtlas.mongoAtlas.repository.RepositoryClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    private  Employees employees;
    private final RepositoryClass repositoryClass;

    private ServiceLayer(RepositoryClass repositoryClass){
        this.repositoryClass = repositoryClass;
    }
    public List<Employees> getEmpService(){

        return repositoryClass.findAll();

    }
    public List<Employees> getbyName(String name){
        return repositoryClass.getByName(name);
    }
    public void  saveEmp(Employees emp){
        repositoryClass.save(emp);
    }

    public Employees getById(String id){
        return repositoryClass.getById(id);
    }
    public Employees deleteById(String id){
        return repositoryClass.deleteById(id);
    }


}
