package com.trello.admin.entity;

import lombok.Data;

@Data
public class Card {
    private String id;
    private String title;
    private String description;
    private String list;
    private String member;
    private String label;
}
