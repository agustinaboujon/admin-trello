package com.trello.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Card {
    private String id;
    private String title;
    private String description;
    private String list;
    private String member;
    private String category;
    private String type;
}
