package com.parla.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Record {

    @Id
    private String id;

    private String original;

    private String translation;

}
