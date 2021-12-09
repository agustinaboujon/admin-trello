package com.trello.admin.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class Card {
    private String id;
    @Nullable
    private String title;
    @Nullable
    private String description;
    private String list;
    private String member;
    @Nullable
    private String label;
}
