package com.mongoAtlas.mongoAtlas.repository;
import com.mongoAtlas.mongoAtlas.entity.Employees;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public List<Employees> getByName(String name){
        Query query = new Query(Criteria.where("name").is(name));

        return mongotemplete.find(query,Employees.class);
    }
    public Employees getById(String id){
        Query query = new Query(Criteria.where("_id").is(id));

        return mongotemplete.findOne(query,Employees.class);
    }

    public Employees deleteById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return mongotemplete.findAndRemove(query,Employees.class);

    }
    public void save(Employees emp){
         mongotemplete.save(emp,collectionName);

    }


}
