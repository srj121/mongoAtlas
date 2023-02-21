package com.mongoAtlas.mongoAtlas.repository;
import com.mongoAtlas.mongoAtlas.entity.Employees;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryClass  {
private final MongoTemplate mongotemplete;

    private static final String collectionName = "table";
    public RepositoryClass(final MongoTemplate mongoTemplate){ this.mongotemplete = mongoTemplate;}

    public List<Employees> findAll(){
        return mongotemplete.findAll(Employees.class,collectionName);
    }
    public Employees getByName(String name){
        return mongotemplete.findById(name,Employees.class,collectionName);
    }

    public String save(String data){
        return mongotemplete.save(data,collectionName);
    }
}
