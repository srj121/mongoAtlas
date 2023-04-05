package com.mongoAtlas.mongoAtlas.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("table")
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Employees {

@Id
    String id;
    String name;
    String address;

}
