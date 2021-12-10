package com.trello.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Label {
    private String id;
    private String name;
}
