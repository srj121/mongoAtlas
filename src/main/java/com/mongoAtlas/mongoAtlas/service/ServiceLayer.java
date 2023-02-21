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
    public List<Employees> getempService(){

        return repositoryClass.findAll();

    }
    public Employees getbyname(String name){
        return repositoryClass.getByName(name);
    }
    public String saveEmp(String name){
        return repositoryClass.save(name);
    }

}
