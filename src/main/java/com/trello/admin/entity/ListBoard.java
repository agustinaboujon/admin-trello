package com.trello.admin.entity;

import lombok.Data;

@Data
public class ListBoard {
    private String id;
    private String name;
    private Boolean closed;
    private Long pos;
    private String softLimit;
    private String idBoard;
    private Boolean suscribed;
}
