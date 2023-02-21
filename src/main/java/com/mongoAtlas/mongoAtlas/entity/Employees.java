package com.mongoAtlas.mongoAtlas.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter @Setter
@Document("table")
public class Employees {

@Id
    String id;
    String name;
    String address;


}
